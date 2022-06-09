package hr.tvz.vujic.hardwareapp.reviews;

import hr.tvz.vujic.hardwareapp.hardware.Hardware;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="review")
public class Review implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String text;
    private Integer rating;

    @ManyToOne
    @JoinColumn(name="hardware_id", nullable = false)
    private Hardware hardwareWithReviews;

    public Review() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Hardware getHardwareWithReviews() {
        return hardwareWithReviews;
    }

    public void setHardwareWithReviews(Hardware hardwareWithReviews) {
        this.hardwareWithReviews = hardwareWithReviews;
    }

    @Transient
    public boolean isRatingCommon() {
        if(this.rating < 0 || this.rating > 5) {
            throw new IllegalArgumentException("Price can not be lower than 0");
        }
        return this.rating > 0;
    }

}
