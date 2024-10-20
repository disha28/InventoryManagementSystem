package IMS.com.InventoryManagementSystem.Controller;

import IMS.com.InventoryManagementSystem.Model.Shelf;
import IMS.com.InventoryManagementSystem.Service.ShelfService;
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

@WebMvcTest(ShelfController.class)
class ShelfControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ShelfService shelfService;

    @Test
    void testGetAllShelves() throws Exception {
        // Mock the service to return a list of shelves
        when(shelfService.getAllShelves()).thenReturn(List.of(new Shelf(1, 100), new Shelf(2, 200)));

        // Perform GET request and verify the response
        mockMvc.perform(get("/shelves"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].capacity").value(100))
                .andExpect(jsonPath("$[1].capacity").value(200));

        verify(shelfService, times(1)).getAllShelves();
    }

    @Test
    void testGetShelfById() throws Exception {
        // Mock the service to return a shelf by ID
        Shelf shelf = new Shelf(1, 100);

        when(shelfService.getShelfById(1)).thenReturn(shelf);

        // Perform GET request and verify the response
        mockMvc.perform(get("/shelves/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.capacity").value(100));

        verify(shelfService, times(1)).getShelfById(1);
    }

    @Test
    void testAddShelf() throws Exception {
        // Prepare valid shelf JSON
        String shelfJson = "{\"capacity\": 150}";

        // Perform POST request and verify that shelf is added
        mockMvc.perform(post("/shelves")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(shelfJson))
                .andExpect(status().isOk());

        verify(shelfService, times(1)).addShelf(any(Shelf.class));
    }

    @Test
    void testUpdateShelf() throws Exception {
        // Prepare valid updated shelf JSON
        String shelfJson = "{\"capacity\": 180}";

        // Perform PUT request to update shelf
        mockMvc.perform(put("/shelves/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(shelfJson))
                .andExpect(status().isOk());

        verify(shelfService, times(1)).updateShelf(eq(1), any(Shelf.class));
    }

    @Test
    void testDeleteShelf() throws Exception {
        // Perform DELETE request to delete shelf by ID
        mockMvc.perform(delete("/shelves/1"))
                .andExpect(status().isNoContent());

        verify(shelfService, times(1)).deleteShelf(1);
    }
}
