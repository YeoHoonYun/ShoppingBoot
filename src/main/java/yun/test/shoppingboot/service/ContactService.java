package yun.test.shoppingboot.service;

import org.springframework.data.domain.Page;
import yun.test.shoppingboot.domain.Contact;

public interface ContactService {
    public Page<Contact> contactListAll(int p, Long id);
}
