package by.eugen.pojo;


import by.eugen.util.BillStatus;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="orders")
public class Order implements Serializable {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name="USER_ID")
    @LazyCollection(LazyCollectionOption.FALSE)
    private User user;
    @Column(name="TABLE_NUMBER")
    private Integer table;
    @Column(name="TIME")
    private Date datetime;
    @Column(name="PRICE")
    private Integer price;
    @Column(name="BILL_STATUS")
    @Enumerated(value = EnumType.STRING)
    private BillStatus billStatus;

    @OneToMany(mappedBy = "dish", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.TRUE)
    private List<OrderedDishes> dishesList;

    public List<OrderedDishes> getDishesList() {
        return dishesList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getTable() {
        return table;
    }

    public void setTable(Integer table) {
        this.table = table;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public BillStatus getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(BillStatus billStatus) {
        this.billStatus = billStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (billStatus != order.billStatus) return false;
        if (datetime != null ? !datetime.equals(order.datetime) : order.datetime != null) return false;
        if (dishesList != null ? !dishesList.equals(order.dishesList) : order.dishesList != null) return false;
        if (id != null ? !id.equals(order.id) : order.id != null) return false;
        if (price != null ? !price.equals(order.price) : order.price != null) return false;
        if (table != null ? !table.equals(order.table) : order.table != null) return false;
        if (user != null ? !user.equals(order.user) : order.user != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (table != null ? table.hashCode() : 0);
        result = 31 * result + (datetime != null ? datetime.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (billStatus != null ? billStatus.hashCode() : 0);
        result = 31 * result + (dishesList != null ? dishesList.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user=" + user.toString() +
                ", table=" + table +
                ", datetime=" + datetime +
                ", price=" + price +
                ", billStatus=" + billStatus +
                '}';
    }
}
