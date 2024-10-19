package IMS.com.InventoryManagementSystem.Service;

import IMS.com.InventoryManagementSystem.Model.Vendor;
import IMS.com.InventoryManagementSystem.Repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorService {
    @Autowired
    private VendorRepository vendorRepository;

    public List<Vendor> getAllVendors() {
        return vendorRepository.findAll();
    }

    public Vendor getVendorById(int id) {
        return vendorRepository.findById(id).orElse(null);
    }

    public void addVendor(Vendor vendor) {
        vendorRepository.save(vendor);
    }

    public void updateVendor(int id, Vendor vendor) {
        if (vendorRepository.existsById(id)) {
            vendor.setId(id);
            vendorRepository.save(vendor);
        }
    }

    public void deleteVendor(int id) {
        vendorRepository.deleteById(id);
    }
}

