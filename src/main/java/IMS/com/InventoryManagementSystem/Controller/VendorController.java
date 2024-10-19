package IMS.com.InventoryManagementSystem.Controller;

import IMS.com.InventoryManagementSystem.Model.Vendor;
import IMS.com.InventoryManagementSystem.Service.VendorService;
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

    @PostMapping
    public void addVendor(@RequestBody Vendor vendor) {
        vendorService.addVendor(vendor);
    }

    @PutMapping("/{id}")
    public void updateVendor(@PathVariable int id, @RequestBody Vendor vendor) {
        vendorService.updateVendor(id, vendor);
    }

    @DeleteMapping("/{id}")
    public void deleteVendor(@PathVariable int id) {
        vendorService.deleteVendor(id);
    }
}

