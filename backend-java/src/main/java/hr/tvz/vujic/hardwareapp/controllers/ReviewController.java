package hr.tvz.vujic.hardwareapp.controllers;

import hr.tvz.vujic.hardwareapp.reviews.ReviewDTO;
import hr.tvz.vujic.hardwareapp.reviews.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("review")
@CrossOrigin(origins = "http://localhost:4200")
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public List<ReviewDTO> getAllReviews(){
        return reviewService.findAll();
    }

    @GetMapping(params = "hardwareCode")
    public List<ReviewDTO> getAllReviewsByHardwareCode(@RequestParam final String hardwareCode){
        return reviewService.findByHardwareCode(hardwareCode);
    }

}
