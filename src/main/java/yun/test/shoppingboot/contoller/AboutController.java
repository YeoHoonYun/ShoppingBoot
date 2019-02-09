package yun.test.shoppingboot.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import yun.test.shoppingboot.service.CategoryService;

@Controller
public class AboutController {
    @Autowired
    CategoryService categoryService;
    @GetMapping(value = "/about")
    public String about(Model model){
        model.addAttribute("categorys",categoryService.categoryListAll());
        return "about";
    }
}
