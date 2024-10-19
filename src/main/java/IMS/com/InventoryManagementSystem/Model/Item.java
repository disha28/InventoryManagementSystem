package IMS.com.InventoryManagementSystem.Model;

import jakarta.persistence.*;
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

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    private Integer pricePerUnit;

    @ManyToOne
    @JoinColumn(name = "shelf_id", nullable = false)
    private Shelf shelf;

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
