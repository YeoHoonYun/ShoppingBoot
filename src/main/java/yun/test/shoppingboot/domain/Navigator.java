package yun.test.shoppingboot.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "Navigator")
@Getter
@Setter
@ToString
public class Navigator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long navigatorId;

    @Column(name = "name")
    private String name;

}
