package yun.test.shoppingboot.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {
    @Id
    @Column(name = "idproduct")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idproduct;
    @ManyToOne
    @JoinColumn(name = "idcompany")
    private Company company;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private int price;
    @Column(name = "quanity")
    private int quanity;
    @Column(name = "file_path")
    private String filePath;

    @OneToMany(mappedBy = "product")
    private List<Review> reviewList;

}
