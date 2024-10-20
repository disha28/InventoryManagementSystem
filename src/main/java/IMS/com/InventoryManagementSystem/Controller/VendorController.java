package IMS.com.InventoryManagementSystem.Controller;

import IMS.com.InventoryManagementSystem.Model.Vendor;
import IMS.com.InventoryManagementSystem.Service.VendorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendors")
public class VendorController {

    @Autowired
    private VendorService vendorService;

    @GetMapping
    public List<Vendor> getAllVendors() {
        return vendorService.getAllVendors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vendor> getVendorById(@PathVariable int id) {
        Vendor vendor = vendorService.getVendorById(id);
        return vendor != null ? ResponseEntity.ok(vendor) : ResponseEntity.notFound().build();
    }

    // Add @Valid to validate the incoming Vendor object
    @PostMapping
    public ResponseEntity<Void> addVendor(@Valid @RequestBody Vendor vendor) {
        vendorService.addVendor(vendor);
        return ResponseEntity.ok().build(); // Return 200 OK on successful creation
    }

    // Add @Valid to validate the Vendor object during updates
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateVendor(@PathVariable int id, @Valid @RequestBody Vendor vendor) {
        vendorService.updateVendor(id, vendor);
        return ResponseEntity.ok().build(); // Return 200 OK on successful update
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVendor(@PathVariable int id) {
        vendorService.deleteVendor(id);
        return ResponseEntity.noContent().build(); // Return 204 No Content on successful deletion
    }
}