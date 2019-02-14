package yun.test.shoppingboot.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import yun.test.shoppingboot.security.SecurityUser;
import yun.test.shoppingboot.service.CategoryService;
import yun.test.shoppingboot.service.ProductService;

@Controller
public class MainContoller {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;

    @GetMapping(value = {"/", "/main"})
    public String main(Model model, @AuthenticationPrincipal SecurityUser user,
                       @RequestParam(value = "p", defaultValue = "1") int p) {
        try {
            System.out.println(user.toString());
        }catch (Exception e){
            e.printStackTrace();
        }

        model.addAttribute("products",productService.productPageListAll(p-1));
        model.addAttribute("categorys",categoryService.categoryListAll());
        return "/main";
    }
    @GetMapping(value = {"/category"})
    public String categoryMain(Model model,
                             @RequestParam(value = "category", defaultValue = "") Long categoryId,
                             @RequestParam(value = "p", defaultValue = "1") int p) {
        model.addAttribute("products",productService.productByCategory(categoryId,p-1));
        model.addAttribute("categorys",categoryService.categoryListAll());
        return "/main";
    }

    @PostMapping(value = {"/search"})
    public String searchMain(Model model,
                               @RequestParam(value = "search", defaultValue = "") String name,
                               @RequestParam(value = "p", defaultValue = "1") int p) {
        model.addAttribute("products",productService.productByName(name,p-1));
        model.addAttribute("categorys",categoryService.categoryListAll());
        return "/main";
    }
}
