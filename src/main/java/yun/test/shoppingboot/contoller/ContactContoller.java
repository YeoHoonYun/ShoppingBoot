package yun.test.shoppingboot.contoller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import yun.test.shoppingboot.domain.Contact;
import yun.test.shoppingboot.service.CategoryService;
import yun.test.shoppingboot.service.ContactService;

@Controller
@RequiredArgsConstructor
public class ContactContoller {
    private final CategoryService categoryService;
    private final ContactService contactService;

    @GetMapping(value = {"/company/contact"})
    public String contactMain(Model model,
                       @RequestParam(value = "p", defaultValue = "1") int p,
                       @RequestParam(value = "id", required = false, defaultValue = "") Long id) {
        Page<Contact> contacts = contactService.contactListAll(p-1, id);
        model.addAttribute("categorys",categoryService.categoryListAll());
        model.addAttribute("companyname", contacts.iterator().next().getCompany().getName());
        model.addAttribute("contacts", contacts);
        return "/company/contact";
    }
}
