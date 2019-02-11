package yun.test.shoppingboot.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import yun.test.shoppingboot.service.CategoryService;
import yun.test.shoppingboot.service.ProductService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class MainContoller {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;

    @GetMapping(value = {"/", "main"})
    public String main(Model model, HttpSecurity security,
                       @RequestParam(value = "p", defaultValue = "1") int p) {
//        security.authorizeRequests().
        model.addAttribute("products",productService.productPageListAll(p-1));
        model.addAttribute("categorys",categoryService.categoryListAll());
        return "main";
    }
    @GetMapping(value = {"/category"})
    public String categoryMain(Model model,
                             @RequestParam(value = "category", defaultValue = "") Long categoryId,
                             @RequestParam(value = "p", defaultValue = "1") int p) {
        model.addAttribute("products",productService.productByCategory(categoryId,p-1));
        model.addAttribute("categorys",categoryService.categoryListAll());
        return "main";
    }

    @PostMapping(value = {"/search"})
    public String searchMain(Model model,
                               @RequestParam(value = "search", defaultValue = "") String name,
                               @RequestParam(value = "p", defaultValue = "1") int p) {
        model.addAttribute("products",productService.productByName(name,p-1));
        model.addAttribute("categorys",categoryService.categoryListAll());
        return "main";
    }
}
