package yun.test.shoppingboot.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import yun.test.shoppingboot.domain.Product;

public interface ProductDao{
    public Page<Product> productPageListAll(Pageable pageable);
    public Product productById(Long id);
}
