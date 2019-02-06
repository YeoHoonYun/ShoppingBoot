package yun.test.shoppingboot.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "company")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Company {
    @Id
    @Column(name = "idcompany")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idcompany;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "company")
    private List<Product> productList;
    @OneToMany(mappedBy = "company")
    private List<Contact> contactList;

}
