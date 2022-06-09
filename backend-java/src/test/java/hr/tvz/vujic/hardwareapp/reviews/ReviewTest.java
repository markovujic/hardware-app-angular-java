package hr.tvz.vujic.hardwareapp.reviews;

import hr.tvz.vujic.hardwareapp.hardware.Hardware;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReviewTest {

    @Test
    void isRatingCommon_true() {
        Review review = new Review();
        review.setRating(4);

        Assertions.assertTrue(review.isRatingCommon());
    }

    @Test
    void isRatingCommon_false() {
        Review review = new Review();
        review.setRating(0);

        Assertions.assertFalse(review.isRatingCommon());
    }

    @Test
    void isRatingCommon_illegalArgument() {
        Review review = new Review();
        review.setRating(6);

        Assertions.assertThrows(IllegalArgumentException.class, review::isRatingCommon);
    }

}