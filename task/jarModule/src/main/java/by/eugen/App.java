package by.eugen;

import by.eugen.dao.OrderDao;
import by.eugen.dao.UserDao;
import by.eugen.daoExceptions.DaoExceptions;
import by.eugen.pojo.Order;
import by.eugen.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


public class App 
{

    public static void main( String[] args ) throws DaoExceptions {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/service-context.xml");

        OrderService orderService = (OrderService)context.getBean("orderService");

        List<Order> list =  orderService.getAll();

        System.out.println(list.get(0));


    }
}
