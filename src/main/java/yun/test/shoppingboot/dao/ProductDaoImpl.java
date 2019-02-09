package yun.test.shoppingboot.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import yun.test.shoppingboot.domain.Product;
import yun.test.shoppingboot.repository.ProductRepository;

@Repository
public class ProductDaoImpl implements ProductDao{
    @Autowired
    ProductRepository productRepository;

    public Page<Product> productPageListAll(Pageable pageable){
        Page<Product> products = productRepository.getProductAll(pageable);
        return products;
    }

    public Product productById(Long id){
        Product product= productRepository.getProductById(id);
        return product;
    }
    public Page<Product> productByCategory(Long id, Pageable pageable){
        Page<Product> products= productRepository.getProductByCategory(id, pageable);
        return products;
    }

    public Page<Product> productByName(String name, Pageable pageable){
        Page<Product> products= productRepository.getProductByName(name, pageable);
        return products;
    }
}
