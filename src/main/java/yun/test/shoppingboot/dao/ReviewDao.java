package yun.test.shoppingboot.dao;

import org.springframework.stereotype.Repository;
import yun.test.shoppingboot.domain.Review;

import java.util.List;

@Repository
public interface ReviewDao {
    public List<Review> getReviewByProductId(Long id);
}
