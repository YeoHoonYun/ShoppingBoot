package yun.test.shoppingboot.contoller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import yun.test.shoppingboot.service.CategoryService;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequiredArgsConstructor
public class AboutController {
    private final CategoryService categoryService;
    @GetMapping(value = "/about")
    public String about(Model model, HttpServletResponse response){
        model.addAttribute("categorys",categoryService.categoryListAll());
        return "/about";
    }
}
