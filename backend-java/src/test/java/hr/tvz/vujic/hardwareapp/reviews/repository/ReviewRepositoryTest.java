package hr.tvz.vujic.hardwareapp.reviews.repository;

import hr.tvz.vujic.hardwareapp.reviews.Review;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReviewRepositoryTest {

    @Autowired
    ReviewRepository reviewRepository;

    @Test
    void findAll() {
        List<Review> reviewList = reviewRepository.findAll();

        Assertions.assertNotNull(reviewList);
        Assertions.assertEquals(reviewList.size(), 3);
    }

    @Transactional
    @DirtiesContext
    @Test
    void findByHardwareWithReviews_Code() {
        List<Review> reviewList = reviewRepository.findByHardwareWithReviews_Code("7731");

        Assertions.assertNotNull(reviewList);
        Assertions.assertFalse(reviewList.isEmpty());
    }
}