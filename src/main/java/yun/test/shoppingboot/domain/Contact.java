package yun.test.shoppingboot.domain;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "contacts")
@Getter
@Setter
@ToString
public class Contact {
    @Id
    @Column(name = "contact_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contactId;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
    @Column(name = "content")
    private String content;
    @Column(name = "reg_date")
    private Timestamp regDate;
}
