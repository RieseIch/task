package by.eugen.dao;


import by.eugen.pojo.Order;
import org.springframework.stereotype.Repository;

@Repository("orderDao")
public class OrderDaoImpl extends GenericDaoImpl<Order, Long> implements OrderDao {

    public OrderDaoImpl() {
        super(Order.class);
    }

}
