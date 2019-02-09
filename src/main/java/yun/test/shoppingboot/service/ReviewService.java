package yun.test.shoppingboot.service;

import yun.test.shoppingboot.domain.Review;

import java.util.List;

public interface ReviewService {
    public List<Review> getReviewByProductId(Long id);
}
