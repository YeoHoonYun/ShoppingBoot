package yun.test.shoppingboot.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import yun.test.shoppingboot.service.CategoryService;
import yun.test.shoppingboot.service.CompanyService;

@Controller
public class OrderContoller {
    @Autowired
    CategoryService categoryService;
    @Autowired
    CompanyService companyService;

    @GetMapping(value = {"/order"})
    public String orderMain(Model model,
                       @RequestParam(value = "p", defaultValue = "1") int p) {
        model.addAttribute("categorys", categoryService.categoryListAll());
        model.addAttribute("companies", companyService.categoryListAll(p-1));
        return "order";
    }
}
