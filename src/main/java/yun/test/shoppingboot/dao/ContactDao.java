package yun.test.shoppingboot.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import yun.test.shoppingboot.domain.Contact;

public interface ContactDao {
    public Page<Contact> contactListAll(Pageable pageable, Long id);
}
