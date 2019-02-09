package yun.test.shoppingboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yun.test.shoppingboot.domain.Bucket;

public interface BucketRepository extends JpaRepository<Bucket, Long> {

}
