package yun.test.shoppingboot.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import yun.test.shoppingboot.domain.Product;

import java.util.List;

public interface ProductService {
    public Page<Product> productPageListAll(int p);
    public Product productById(Long id);
    public Page<Product> productByCategory(Long id, int p);
    public Page<Product> productByName(String name, int p);
}
