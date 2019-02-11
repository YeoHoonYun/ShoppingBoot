package yun.test.shoppingboot.service;

import org.springframework.data.domain.Page;
import yun.test.shoppingboot.domain.Order;

public interface OrderService {
    public Page<Order> orderByAll(String state, int p);
}
