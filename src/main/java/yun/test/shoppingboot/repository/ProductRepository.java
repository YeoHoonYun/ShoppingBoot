package yun.test.shoppingboot.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import yun.test.shoppingboot.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p")
    public Page<Product> getProductAll(Pageable pageable);

    @Query("SELECT p FROM Product p WHERE product_id = :productId")
    Product getProductById(@Param("productId") Long productId);
}
