package IMS.com.InventoryManagementSystem.Service;


import IMS.com.InventoryManagementSystem.Model.Vendor;
import IMS.com.InventoryManagementSystem.Repository.VendorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

class VendorServiceTest {

    @InjectMocks
    private VendorService vendorService;

    @Mock
    private VendorRepository vendorRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllVendors() {
        // Mock the repository to return a list of vendors
        List<Vendor> vendors = List.of(new Vendor(1, "http://vendor1.com"), new Vendor(2, "http://vendor2.com"));
        when(vendorRepository.findAll()).thenReturn(vendors);

        // Call the service method
        List<Vendor> result = vendorService.getAllVendors();

        // Verify the result and interactions
        assertEquals(2, result.size());
        verify(vendorRepository, times(1)).findAll();
    }

    @Test
    void testGetVendorById() {
        // Mock the repository to return a vendor by ID
        Vendor vendor = new Vendor(1, "http://vendor1.com");
        when(vendorRepository.findById(1)).thenReturn(Optional.of(vendor));

        // Call the service method
        Vendor result = vendorService.getVendorById(1);

        // Verify the result and interactions
        assertEquals("http://vendor1.com", result.getLink());
        verify(vendorRepository, times(1)).findById(1);
    }

    @Test
    void testGetVendorById_NotFound() {
        // Mock the repository to return empty when ID is not found
        when(vendorRepository.findById(1)).thenReturn(Optional.empty());

        // Call the service method
        Vendor result = vendorService.getVendorById(1);

        // Verify that null is returned and the repository was called
        assertNull(result);
        verify(vendorRepository, times(1)).findById(1);
    }

    @Test
    void testAddVendor() {
        // Mock the repository's save method
        Vendor vendor = new Vendor(1, "http://newvendor.com");
        when(vendorRepository.save(vendor)).thenReturn(vendor);

        // Call the service method
        vendorService.addVendor(vendor);

        // Verify that the save method was called
        verify(vendorRepository, times(1)).save(vendor);
    }

    @Test
    void testUpdateVendor() {
        // Mock the repository's existsById and save methods
        Vendor existingVendor = new Vendor(1, "http://oldvendor.com");
        Vendor updatedVendor = new Vendor(1, "http://updatedvendor.com");

        when(vendorRepository.existsById(1)).thenReturn(true);
        when(vendorRepository.save(updatedVendor)).thenReturn(updatedVendor);

        // Call the service method
        vendorService.updateVendor(1, updatedVendor);

        // Verify the interactions
        verify(vendorRepository, times(1)).existsById(1);
        verify(vendorRepository, times(1)).save(updatedVendor);
    }

    @Test
    void testUpdateVendor_NotFound() {
        // Mock the repository's existsById to return false
        Vendor updatedVendor = new Vendor(1, "http://updatedvendor.com");
        when(vendorRepository.existsById(1)).thenReturn(false);

        // Call the service method
        vendorService.updateVendor(1, updatedVendor);

        // Verify that save was not called
        verify(vendorRepository, times(0)).save(updatedVendor);
    }

    @Test
    void testDeleteVendor() {
        // Mock the repository's deleteById method
        doNothing().when(vendorRepository).deleteById(1);

        // Call the service method
        vendorService.deleteVendor(1);

        // Verify the interaction
        verify(vendorRepository, times(1)).deleteById(1);
    }
}