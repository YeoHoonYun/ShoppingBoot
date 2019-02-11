package yun.test.shoppingboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import yun.test.shoppingboot.dao.OrderDao;
import yun.test.shoppingboot.domain.Order;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    OrderDao orderDao;

    private final static int MAX_SIZE = 5;

    public Page<Order> orderByAll(String state, int p){
        Pageable page = PageRequest.of(p,MAX_SIZE);
        Page<Order> orders = orderDao.orderByAll(state, page);
        return orders;
    }
}
