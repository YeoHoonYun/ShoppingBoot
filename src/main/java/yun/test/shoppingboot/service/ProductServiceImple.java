package yun.test.shoppingboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import yun.test.shoppingboot.dao.ProductDao;
import yun.test.shoppingboot.domain.Product;
import yun.test.shoppingboot.repository.ProductRepository;

@Repository
public class ProductServiceImple implements ProductService {
    @Autowired
    ProductDao productDao;

    public Page<Product> productPageListAll(int p){
        Pageable page = PageRequest.of(p,6);
        Page<Product> products = productDao.productPageListAll(page);
        return products;
    }

    @Override
    public Product productById(Long id) {
        Product product = productDao.productById(id);
        return product;
    }
}
