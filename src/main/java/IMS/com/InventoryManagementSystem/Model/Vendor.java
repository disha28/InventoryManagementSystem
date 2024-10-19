package IMS.com.InventoryManagementSystem.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "vendor")
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String link;
    public Vendor() {}

    public Vendor(String link) {
        this.link = link;
    }
}