package yun.test.shoppingboot.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import yun.test.shoppingboot.domain.Review;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ReviewRepositoryTest {
    @Autowired
    ReviewRepository reviewRepository;
    @Test
    public void productById() throws Exception{
        List<Review> products= reviewRepository.getReviewByProductId(2L);
        for(Review review: products){
            System.out.println(review.getUser().getNickName());
        }
    }
}
