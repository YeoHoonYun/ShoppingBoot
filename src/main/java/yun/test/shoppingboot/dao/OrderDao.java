package yun.test.shoppingboot.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import yun.test.shoppingboot.domain.Order;

public interface OrderDao {
    public Page<Order> orderByAll(String state, Pageable pageable);
}
