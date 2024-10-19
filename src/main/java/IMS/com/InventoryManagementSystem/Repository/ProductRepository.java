package IMS.com.InventoryManagementSystem.Repository;

import IMS.com.InventoryManagementSystem.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
