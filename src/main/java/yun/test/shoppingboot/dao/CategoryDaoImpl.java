package yun.test.shoppingboot.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import yun.test.shoppingboot.domain.Category;
import yun.test.shoppingboot.repository.CategoryRepository;

import java.util.List;

@Repository
public class CategoryDaoImpl implements CategoryDao{
    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> categoryListAll(){
        List<Category> categories = categoryRepository.findAll();
        return categories;
    }
}
