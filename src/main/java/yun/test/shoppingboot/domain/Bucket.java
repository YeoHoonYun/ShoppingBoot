package yun.test.shoppingboot.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "bucket")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Bucket {
    @Id
    @Column(name = "idbucket")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idbucket;
    @ManyToOne
    @JoinColumn(name="iduser")
    private User user;
    @Column(name = "price")
    private int price;
    @Column(name = "quantity")
    private int quantity;

    @ManyToMany
    @JoinTable(name = "bucket_product",
            joinColumns = {@JoinColumn(name = "bucket_idbucket",referencedColumnName = "idbucket")},
            inverseJoinColumns = {@JoinColumn(name="product_idproduct",referencedColumnName = "idproduct")}
    )
    private List<Product> productList;
}
