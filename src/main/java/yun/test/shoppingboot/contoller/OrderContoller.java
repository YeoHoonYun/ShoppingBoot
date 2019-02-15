package yun.test.shoppingboot.contoller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import yun.test.shoppingboot.service.CategoryService;
import yun.test.shoppingboot.service.OrderService;

@Controller
@RequiredArgsConstructor
public class OrderContoller {
    private final CategoryService categoryService;
    private final OrderService orderService;

    @GetMapping(value = {"/order"})
    public String orderMain(Model model,
                       @RequestParam(value = "p", defaultValue = "1") int p) {
        model.addAttribute("categorys", categoryService.categoryListAll());
        model.addAttribute("orders_y", orderService.orderByAll("Y",p-1));
        model.addAttribute("orders_n", orderService.orderByAll("N",p-1));
        return "/order";
    }
}
