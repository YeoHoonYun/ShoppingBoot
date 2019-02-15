package yun.test.shoppingboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yun.test.shoppingboot.domain.ImageFile;

public interface ImageFileRepository extends JpaRepository<ImageFile, Long> {
}
