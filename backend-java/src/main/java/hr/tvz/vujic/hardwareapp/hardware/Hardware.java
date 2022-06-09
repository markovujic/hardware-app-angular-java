package hr.tvz.vujic.hardwareapp.hardware;

import hr.tvz.vujic.hardwareapp.reviews.Review;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name="hardware")
public class Hardware implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String code;
    private Double price;
    private String type;
    private Integer stock;

    @OneToMany(mappedBy="hardwareWithReviews", fetch=FetchType.EAGER)
    private List<Review> reviewList;

    public Hardware() {}

    public Hardware(Long id, String name, String code, Double price, String type, Integer stock) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.price = price;
        this.type = type;
        this.stock = stock;
    }

    public Hardware(String name, String code, Double price, String type, Integer stock) {
        this.name = name;
        this.code = code;
        this.price = price;
        this.type = type;
        this.stock = stock;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer numberOfPiecesInStock) {
        this.stock = numberOfPiecesInStock;
    }

    public List<Review> getReviewList() {
        return reviewList;
    }

    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
    }

    @Transient
    public boolean isPriceCommon() {
        if(this.price < 0) {
            throw new IllegalArgumentException("Price can not be lower than 0");
        }
        return this.price > 50;
    }

    @Transient
    public boolean isStockCommon() {
        if(this.stock < 0) {
            throw new IllegalArgumentException("Price can not be lower than 1");
        }
        return this.stock > 0;
    }
}
