package yun.test.shoppingboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yun.test.shoppingboot.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
