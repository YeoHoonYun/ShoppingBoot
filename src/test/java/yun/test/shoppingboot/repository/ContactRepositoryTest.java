package yun.test.shoppingboot.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;
import yun.test.shoppingboot.domain.Company;
import yun.test.shoppingboot.domain.Contact;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ContactRepositoryTest {
    @Autowired
    ContactRepository contactRepository;

    @Test
    public void productAll() throws Exception{
        Pageable page = PageRequest.of(0,6);
        Page<Contact> all = contactRepository.countContactById(page, 1L);
        System.out.println(all.getTotalElements());
        for(Contact contact : all){
            System.out.println(contact.getContent());
        }
    }
}
