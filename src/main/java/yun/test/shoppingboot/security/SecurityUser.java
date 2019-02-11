package yun.test.shoppingboot.security;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * Created by cjswo9207u@gmail.com on 2019-02-11
 * Github : https://github.com/YeoHoonYun
 */

@Getter
@Setter
public class SecurityUser extends User {
    private Long id;
    private String nickName;
    private String name;

    public SecurityUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, true, true, true, true, authorities);
    }

    public String getEmail() { return super.getUsername();}

}
