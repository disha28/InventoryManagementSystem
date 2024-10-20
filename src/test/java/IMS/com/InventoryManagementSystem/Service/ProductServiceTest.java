package IMS.com.InventoryManagementSystem.Service;

import IMS.com.InventoryManagementSystem.Model.Product;
import IMS.com.InventoryManagementSystem.Repository.ProductRepository;
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

class ProductServiceTest {

    @InjectMocks
    private ProductService productService;

    @Mock
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllProducts() {
        // Mock the repository to return a list of products
        List<Product> products = List.of(new Product(1, "Product 1"), new Product(2, "Product 2"));
        when(productRepository.findAll()).thenReturn(products);

        // Call the service method
        List<Product> result = productService.getAllProducts();

        // Verify the result and interactions
        assertEquals(2, result.size());
        verify(productRepository, times(1)).findAll();
    }

    @Test
    void testGetProductById() {
        // Mock the repository to return a product by ID
        Product product = new Product(1, "Product 1");
        when(productRepository.findById(1)).thenReturn(Optional.of(product));

        // Call the service method
        Product result = productService.getProductById(1);

        // Verify the result and interactions
        assertEquals("Product 1", result.getName());
        verify(productRepository, times(1)).findById(1);
    }

    @Test
    void testGetProductById_NotFound() {
        // Mock the repository to return empty when ID is not found
        when(productRepository.findById(1)).thenReturn(Optional.empty());

        // Call the service method
        Product result = productService.getProductById(1);

        // Verify that null is returned and the repository was called
        assertNull(result);
        verify(productRepository, times(1)).findById(1);
    }

    @Test
    void testAddProduct() {
        // Mock the repository's save method
        Product product = new Product(1, "New Product");
        when(productRepository.save(product)).thenReturn(product);

        // Call the service method
        productService.addProduct(product);

        // Verify that the save method was called
        verify(productRepository, times(1)).save(product);
    }

    @Test
    void testUpdateProduct() {
        // Mock the repository's existsById and save methods
        Product existingProduct = new Product(1, "Old Product");
        Product updatedProduct = new Product(1, "Updated Product");

        when(productRepository.existsById(1)).thenReturn(true);
        when(productRepository.save(updatedProduct)).thenReturn(updatedProduct);

        // Call the service method
        productService.updateProduct(1, updatedProduct);

        // Verify the interactions
        verify(productRepository, times(1)).existsById(1);
        verify(productRepository, times(1)).save(updatedProduct);
    }

    @Test
    void testUpdateProduct_NotFound() {
        // Mock the repository's existsById to return false
        Product updatedProduct = new Product(1, "Updated Product");
        when(productRepository.existsById(1)).thenReturn(false);

        // Call the service method
        productService.updateProduct(1, updatedProduct);

        // Verify that save was not called
        verify(productRepository, times(0)).save(updatedProduct);
    }

    @Test
    void testDeleteProduct() {
        // Mock the repository's deleteById method
        doNothing().when(productRepository).deleteById(1);

        // Call the service method
        productService.deleteProduct(1);

        // Verify the interaction
        verify(productRepository, times(1)).deleteById(1);
    }
}