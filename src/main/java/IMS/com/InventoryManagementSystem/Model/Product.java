package IMS.com.InventoryManagementSystem.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    // Constructors, Getters, and Setters
    public Product() {}

    public Product(String name) {
        this.name = name;
    }
}
