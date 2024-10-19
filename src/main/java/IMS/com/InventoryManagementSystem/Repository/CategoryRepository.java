package IMS.com.InventoryManagementSystem.Repository;

import IMS.com.InventoryManagementSystem.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}

