package yun.test.shoppingboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import yun.test.shoppingboot.dao.ContactDao;
import yun.test.shoppingboot.domain.Contact;

@Service
public class ContactServiceImpl implements ContactService{
    @Autowired
    ContactDao contactDao;

    private final static int MAX_SIZE = 10;

    @Override
    public Page<Contact> contactListAll(int p, Long id){
        Pageable page = PageRequest.of(p,MAX_SIZE);
        Page<Contact> companies = contactDao.contactListAll(page, id);
        return companies;
    }
}
