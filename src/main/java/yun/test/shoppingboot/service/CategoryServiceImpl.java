package yun.test.shoppingboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import yun.test.shoppingboot.dao.CategoryDao;
import yun.test.shoppingboot.domain.Category;
import yun.test.shoppingboot.repository.CategoryRepository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryDao categoryDao;

    public List<Category> categoryListAll(){
        List<Category> categories = categoryDao.categoryListAll();
        return categories;
    }
}
