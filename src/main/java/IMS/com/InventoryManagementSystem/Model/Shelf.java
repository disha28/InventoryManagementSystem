package IMS.com.InventoryManagementSystem.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "shelf")
public class Shelf {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer capacity;

    // Constructors, Getters, and Setters
    public Shelf() {}

    public Shelf(Integer capacity) {
        this.capacity = capacity;
    }
}