package yun.test.shoppingboot.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "roles")
@Getter
@Setter
@ToString
public class Role {
    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;
    @Column(name = "name")
    private String name;
    @OneToMany
    @JoinColumn(name = "role_id")
    private List<Navigator> navigatorList;

    public Role() {
        this.navigatorList = new ArrayList<>();
    }
}
