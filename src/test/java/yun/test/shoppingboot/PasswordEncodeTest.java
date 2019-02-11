package yun.test.shoppingboot;

import org.junit.Test;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by cjswo9207u@gmail.com on 2019-02-11
 * Github : https://github.com/YeoHoonYun
 */
public class PasswordEncodeTest {
    @Test
    public void encode() throws Exception {
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        String encode = passwordEncoder.encode("1234");
        System.out.println(encode);
    }
}
