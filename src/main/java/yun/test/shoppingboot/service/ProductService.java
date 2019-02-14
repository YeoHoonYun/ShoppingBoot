package yun.test.shoppingboot.service;

import org.springframework.data.domain.Page;
import yun.test.shoppingboot.domain.Product;

public interface ProductService {
    public Page<Product> productPageListAll(int p);
    public Product productById(Long id);
    public Page<Product> productByCategory(Long id, int p);
    public Page<Product> productByName(String name, int p);
    public void addProduct(Product product, Long categoryId, Long companyId);
}
