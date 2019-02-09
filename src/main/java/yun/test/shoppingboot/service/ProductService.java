package yun.test.shoppingboot.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import yun.test.shoppingboot.domain.Product;

public interface ProductService {
    public Page<Product> productPageListAll(int p);
    public Product productById(Long id);
}
