package lecture11;

import lecture11.model.Customer;
import lecture11.model.Item;
import lecture11.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

public class Main {

    public static void main(String[] args) {


        try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory()) {
            Scanner scanner = new Scanner(System.in);
            boolean running = true;

            while (running) {

                System.out.println("Введите команду: ");
                String command = scanner.nextLine();

                switch (command.split(" ")[0]) {

                    case "/showProductsByPerson":
                        if (command.split(" ").length == 2) {
                            String customerName = command.split(" ")[1];
                            showItemsByCustomer(customerName, sessionFactory);
                        } else {
                            System.out.println("Неверный формат команды");
                        }
                        break;

                    case "/findPersonsByProductTitle":
                        if (command.split(" ").length == 2) {
                            String itemName = command.split(" ")[1];
                            showCustomersByItem(itemName, sessionFactory);
                        } else {
                            System.out.println("Неверный формат команды");
                        }
                        break;

                    case "/removePerson":
                        if (command.split(" ").length == 2) {
                            String customerName = command.split(" ")[1];
                            removeCustomer(customerName, sessionFactory);
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

    private static void removeCustomer(String customerName, SessionFactory sessionFactory) {

        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.beginTransaction();
        Customer customer = getCustomerByName(customerName, currentSession);
        currentSession.remove(customer);
        currentSession.getTransaction().commit();
    }

    public static void showItemsByCustomer(String customerName, SessionFactory sessionFactory) {

        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.beginTransaction();
        Customer customer = getCustomerByName(customerName, currentSession);

        if (customer != null) {
            List<Item> items = customer.getItems();
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
            List<Customer> customers = item.getCustomers();
            StringJoiner joiner = new StringJoiner(", ");
            customers.forEach(customer -> joiner.add(customer.getName()));
            System.out.println("Клиенты, заказавшие товар " + itemName + ", это:" + joiner.toString());
        } else {
            System.out.println("Товары с названием " + itemName + " не найдены.");
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
