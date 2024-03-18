package main.java.lecture12.model;

import javax.persistence.*;

@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;

    @Column(name = "val")
    Integer val;

    @Version
    long version;

    public Item() {
    }

    public Item(Integer val) {
        this.val = val;
    }

    public void setVal(Integer val) {
        this.val = val;
    }

    public Integer getVal() {
        return val;
    }

    public long getVersion() {
        return version;
    }

    @Override
    public String toString() {
        return String.format("Item [id = %d, val = %d, version = %d]", id, val, version);
    }
}
