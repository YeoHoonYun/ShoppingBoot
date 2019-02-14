package yun.test.shoppingboot.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import yun.test.shoppingboot.domain.Review;
import yun.test.shoppingboot.service.CategoryService;
import yun.test.shoppingboot.service.ProductService;
import yun.test.shoppingboot.service.ReviewService;

@Controller
public class ItemContoller {
    @Autowired
    ProductService productService;
    @Autowired
    ReviewService reviewService;
    @Autowired
    CategoryService categoryService;

    @GetMapping(value = "/item")
    public String itemPage(Model model, @RequestParam("id") Long id){
        model.addAttribute("product", productService.productById(id));
        model.addAttribute("reviews", reviewService.getReviewByProductId(id));
        model.addAttribute("categorys",categoryService.categoryListAll());
        return "/itemPage";
    }
}
