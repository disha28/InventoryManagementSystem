package IMS.com.InventoryManagementSystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Product cannot be null")
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @NotNull(message = "Quantity cannot be null")
    @Min(value = 1, message = "Quantity must be greater than zero")
    private Integer quantity;

    @NotNull(message = "Category cannot be null")
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @NotNull(message = "Price per unit cannot be null")
    @Min(value = 1, message = "Price per unit must be greater than zero")
    private Integer pricePerUnit;

    @NotNull(message = "Shelf cannot be null")
    @ManyToOne
    @JoinColumn(name = "shelf_id", nullable = false)
    private Shelf shelf;

    @NotNull(message = "Vendor cannot be null")
    @ManyToOne
    @JoinColumn(name = "vendor_id", nullable = false)
    private Vendor vendor;

    // Constructors, Getters, and Setters
    public Item() {}

    public Item(Product product, Integer quantity, Category category, Integer pricePerUnit, Shelf shelf, Vendor vendor) {
        this.product = product;
        this.quantity = quantity;
        this.category = category;
        this.pricePerUnit = pricePerUnit;
        this.shelf = shelf;
        this.vendor = vendor;
    }
}
