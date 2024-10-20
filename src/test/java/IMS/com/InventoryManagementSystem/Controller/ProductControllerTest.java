package IMS.com.InventoryManagementSystem.Controller;

import IMS.com.InventoryManagementSystem.Model.Product;
import IMS.com.InventoryManagementSystem.Service.ProductService;
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

@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @Test
    void testGetAllProducts() throws Exception {
        // Mock the service to return a list of products
        when(productService.getAllProducts()).thenReturn(List.of(new Product(1, "Test Product 1"), new Product(2, "Test Product 2")));

        // Perform GET request and check the result
        mockMvc.perform(get("/products"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Test Product 1"))
                .andExpect(jsonPath("$[1].name").value("Test Product 2"));

        verify(productService, times(1)).getAllProducts();
    }

    @Test
    void testGetProductById() throws Exception {
        // Mock the service to return a product for a given ID
        Product product = new Product();
        product.setId(1);
        product.setName("Test Product");

        when(productService.getProductById(1)).thenReturn(product);

        // Perform GET request and verify the response
        mockMvc.perform(get("/products/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Test Product"));

        verify(productService, times(1)).getProductById(1);
    }

    @Test
    void testAddProduct() throws Exception {
        // Prepare a valid product JSON
        String productJson = "{\"name\": \"New Product\"}";

        // Perform POST request
        mockMvc.perform(post("/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(productJson))
                .andExpect(status().isOk());

        verify(productService, times(1)).addProduct(any(Product.class));
    }

    @Test
    void testUpdateProduct() throws Exception {
        // Prepare an updated product JSON
        String productJson = "{\"name\": \"Updated Product\"}";

        // Perform PUT request
        mockMvc.perform(put("/products/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(productJson))
                .andExpect(status().isOk());

        verify(productService, times(1)).updateProduct(eq(1), any(Product.class));
    }

    @Test
    void testDeleteProduct() throws Exception {
        // Perform DELETE request
        mockMvc.perform(delete("/products/1"))
                .andExpect(status().isNoContent());

        verify(productService, times(1)).deleteProduct(1);
    }
}
