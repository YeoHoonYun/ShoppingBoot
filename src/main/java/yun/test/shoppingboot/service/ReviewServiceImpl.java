package yun.test.shoppingboot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yun.test.shoppingboot.domain.Review;
import yun.test.shoppingboot.repository.ReviewRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService{
    private final ReviewRepository reviewRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Review> getReviewByProductId(Long id) {
        List<Review> reviews = reviewRepository.getReviewByProductId(id);
        return reviews;
    }
}
