package yun.test.shoppingboot.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "companys")
@Getter
@Setter
@ToString
public class Company {
    @Id
    @Column(name = "company_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyId;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "company")
    private List<Product> productList;
    @OneToMany(mappedBy = "company")
    private List<Contact> contactList;

    public Company(List<Product> productList, List<Contact> contactList) {
        this.productList = new ArrayList<>();
        this.contactList = new ArrayList<>();
    }
}
