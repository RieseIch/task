package by.eugen.pojo;


import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="ordered_dishes")
public class OrderedDishes implements Serializable {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="ORDER_ID")
    private Long orderId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="DISH_ID")
    @LazyCollection(LazyCollectionOption.TRUE)
    private Dish dish;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderedDishes that = (OrderedDishes) o;

        if (dish != null ? !dish.equals(that.dish) : that.dish != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (orderId != null ? !orderId.equals(that.orderId) : that.orderId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (orderId != null ? orderId.hashCode() : 0);
        result = 31 * result + (dish != null ? dish.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "OrderedDishes{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", dish=" + dish.toString() +
                '}';
    }
}
