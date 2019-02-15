package yun.test.shoppingboot.contoller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import yun.test.shoppingboot.service.CategoryService;
import yun.test.shoppingboot.service.CompanyService;

@Controller
@RequiredArgsConstructor
public class CompanyContoller {
    private final CategoryService categoryService;
    private final CompanyService companyService;

    @GetMapping(value = {"/company/list"})
    public String companyMain(Model model,
                       @RequestParam(value = "p", defaultValue = "1") int p) {
        model.addAttribute("categorys",categoryService.categoryListAll());
        model.addAttribute("companies", companyService.companyListAll(p-1));
        return "/company/list";
    }
}
