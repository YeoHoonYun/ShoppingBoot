package yun.test.shoppingboot.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import yun.test.shoppingboot.domain.Company;

public interface CompanyDao {
    public Page<Company> categoryListAll(Pageable pageable);
}
