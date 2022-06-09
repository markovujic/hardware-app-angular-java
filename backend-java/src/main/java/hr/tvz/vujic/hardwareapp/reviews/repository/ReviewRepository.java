package hr.tvz.vujic.hardwareapp.reviews.repository;

import hr.tvz.vujic.hardwareapp.reviews.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findAll();

    List<Review> findByHardwareWithReviews_Code(final String code);

}
