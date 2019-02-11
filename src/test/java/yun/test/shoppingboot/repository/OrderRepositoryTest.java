package yun.test.shoppingboot.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;
import yun.test.shoppingboot.domain.Order;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class OrderRepositoryTest {
    @Autowired
    OrderRepository orderRepository;

    @Test
    public void productAll() throws Exception{
        Pageable page = PageRequest.of(0,6);
        Page<Order> all = orderRepository.getOrderByState("",page);
        System.out.println(all.getTotalElements());
        for(Order order : all){
            System.out.println(order.getState());
        }
    }
}
