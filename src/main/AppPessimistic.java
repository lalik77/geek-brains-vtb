package main;

import main.java.lecture12.model.Item;
import main.java.lecture12.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.persistence.LockModeType;
import java.util.concurrent.CountDownLatch;

public class AppPessimistic {

    private static final int NUMBER_OF_THREADS = 8;

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(NUMBER_OF_THREADS);

        Runnable task = ()->{

            System.out.println("Таска работает на потоке " +
                    Thread.currentThread().getName());

            for (int i=0 ; i< 20000 ;i++) {
                Session currentSession = HibernateUtil.getSessionFactory().getCurrentSession();
                currentSession.beginTransaction();
                int rowNumber = (int) (Math.random() * 40) + 1;

                Item item = currentSession
                        .createQuery("FROM Item i WHERE i.id = :id", Item.class)
                        .setLockMode(LockModeType.PESSIMISTIC_READ)
                        .setParameter("id",rowNumber)
                        .getSingleResult();

                int valueToIncrease = item.getVal();
                item.setVal(++valueToIncrease);
                uncheckableSleep(5);
                System.out.println("RowNumber " + rowNumber + " , " + item
                        + " on " + Thread.currentThread().getName());

                try{
                    currentSession.getTransaction().commit();
                }catch (Exception e) {
                    System.err.println("During commit " + e);
                }

                if (currentSession != null) currentSession.close();
            }
            System.out.println("Выполнена таска потоком " + Thread.currentThread().getName());
            latch.countDown();
        };

        long start = System.currentTimeMillis();


        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            new Thread(task).start();
        }

        latch.await();
        long spent = System.currentTimeMillis() - start;
        System.out.println("Все задачи завершены. Главный поток возобновляется");
        System.out.println("Время выполнения: " + spent);

        System.out.println("Сумма всех значений 'val' : ");
        printSumOfVal();

    }

    public static void printSumOfVal() {

        try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
             Session currentSession = sessionFactory.getCurrentSession();
        ) {
            currentSession.beginTransaction();
            Query query = currentSession.createNativeQuery("SELECT SUM(val) AS total FROM items");
            Object singleResult = query.getSingleResult();
            System.out.println(singleResult);
        }
    }

    public static void uncheckableSleep(int ms) {

        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
