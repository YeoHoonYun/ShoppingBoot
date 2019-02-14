package yun.test.shoppingboot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yun.test.shoppingboot.domain.Category;
import yun.test.shoppingboot.repository.CategoryRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryListAll;

    public List<Category> categoryListAll(){
        List<Category> categories = categoryListAll.findAll();
        return categories;
    }
}
