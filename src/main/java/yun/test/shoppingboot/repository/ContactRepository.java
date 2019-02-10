package yun.test.shoppingboot.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import yun.test.shoppingboot.domain.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    @Query("select c from Contact c where c.company.companyId = :companyId")
    public Page<Contact> countContactById(Pageable pageable, @Param("companyId") Long companyId);
}
