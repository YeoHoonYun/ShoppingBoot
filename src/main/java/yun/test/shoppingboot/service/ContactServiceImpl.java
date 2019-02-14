package yun.test.shoppingboot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import yun.test.shoppingboot.domain.Contact;
import yun.test.shoppingboot.repository.ContactRepository;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService{
    private final ContactRepository contactRepository;

    private final static int MAX_SIZE = 10;

    @Override
    public Page<Contact> contactListAll(int p, Long id){
        Pageable page = PageRequest.of(p,MAX_SIZE);
        Page<Contact> companies = contactRepository.countContactById(page, id);
        return companies;
    }
}
