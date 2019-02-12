package yun.test.shoppingboot.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@ToString
@AllArgsConstructor
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @NotNull
    @Size(min = 2, max = 20)
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "email")
    private String email;
    @Column(name = "nickname")
    private String nickName;
    @Column(name = "passwd")
    private String passwd;
    @Column(name = "reg_date")
    private Timestamp regDate;

    @OneToMany(mappedBy = "user")
    private List<Bucket> bucketList;

    @ManyToMany
    @JoinTable(name = "roles_users",
            joinColumns = {@JoinColumn(name = "user_id",referencedColumnName = "user_id")},
            inverseJoinColumns = {@JoinColumn(name="role_id",referencedColumnName = "role_id")}
            )
    private Set<Role> roles;

    @OneToMany(mappedBy = "user")
    private List<Order> orderList;

    @OneToMany(mappedBy = "user")
    private List<Review> reviewList;

    public User() {
        this.bucketList = new ArrayList<>();
        this.roles = new HashSet<>();
        this.orderList = new ArrayList<>();
        this.reviewList = new ArrayList<>();
    }

    public void addRole(Role role) {
        if(roles == null)
            roles = new HashSet<>();
        roles.add(role);
    }
}
