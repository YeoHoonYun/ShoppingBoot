package yun.test.shoppingboot.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import yun.test.shoppingboot.domain.Review;
import yun.test.shoppingboot.repository.ReviewRepository;

import java.util.List;

@Repository
public class ReviewDaoImpl implements ReviewDao{
    @Autowired
    ReviewRepository reviewRepository;

    @Override
    public List<Review> getReviewByProductId(Long id) {
        List<Review> reviews = reviewRepository.getReviewByProductId(id);
        return reviews;
    }
}
