package IMS.com.InventoryManagementSystem.Model;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.ConstraintViolation;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidationTests {

    private static Validator validator;

    @BeforeAll
    public static void setUpValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void testVendorValidation() {
        // Create a Vendor object with invalid data
        Vendor vendor = new Vendor();
        vendor.setLink(""); // Invalid: Link should not be blank

        Set<ConstraintViolation<Vendor>> violations = validator.validate(vendor);

        // Verify that there is a validation error
        assertEquals(1, violations.size());

        // Check that the correct validation message is returned
        assertTrue(violations.stream().anyMatch(v -> v.getMessage().contains("must not be blank")));
    }

    @Test
    void testShelfValidation() {
        // Create a Shelf object with invalid data
        Shelf shelf = new Shelf();
        shelf.setCapacity(-5); // Invalid: Capacity should be positive

        Set<ConstraintViolation<Shelf>> violations = validator.validate(shelf);

        // Verify that there is a validation error
        assertEquals(1, violations.size());

        // Check that the correct validation message is returned
        assertTrue(violations.stream().anyMatch(v -> v.getMessage().contains("must be greater than 0")));
    }

    @Test
    void testCategoryValidation() {
        // Create a Category object with valid data
        Category category = new Category();
        category.setName(""); // Invalid: Name should not be blank

        Set<ConstraintViolation<Category>> violations = validator.validate(category);

        // Verify that there is a validation error
        assertEquals(1, violations.size());

        // Check that the correct validation message is returned
        assertTrue(violations.stream().anyMatch(v -> v.getMessage().contains("must not be blank")));
    }

    @Test
    void testProductValidation() {
        // Create a Product object with invalid data
        Product product = new Product();
        product.setName(""); // Invalid: Name should not be blank

        Set<ConstraintViolation<Product>> violations = validator.validate(product);

        // Verify that there is a validation error
        assertEquals(1, violations.size());

        // Check that the correct validation message is returned
        assertTrue(violations.stream().anyMatch(v -> v.getMessage().contains("must not be blank")));
    }
}
