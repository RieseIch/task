package by.eugen.pojo;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="dishes")
public class Dish implements Serializable {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="NAME")
    private String name;
    @Column(name="PRICE")
    private Integer price;
    @Column(name="DESCRIPTION")
    private String description;
    @Column(name="PARENT_ID")
    private Long parentId;

    public void Dish(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dish dish = (Dish) o;

        if (description != null ? !description.equals(dish.description) : dish.description != null) return false;
        if (id != null ? !id.equals(dish.id) : dish.id != null) return false;
        if (name != null ? !name.equals(dish.name) : dish.name != null) return false;
        if (parentId != null ? !parentId.equals(dish.parentId) : dish.parentId != null) return false;
        if (price != null ? !price.equals(dish.price) : dish.price != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (parentId != null ? parentId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", parentId=" + parentId +
                '}';
    }
}
