package yun.test.shoppingboot.contoller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import yun.test.shoppingboot.domain.User;
import yun.test.shoppingboot.service.CategoryService;
import yun.test.shoppingboot.service.ProductService;
import yun.test.shoppingboot.service.UserService;
import yun.test.shoppingboot.service.UserServiceImpl;

import javax.validation.Valid;

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
    UserServiceImpl userService;

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

//    에러 체크
//    Form데이터를 DTO로 파라미터를 받아들일 경우엔 @ModelAttribute JoinForm joinForm
//    DTO에 Validation 관련 어노테이션을 사용했을 경우에는 @Valid를 사용한다.
    @PostMapping("/join")
    public String joinUser(@RequestParam(value = "inputName") String name,
                           @RequestParam(value = "address") String address,
                           @RequestParam(value = "inputEmail") String email,
                           @RequestParam(value = "nickName") String nickName,
                           @RequestParam(value = "inputPassword") String inputPassword,
//                           @ModelAttribute User user, // Input valuse가 맞아 떨어져야함...
//                           @Valid User user, BindingResult bindingResult,
                           @RequestParam(value = "inputPasswordCheck") String inputPasswordCheck){
//        if(name == null || name.length() < 2){
//            throw new IllegalArgumentException("이름을 입력하세요..");
//        }
//        if(bindingResult.hasErros()){
//            throw new IllegalArgumentException((bindingResult.toString));
//        }
//        if(!joinFrom.getPassword1().equals(joinFrom.getPassword2()))
//            throw new IllegalArgumentException("이름을 입력하세요..");

        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        String passwd = passwordEncoder.encode(inputPassword);
        User userAdd = new User();
//        name, address, email, nickName, passwd
        userAdd.setName(name);
        userAdd.setAddress(address);
        userAdd.setEmail(email);
        userAdd.setNickName(nickName);
        userAdd.setPasswd(passwd);
        System.out.println(userAdd.toString());
        userService.addUser(userAdd);
        return "/login";
    }
}
