package yun.test.shoppingboot.service;

import org.springframework.data.domain.Page;
import yun.test.shoppingboot.domain.Company;

public interface CompanyService {
    public Page<Company> companyListAll(int p);
}
