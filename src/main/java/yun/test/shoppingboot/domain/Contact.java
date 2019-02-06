package yun.test.shoppingboot.domain;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "contact")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idcontact;

    @ManyToOne
    @JoinColumn(name = "idcompany")
    private Company company;
    @Column(name = "content")
    private String content;
    @Column(name = "reg_date")
    private Timestamp regDate;
}
