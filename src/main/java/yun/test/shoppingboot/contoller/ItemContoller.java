package yun.test.shoppingboot.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ItemContoller {
    @GetMapping(value = "/item")
    public String itemPage(Model model){
        return "itemPage";
    }
}
