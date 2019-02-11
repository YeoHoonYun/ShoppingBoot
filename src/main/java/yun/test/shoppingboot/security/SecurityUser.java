package yun.test.shoppingboot.security;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by cjswo9207u@gmail.com on 2019-02-11
 * Github : https://github.com/YeoHoonYun
 */

@Getter
@Setter
@ToString
public class SecurityUser extends User {
    private Long id;
    private String nickName;
    private String name;
    private String address;
    private Timestamp regDate;

    public SecurityUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, true, true, true, true, authorities);
    }

    public String getEmail() { return super.getUsername();}

}
