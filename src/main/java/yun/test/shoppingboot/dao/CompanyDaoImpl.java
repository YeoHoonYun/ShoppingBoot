package yun.test.shoppingboot.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import yun.test.shoppingboot.domain.Company;
import yun.test.shoppingboot.repository.CompanyRepository;

@Repository
public class CompanyDaoImpl implements CompanyDao {
    @Autowired
    CompanyRepository companyRepository;

    public Page<Company> categoryListAll(Pageable pageable){
        Page<Company> companies = companyRepository.getCompanyByAll(pageable);
        return companies;
    }
}
