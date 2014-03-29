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
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/database-context.xml");

        UserDao userDao = (UserDao)context.getBean("userDao");

        List<User> list =  userDao.findAll();

        System.out.println(list.get(0));

        OrderDao orderDao = (OrderDao)context.getBean("orderDao");

        List<Order> listOrder =  orderDao.findAll();

        System.out.println(listOrder.get(0));

    }
}
