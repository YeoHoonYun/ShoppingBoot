package yun.test.shoppingboot.contoller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import yun.test.shoppingboot.security.SecurityUser;
import yun.test.shoppingboot.service.CategoryService;
import yun.test.shoppingboot.service.ProductService;

@Controller
@RequiredArgsConstructor
public class MainContoller {
    private final CategoryService categoryService;
    private final ProductService productService;

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

    @RequestMapping(value = {"/search"})
    public String searchMain(Model model,
                               @RequestParam(value = "name",required = false, defaultValue = "") String name,
                               @RequestParam(value = "p",required = false, defaultValue = "1") int p) {
        System.out.println("fffffffffffffffffffffffff"+name);
        model.addAttribute("products",productService.productByName(name,p-1));
        model.addAttribute("categorys",categoryService.categoryListAll());
        return "/main";
    }
}
