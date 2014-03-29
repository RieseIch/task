package by.eugen;

import by.eugen.dao.OrderDao;
import by.eugen.daoExceptions.DaoExceptions;
import by.eugen.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public List<Order> getAll() throws DaoExceptions {
        return orderDao.findAll();  //To change body of implemented methods use File | Settings | File Templates.
    }
}
