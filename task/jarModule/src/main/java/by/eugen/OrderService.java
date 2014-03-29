package by.eugen;

import by.eugen.daoExceptions.DaoExceptions;
import by.eugen.pojo.Order;

import java.util.List;

public interface OrderService {

   public List<Order> getAll() throws DaoExceptions;


}
