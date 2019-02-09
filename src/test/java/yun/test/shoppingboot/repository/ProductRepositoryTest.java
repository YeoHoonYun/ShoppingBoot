package yun.test.shoppingboot.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;
import yun.test.shoppingboot.domain.Product;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProductRepositoryTest {
    @Autowired
    ProductRepository productRepository;

    @Test
    public void productAll() throws Exception{
        Pageable page = PageRequest.of(0,6);
        Page<Product> all = productRepository.getProductAll(page);
        System.out.println(all.getTotalElements());
        for(Product product : all){
            System.out.println(product.getName());
        }
    }

    @Test
    public void productById() throws Exception{
        Product product= productRepository.getProductById(1L);
        System.out.println(product.getName());
    }

    @Test
    public void getProductByName() throws Exception{
        Pageable page = PageRequest.of(0,6);
        Page<Product> all = productRepository.getProductByName("Z",page);
        for(Product product : all){
            System.out.println(product.getName());
        }
    }
}
