package yun.test.shoppingboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import yun.test.shoppingboot.dao.CategoryDao;
import yun.test.shoppingboot.dao.CompanyDao;
import yun.test.shoppingboot.domain.Category;
import yun.test.shoppingboot.domain.Company;

import java.util.List;

@Repository
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    CompanyDao companyDao;

    private final static int MAX_SIZE = 10;

    public Page<Company> categoryListAll(int p){
        Pageable page = PageRequest.of(p,MAX_SIZE);
        Page<Company> companies = companyDao.categoryListAll(page);
        return companies;
    }
}
