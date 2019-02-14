package yun.test.shoppingboot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import yun.test.shoppingboot.domain.Company;
import yun.test.shoppingboot.repository.CompanyRepository;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;

    private final static int MAX_SIZE = 10;

    public Page<Company> companyListAll(int p){
        Pageable page = PageRequest.of(p,MAX_SIZE);
        Page<Company> companies = companyRepository.getCompanyByAll(page);
        return companies;
    }

}
