package yun.test.shoppingboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yun.test.shoppingboot.dao.ReviewDao;
import yun.test.shoppingboot.domain.Review;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService{
    @Autowired
    ReviewDao reviewDao;
    @Override
    public List<Review> getReviewByProductId(Long id) {
        List<Review> reviews = reviewDao.getReviewByProductId(id);
        return reviews;
    }
}
