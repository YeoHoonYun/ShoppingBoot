package yun.test.shoppingboot.domain;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "order")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Order {
    @Id
    @Column(name = "idorder")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idorder;
    @ManyToOne
    @JoinColumn(name = "iduser")
    private User user;
    @Column(name = "address")
    private String address;
    @Column(name = "state")
    private String state;
    @Column(name = "reg_date")
    private Timestamp regDate;

    @ManyToMany
    @JoinTable(name = "product_order",
            joinColumns = {@JoinColumn(name = "order_idorder",referencedColumnName = "idorder")},
            inverseJoinColumns = {@JoinColumn(name="product_idproduct",referencedColumnName = "idproduct")}
    )
    private List<Product> productList;
}
