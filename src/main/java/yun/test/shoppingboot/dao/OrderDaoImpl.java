package yun.test.shoppingboot.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import yun.test.shoppingboot.domain.Order;
import yun.test.shoppingboot.repository.OrderRepository;

@Repository
public class OrderDaoImpl implements OrderDao{
    @Autowired
    OrderRepository orderRepository;

    public Page<Order> orderByAll(String state, Pageable pageable){
        Page<Order> orders = orderRepository.getOrderByState(state, pageable);
        return orders;
    }
}
