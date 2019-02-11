package yun.test.shoppingboot.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import yun.test.shoppingboot.domain.User;
import yun.test.shoppingboot.service.CategoryService;
import yun.test.shoppingboot.service.ProductService;
import yun.test.shoppingboot.service.UserService;

/**
 * Created by cjswo9207u@gmail.com on 2019-02-11
 * Github : https://github.com/YeoHoonYun
 */
@Controller
public class LoginController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String login(
            @RequestParam(name = "fail",
                    required = false,
                    defaultValue = "false") String errorFlag){

        return "/login"; // view name 을 리턴한다.
    }

//    @GetMapping(value = {"/logout"})
//    public void logout(HttpSecurity security) throws Exception {
////        Cookie kc = new Cookie("JSESSIONID", null); // choiceCookieName(쿠키 이름)에 대한 값을 null로 지정
////        kc.setMaxAge(0); // 유효시간을 0으로 설정
////        response.addCookie(kc); // 응답 헤더에 추가해서 없어지도록 함
//        security.logout().logoutSuccessUrl("/login").permitAll();
//    }

    @GetMapping(value = {"/join"})
    public String main(Model model,
                       @RequestParam(value = "p", defaultValue = "1") int p) {
        model.addAttribute("products",productService.productPageListAll(p-1));
        model.addAttribute("categorys",categoryService.categoryListAll());
        return "join";
    }

    @PostMapping("/join")
    public String joinUser(@RequestParam(value = "inputName") String name,
                           @RequestParam(value = "address") String address,
                           @RequestParam(value = "inputEmail") String email,
                           @RequestParam(value = "nickName") String nickName,
                           @RequestParam(value = "inputPassword") String inputPassword,
                           @RequestParam(value = "inputPasswordCheck") String inputPasswordCheck){
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        String passwd = passwordEncoder.encode(inputPassword);
        User user = new User(name, address, email, nickName, passwd);
        System.out.println(user.toString());
        userService.addUser(user);
        return "/login";
    }
}
