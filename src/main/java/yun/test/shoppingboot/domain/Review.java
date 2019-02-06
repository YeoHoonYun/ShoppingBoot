package yun.test.shoppingboot.domain;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "review")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Review {
    @Id
    @Column(name = "idreview")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idreview;
    @ManyToOne
    @JoinColumn(name = "iduser")
    private User user;
    @ManyToOne
    @JoinColumn(name = "idproduct")
    private Product product;
    @Column(name = "title")
    private String title;
    @Column(name = "content")
    private String content;
    @Column(name = "reg_date")
    private Timestamp regDate;

}
