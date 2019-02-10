package yun.test.shoppingboot.service;

import org.springframework.data.domain.Page;
import yun.test.shoppingboot.domain.Company;

import java.util.List;

public interface CompanyService {
    public Page<Company> categoryListAll(int p);
}
