package yun.test.shoppingboot.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import yun.test.shoppingboot.domain.Product;

public interface ProductDao{
    public Page<Product> productPageListAll(Pageable pageable);
    public Product productById(Long id);
    public Page<Product> productByCategory(Long id, Pageable pageable);
    public Page<Product> productByName(String name, Pageable pageable);
}
