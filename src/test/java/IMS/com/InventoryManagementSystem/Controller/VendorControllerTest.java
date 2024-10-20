package IMS.com.InventoryManagementSystem.Controller;

import IMS.com.InventoryManagementSystem.Model.Vendor;
import IMS.com.InventoryManagementSystem.Service.VendorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(VendorController.class)
class VendorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private VendorService vendorService;

    @Test
    void testGetAllVendors() throws Exception {
        // Mock the service to return a list of vendors
        when(vendorService.getAllVendors()).thenReturn(List.of(new Vendor(1, "http://vendor1.com"), new Vendor(2, "http://vendor2.com")));

        // Perform GET request and verify the response
        mockMvc.perform(get("/vendors"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].link").value("http://vendor1.com"))
                .andExpect(jsonPath("$[1].link").value("http://vendor2.com"));

        verify(vendorService, times(1)).getAllVendors();
    }

    @Test
    void testGetVendorById() throws Exception {
        // Mock the service to return a vendor by ID
        Vendor vendor = new Vendor(1, "http://vendor1.com");

        when(vendorService.getVendorById(1)).thenReturn(vendor);

        // Perform GET request and verify the response
        mockMvc.perform(get("/vendors/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.link").value("http://vendor1.com"));

        verify(vendorService, times(1)).getVendorById(1);
    }

    @Test
    void testAddVendor() throws Exception {
        // Prepare valid vendor JSON
        String vendorJson = "{\"link\": \"http://newvendor.com\"}";

        // Perform POST request and verify that vendor is added
        mockMvc.perform(post("/vendors")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(vendorJson))
                .andExpect(status().isOk());

        verify(vendorService, times(1)).addVendor(any(Vendor.class));
    }

    @Test
    void testUpdateVendor() throws Exception {
        // Prepare valid updated vendor JSON
        String vendorJson = "{\"link\": \"http://updatedvendor.com\"}";

        // Perform PUT request to update vendor
        mockMvc.perform(put("/vendors/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(vendorJson))
                .andExpect(status().isOk());

        verify(vendorService, times(1)).updateVendor(eq(1), any(Vendor.class));
    }

    @Test
    void testDeleteVendor() throws Exception {
        // Perform DELETE request to delete vendor by ID
        mockMvc.perform(delete("/vendors/1"))
                .andExpect(status().isNoContent());

        verify(vendorService, times(1)).deleteVendor(1);
    }
}