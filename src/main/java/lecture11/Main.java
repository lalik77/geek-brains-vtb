package lecture11;

import lecture11.model.Customer;
import lecture11.model.Item;
import lecture11.model.Purchase;
import lecture11.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {


        try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory()) {
            Scanner scanner = new Scanner(System.in);
            boolean running = true;

            while (running) {

                System.out.println("Введите команду: ");
                String command = scanner.nextLine();
                String[] parts = command.trim().split("\\s+");
                Pattern pattern;
                Matcher matcher;

                switch (parts[0]) {

                    case "/showProductsByPerson":
                        pattern = Pattern.compile("^\\/showProductsByPerson\\s+(\\S.*)$");
                        matcher = pattern.matcher(command);
                        if (matcher.matches()) {
                            String customerName = matcher.group(1);
                            showItemsByCustomer(customerName, sessionFactory);
                        } else {
                            System.out.println("Неверный формат команды");
                        }
                        break;

                    case "/findPersonsByProductTitle":
                        pattern = Pattern.compile("^\\/findPersonsByProductTitle\\s+(\\S.*)$");
                        matcher = pattern.matcher(command);
                        if (matcher.matches()) {
                            String itemName = matcher.group(1);
                            showCustomersByItem(itemName, sessionFactory);
                        } else {
                            System.out.println("Неверный формат команды");
                        }
                        break;

                    case "/removePerson":
                        pattern = Pattern.compile("^\\/removePerson\\s+(\\S.*)$");
                        matcher = pattern.matcher(command);

                        if (matcher.matches()) {
                            String customerName = matcher.group(1);
                            removeCustomer(customerName, sessionFactory);
                        } else {
                            System.out.println("Неверный формат команды");
                        }
                        break;

                    case "/removeProduct":
                        pattern = Pattern.compile("^\\/removeProduct\\s+(\\S.*)$");
                        matcher = pattern.matcher(command);
                        if (matcher.matches()) {
                            String itemName = matcher.group(1);
                            removeItem(itemName, sessionFactory);
                        } else {
                            System.out.println(parts[0] + " " + parts[1]);
                            System.out.println("Неверный формат команды");
                        }
                        break;

                    case "/buy":
                        pattern = Pattern.compile("^\\/buy\\s+(.+)$");
                        matcher = pattern.matcher(command);

                        if (matcher.matches()) {
                            parts = matcher.group(1).split("\\s+", 2);
                            if (parts.length == 2) {
                                String customerName = parts[0];
                                String itemName = parts[1];
                                buyItem(customerName, itemName, sessionFactory);
                            } else {
                                System.out.println("Неверный формат команды");
                            }
                        } else {
                            System.out.println("Неверный формат команды");
                        }
                        break;


                    case "/exit":
                        running = false;
                        break;
                    default:
                        System.out.println("Неизвестная команда");
                }
            }
            scanner.close();
        }
    }

    public static void showItemsByCustomer(String customerName, SessionFactory sessionFactory) {

        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.beginTransaction();
        Customer customer = getCustomerByName(customerName, currentSession);

        if (customer != null) {
            Set<Item> items = customer.getItems();
            StringJoiner joiner = new StringJoiner(", ");
            items.forEach(item -> joiner.add(item.getName()));
            System.out.println("Товары для клиента " + customerName + " следующие:  " + joiner.toString());
        } else {
            System.out.println("Клиент с именем " + customerName + "  не найден.");
        }
        currentSession.getTransaction().commit();

    }

    public static void showCustomersByItem(String itemName, SessionFactory sessionFactory) {

        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.beginTransaction();
        Item item = getItemByName(itemName, currentSession);

        if (item != null) {
            Set<Customer> customers = item.getCustomers();
            StringJoiner joiner = new StringJoiner(", ");
            customers.forEach(customer -> joiner.add(customer.getName()));
            System.out.println("Клиенты, заказавшие товар " + itemName + ", это:" + joiner.toString());
        } else {
            System.out.println("Товар с названием " + itemName + " не найден.");
        }
        currentSession.getTransaction().commit();

    }

    private static void removeCustomer(String customerName, SessionFactory sessionFactory) {

        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.beginTransaction();
        Customer customer = getCustomerByName(customerName, currentSession);

        if (customer != null) {
            currentSession.remove(customer);
        } else {
            System.out.println("Клиент с именем " + customerName + "  не найден.");
        }
        currentSession.getTransaction().commit();
    }

    private static void removeItem(String itemName, SessionFactory sessionFactory) {

        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.beginTransaction();
        Item item = getItemByName(itemName, currentSession);

        if (item != null) {
            currentSession.remove(item);
        } else {
            System.out.println("Товар с названием " + itemName + " не найден.");

        }
        currentSession.getTransaction().commit();
    }

    private static void buyItem(String customerName, String itemName, SessionFactory sessionFactory) {

        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.beginTransaction();
        Customer customerByName = getCustomerByName(customerName, currentSession);
        Item itemByName = getItemByName(itemName, currentSession);
        if (customerByName != null && itemByName != null) {
            Purchase purchase = new Purchase();
            purchase.setCustomer(customerByName);
            purchase.setItem(itemByName);
            purchase.setPurchasePrice(purchase.getPurchasePrice());
            purchase.setPurchaseDate(new Date());

            // Сохранить запись о покупке в базе данных
            currentSession.save(purchase);

            // Добавить товар клиенту
            customerByName.getItems().add(itemByName);
        } else {
            if (customerByName == null) {
                System.out.println("Покупатель с именем " + customerName + " не найден.");
            }
            if (itemByName == null) {
                System.out.println("Товар с названием " + itemName + " не найден.");
            }
        }
        currentSession.getTransaction().commit();
    }


    private static Item getItemByName(String itemName, Session currentSession) {

        String hql = "FROM Item WHERE name = :name";
        return currentSession.createQuery(hql, Item.class)
                .setParameter("name", itemName)
                .uniqueResult();
    }

    private static Customer getCustomerByName(String customerName, Session currentSession) {
        String hql = "FROM Customer WHERE name = :name";
        return currentSession.createQuery(hql, Customer.class)
                .setParameter("name", customerName)
                .uniqueResult();
    }


}
