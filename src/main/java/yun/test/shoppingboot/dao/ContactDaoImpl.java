package yun.test.shoppingboot.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import yun.test.shoppingboot.domain.Contact;
import yun.test.shoppingboot.repository.ContactRepository;

@Repository
public class ContactDaoImpl implements ContactDao{
    @Autowired
    ContactRepository contactRepository;

    public Page<Contact> contactListAll(Pageable pageable, Long id){
        Page<Contact> companies = contactRepository.countContactById(pageable, id);
        return companies;
    }
}
