package yun.test.shoppingboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import yun.test.shoppingboot.dao.ProductDao;
import yun.test.shoppingboot.domain.Product;

@Repository
public class ProductServiceImple implements ProductService {
    @Autowired
    ProductDao productDao;
    private final static int MAX_SIZE = 6;

    public Page<Product> productPageListAll(int p){
        Pageable page = PageRequest.of(p,MAX_SIZE);
        Page<Product> products = productDao.productPageListAll(page);
        return products;
    }

    @Override
    public Product productById(Long id) {
        Product product = productDao.productById(id);
        return product;
    }

    @Override
    public Page<Product> productByCategory(Long id, int p) {
        Pageable page = PageRequest.of(p,MAX_SIZE);
        Page<Product> products = productDao.productByCategory(id, page);
        return products;
    }

    @Override
    public Page<Product> productByName(String name, int p) {
        Pageable page = PageRequest.of(p,MAX_SIZE);
        Page<Product> products = productDao.productByName(name, page);
        return products;
    }
}
