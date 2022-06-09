package hr.tvz.vujic.hardwareapp.reviews.service;

import hr.tvz.vujic.hardwareapp.reviews.ReviewDTO;
import hr.tvz.vujic.hardwareapp.reviews.repository.ReviewRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ReviewServiceTest {

    @Autowired
    ReviewService reviewService;

    @MockBean
    ReviewRepository reviewRepository;

    @Test
    void findAll_empty() {

        when(reviewRepository.findAll()).thenReturn(Collections.emptyList());

        List<ReviewDTO> reviewDTOList = reviewService.findAll();
        Assertions.assertNotNull(reviewDTOList);
        Assertions.assertEquals(reviewDTOList.size(), 0);
    }

    @Test
    void findByHardwareCode_empty() {

        when(reviewRepository.findByHardwareWithReviews_Code("3344"))
                .thenReturn(Collections.emptyList());

        List<ReviewDTO> reviewDTOList = reviewService.findAll();
        Assertions.assertNotNull(reviewDTOList);
        Assertions.assertEquals(reviewDTOList.size(), 0);
    }
}