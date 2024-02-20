package lecture9.homework;

@Table(title = "person")
public class Person {

    @Column
    int id; // package-private чтобы потом не делать setAccessible(true) в Processor классе

    @Column
    String name;

    @Column
    int age;

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
