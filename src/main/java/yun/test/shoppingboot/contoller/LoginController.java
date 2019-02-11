package yun.test.shoppingboot.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import yun.test.shoppingboot.service.CategoryService;
import yun.test.shoppingboot.service.ProductService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

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

    @GetMapping(value = {"/logout"})
    public void logout(HttpSecurity security) throws Exception {
//        Cookie kc = new Cookie("JSESSIONID", null); // choiceCookieName(쿠키 이름)에 대한 값을 null로 지정
//        kc.setMaxAge(0); // 유효시간을 0으로 설정
//        response.addCookie(kc); // 응답 헤더에 추가해서 없어지도록 함
        security.logout().logoutSuccessUrl("/login").permitAll();

//        return "/";
    }

    @GetMapping(value = {"join"})
    public String main(Model model,
                       @RequestParam(value = "p", defaultValue = "1") int p) {

        model.addAttribute("products",productService.productPageListAll(p-1));
        model.addAttribute("categorys",categoryService.categoryListAll());
        return "main";
    }
}
