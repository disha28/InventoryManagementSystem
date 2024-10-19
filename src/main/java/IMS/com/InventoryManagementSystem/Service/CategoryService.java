package IMS.com.InventoryManagementSystem.Service;

import IMS.com.InventoryManagementSystem.Model.Category;
import IMS.com.InventoryManagementSystem.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(int id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    public void updateCategory(int id, Category category) {
        if (categoryRepository.existsById(id)) {
            category.setId(id);
            categoryRepository.save(category);
        }
    }

    public void deleteCategory(int id) {
        categoryRepository.deleteById(id);
    }
}

