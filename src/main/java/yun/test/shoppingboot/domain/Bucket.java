package yun.test.shoppingboot.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "buckets")
@Getter
@Setter
@ToString
public class Bucket {
    @Id
    @Column(name = "bucket_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bucketId;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;

    @Column(name = "quantity")
    private int quantity;
}
