package yun.test.shoppingboot.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import yun.test.shoppingboot.service.CategoryService;
import yun.test.shoppingboot.service.ProductService;

@Controller
public class MainContoller {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;

    @GetMapping(value = {"/", "main"})
    public String main(Model model) {
        model.addAttribute("products",productService.productPageListAll(0));
        model.addAttribute("categorys",categoryService.categoryListAll());
        return "main";
    }

    @PostMapping(value = {"/", "main"})
    public String searchMain(Model model) {
        return "main";
    }
}
