package IMS.com.InventoryManagementSystem.Repository;

import IMS.com.InventoryManagementSystem.Model.Shelf;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShelfRepository extends JpaRepository<Shelf, Integer> {
}
