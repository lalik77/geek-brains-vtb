package lecture11.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="purchases")
public class Purchase {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name="item_id")
    private Item item;

    @Column(name="purchase_price")
    private BigDecimal purchasePrice;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="purchase_date")
    private Date purchaseDate;

    public Purchase() {
    }

    public Purchase(Customer customer, Item item, BigDecimal purchasePrice, Date purchaseDate) {
        this.customer = customer;
        this.item = item;
        this.purchasePrice = purchasePrice;
        this.purchaseDate = purchaseDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    // Getter for purchasePrice to be fetched from the Item table
    @Transient
    public BigDecimal getPurchasePrice() {
        if(item != null) {
            return item.getPrice();
        }
        return new BigDecimal(0);
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
}
