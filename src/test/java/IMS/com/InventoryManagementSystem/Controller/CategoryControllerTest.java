package IMS.com.InventoryManagementSystem.Controller;

import IMS.com.InventoryManagementSystem.Model.Category;
import IMS.com.InventoryManagementSystem.Service.CategoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CategoryController.class)
class CategoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CategoryService categoryService;

    @Test
    void testGetAllCategories() throws Exception {
        // Mock the service to return a list of categories
        when(categoryService.getAllCategories()).thenReturn(List.of(new Category(1, "Category 1"), new Category(2, "Category 2")));

        // Perform GET request and verify the response
        mockMvc.perform(get("/categories"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Category 1"))
                .andExpect(jsonPath("$[1].name").value("Category 2"));

        verify(categoryService, times(1)).getAllCategories();
    }

    @Test
    void testGetCategoryById() throws Exception {
        // Mock the service to return a category by ID
        Category category = new Category();
        category.setId(1);
        category.setName("Test Category");

        when(categoryService.getCategoryById(1)).thenReturn(category);

        // Perform GET request and verify the response
        mockMvc.perform(get("/categories/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Test Category"));

        verify(categoryService, times(1)).getCategoryById(1);
    }

    @Test
    void testAddCategory() throws Exception {
        // Prepare valid category JSON
        String categoryJson = "{\"name\": \"New Category\"}";

        // Perform POST request and verify that category is added
        mockMvc.perform(post("/categories")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(categoryJson))
                .andExpect(status().isOk());

        verify(categoryService, times(1)).addCategory(any(Category.class));
    }

    @Test
    void testUpdateCategory() throws Exception {
        // Prepare valid updated category JSON
        String categoryJson = "{\"name\": \"Updated Category\"}";

        // Perform PUT request to update category
        mockMvc.perform(put("/categories/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(categoryJson))
                .andExpect(status().isOk());

        verify(categoryService, times(1)).updateCategory(eq(1), any(Category.class));
    }

    @Test
    void testDeleteCategory() throws Exception {
        // Perform DELETE request to delete category by ID
        mockMvc.perform(delete("/categories/1"))
                .andExpect(status().isNoContent());

        verify(categoryService, times(1)).deleteCategory(1);
    }
}
