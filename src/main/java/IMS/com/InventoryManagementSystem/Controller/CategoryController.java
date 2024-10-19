package IMS.com.InventoryManagementSystem.Controller;

import IMS.com.InventoryManagementSystem.Model.Category;
import IMS.com.InventoryManagementSystem.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable int id) {
        Category category = categoryService.getCategoryById(id);
        return category != null ? ResponseEntity.ok(category) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public void addCategory(@RequestBody Category category) {
        categoryService.addCategory(category);
    }

    @PutMapping("/{id}")
    public void updateCategory(@PathVariable int id, @RequestBody Category category) {
        categoryService.updateCategory(id, category);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable int id) {
        categoryService.deleteCategory(id);
    }
}
