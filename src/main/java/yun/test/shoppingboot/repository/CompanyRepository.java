package yun.test.shoppingboot.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import yun.test.shoppingboot.domain.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    @Query("SELECT p FROM Company p")
    public Page<Company> getCompanyByAll(Pageable pageable);

    @Query("SELECT c FROM Company c WHERE c.companyId = :id")
    public Company countByCompanyId(@Param("id") Long id);
}
