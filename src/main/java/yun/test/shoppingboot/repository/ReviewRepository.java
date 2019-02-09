package yun.test.shoppingboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import yun.test.shoppingboot.domain.Review;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    @Query("SELECT r FROM Review r WHERE product_id = :productId")
    List<Review> getReviewByProductId(@Param("productId") Long productId);
}
