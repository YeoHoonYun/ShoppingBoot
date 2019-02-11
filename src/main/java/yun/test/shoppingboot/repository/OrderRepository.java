package yun.test.shoppingboot.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import yun.test.shoppingboot.domain.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query(value = "SELECT o FROM Order o WHERE state LIKE CONCAT('%',UPPER(:state),'%')")
    public Page<Order> getOrderByState(@Param("state") String state, Pageable pageable);
}
