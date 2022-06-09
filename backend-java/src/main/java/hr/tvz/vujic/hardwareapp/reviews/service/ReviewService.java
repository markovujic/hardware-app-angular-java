package hr.tvz.vujic.hardwareapp.reviews.service;

import hr.tvz.vujic.hardwareapp.reviews.ReviewDTO;

import java.util.List;

public interface ReviewService {

    List<ReviewDTO> findAll();

    List<ReviewDTO> findByHardwareCode(String code);

}
