package yun.test.shoppingboot.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainContoller {

    @GetMapping(value = {"/", "main"})
    public String main(Model model) {
        return "main";
    }

    @PostMapping(value = {"/", "main"})
    public String searchMain(Model model) {
        return "main";
    }

    // TODO
//    @ResponseBody
//    @RequestMapping(value="/customer/eventViewGet.json")
//    public CustomerVO eventViewGet(ModelMap model, HttpServletRequest ret,  HttpServletResponse req, CustomerVO customerVO, @RequestParam("seq") String seq)
//            throws Exception {
//
//        CustomerVO result = new CustomerVO();
//        customerVO.setSeq(seq);
//        result=customerService.eventViewGet(customerVO);
//
//        System.out.println(result.getKeywords());
//
//        return result;
//    }
}
