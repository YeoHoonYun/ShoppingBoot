package yun.test.shoppingboot.domain;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    @Id
    @Column(name = "iduser")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iduser;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "email")
    private String email;
    @Column(name = "nickname")
    private String nickname;
    @Column(name = "passwd")
    private String passwd;
    @Column(name = "reg_date")
    private Timestamp regDate;

    @OneToMany(mappedBy = "user")
    private List<Bucket> bucketList;

    @ManyToMany
    @JoinTable(name = "role_user",
            joinColumns = {@JoinColumn(name = "user_iduser",referencedColumnName = "iduser")},
            inverseJoinColumns = {@JoinColumn(name="role_idrole",referencedColumnName = "idrole")}
            )
    private Set<Role> roles;

    @OneToMany(mappedBy = "user")
    private List<Order> orderList;

    @OneToMany(mappedBy = "user")
    private List<Review> reviewList;
}
