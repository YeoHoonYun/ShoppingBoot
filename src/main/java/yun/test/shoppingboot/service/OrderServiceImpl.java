package yun.test.shoppingboot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import yun.test.shoppingboot.domain.Order;
import yun.test.shoppingboot.repository.OrderRepository;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{
    private final OrderRepository orderRepository;

    private final static int MAX_SIZE = 5;

    public Page<Order> orderByAll(String state, int p){
        Pageable page = PageRequest.of(p,MAX_SIZE);
        Page<Order> orders = orderRepository.getOrderByState(state, page);
        return orders;
    }
}
