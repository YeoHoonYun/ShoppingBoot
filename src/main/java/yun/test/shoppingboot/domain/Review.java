package yun.test.shoppingboot.domain;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "reviews")
@Getter
@Setter
@ToString
public class Review {
    @Id
    @Column(name = "review_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @Column(name = "title")
    private String title;
    @Column(name = "content")
    private String content;
    @Column(name = "reg_date")
    private Timestamp regDate;

}
