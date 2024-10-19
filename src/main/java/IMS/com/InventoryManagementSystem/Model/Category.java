package IMS.com.InventoryManagementSystem.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    // Constructors, Getters, and Setters
    public Category() {}

    public Category(String name) {
        this.name = name;
    }
}
