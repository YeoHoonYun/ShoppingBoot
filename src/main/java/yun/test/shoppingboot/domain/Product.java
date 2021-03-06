package yun.test.shoppingboot.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
@Getter
@Setter
public class Product {
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
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

    @OneToMany(mappedBy = "product")
    private List<Order> orderList;

    @OneToMany(mappedBy = "product")
    private List<Bucket> bucketList;

    @OneToMany(
            mappedBy = "product",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<ImageFile> imageFiles;

    public Product() {
        this.bucketList = new ArrayList<>();
        this.orderList = new ArrayList<>();
        this.reviewList = new ArrayList<>();
        this.imageFiles = new ArrayList<>();
    }
    public void addImageFile(ImageFile imageFile){
        if(imageFiles == null)
            imageFiles = new ArrayList<>();
        imageFile.setProduct(this);
        imageFiles.add(imageFile);
    }
}
