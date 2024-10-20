package IMS.com.InventoryManagementSystem.Service;

import IMS.com.InventoryManagementSystem.Model.Category;
import IMS.com.InventoryManagementSystem.Repository.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

class CategoryServiceTest {

    @InjectMocks
    private CategoryService categoryService;

    @Mock
    private CategoryRepository categoryRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllCategories() {
        // Mock the repository to return a list of categories
        List<Category> categories = List.of(new Category(1, "Category 1"), new Category(2, "Category 2"));
        when(categoryRepository.findAll()).thenReturn(categories);

        // Call the service method
        List<Category> result = categoryService.getAllCategories();

        // Verify the result and interactions
        assertEquals(2, result.size());
        verify(categoryRepository, times(1)).findAll();
    }

    @Test
    void testGetCategoryById() {
        // Mock the repository to return a category by ID
        Category category = new Category(1, "Category 1");
        when(categoryRepository.findById(1)).thenReturn(Optional.of(category));

        // Call the service method
        Category result = categoryService.getCategoryById(1);

        // Verify the result and interactions
        assertEquals("Category 1", result.getName());
        verify(categoryRepository, times(1)).findById(1);
    }

    @Test
    void testGetCategoryById_NotFound() {
        // Mock the repository to return empty when ID is not found
        when(categoryRepository.findById(1)).thenReturn(Optional.empty());

        // Call the service method
        Category result = categoryService.getCategoryById(1);

        // Verify that null is returned and the repository was called
        assertNull(result);
        verify(categoryRepository, times(1)).findById(1);
    }

    @Test
    void testAddCategory() {
        // Mock the repository's save method
        Category category = new Category(1, "New Category");
        when(categoryRepository.save(category)).thenReturn(category);

        // Call the service method
        categoryService.addCategory(category);

        // Verify that the save method was called
        verify(categoryRepository, times(1)).save(category);
    }

    @Test
    void testUpdateCategory() {
        // Mock the repository's existsById and save methods
        Category existingCategory = new Category(1, "Old Category");
        Category updatedCategory = new Category(1, "Updated Category");

        when(categoryRepository.existsById(1)).thenReturn(true);
        when(categoryRepository.save(updatedCategory)).thenReturn(updatedCategory);

        // Call the service method
        categoryService.updateCategory(1, updatedCategory);

        // Verify the interactions
        verify(categoryRepository, times(1)).existsById(1);
        verify(categoryRepository, times(1)).save(updatedCategory);
    }

    @Test
    void testUpdateCategory_NotFound() {
        // Mock the repository's existsById to return false
        Category updatedCategory = new Category(1, "Updated Category");
        when(categoryRepository.existsById(1)).thenReturn(false);

        // Call the service method
        categoryService.updateCategory(1, updatedCategory);

        // Verify that save was not called
        verify(categoryRepository, times(0)).save(updatedCategory);
    }

    @Test
    void testDeleteCategory() {
        // Mock the repository's deleteById method
        doNothing().when(categoryRepository).deleteById(1);

        // Call the service method
        categoryService.deleteCategory(1);

        // Verify the interaction
        verify(categoryRepository, times(1)).deleteById(1);
    }
}
