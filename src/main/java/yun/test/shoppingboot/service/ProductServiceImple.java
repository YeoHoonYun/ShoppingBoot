package yun.test.shoppingboot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yun.test.shoppingboot.domain.Product;
import yun.test.shoppingboot.repository.ProductRepository;

@Service
@RequiredArgsConstructor
public class ProductServiceImple implements ProductService {
    private final ProductRepository productRepository;
    private final static int MAX_SIZE = 6;

    @Transactional(readOnly = true)
    public Page<Product> productPageListAll(int p){
        Pageable page = PageRequest.of(p,MAX_SIZE);
        Page<Product> products = productRepository.getProductAll(page);
        return products;
    }

    @Override
    @Transactional(readOnly = true)
    public Product productById(Long id) {
        Product product = productRepository.getProductById(id);
        return product;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Product> productByCategory(Long id, int p) {
        Pageable page = PageRequest.of(p,MAX_SIZE);
        Page<Product> products = productRepository.getProductByCategory(id, page);
        return products;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Product> productByName(String name, int p) {
        Pageable page = PageRequest.of(p,MAX_SIZE);
        Page<Product> products = productRepository.getProductByName(name, page);
        return products;
    }
}
