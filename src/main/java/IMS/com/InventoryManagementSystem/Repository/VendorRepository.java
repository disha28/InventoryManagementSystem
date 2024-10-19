package IMS.com.InventoryManagementSystem.Repository;

import IMS.com.InventoryManagementSystem.Model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepository extends JpaRepository<Vendor, Integer> {
}
