package IMS.com.InventoryManagementSystem.Service;

import IMS.com.InventoryManagementSystem.Model.Shelf;
import IMS.com.InventoryManagementSystem.Repository.ShelfRepository;
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

class ShelfServiceTest {

    @InjectMocks
    private ShelfService shelfService;

    @Mock
    private ShelfRepository shelfRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllShelves() {
        // Mock the repository to return a list of shelves
        List<Shelf> shelves = List.of(new Shelf(1, 100), new Shelf(2, 200));
        when(shelfRepository.findAll()).thenReturn(shelves);

        // Call the service method
        List<Shelf> result = shelfService.getAllShelves();

        // Verify the result and interactions
        assertEquals(2, result.size());
        verify(shelfRepository, times(1)).findAll();
    }

    @Test
    void testGetShelfById() {
        // Mock the repository to return a shelf by ID
        Shelf shelf = new Shelf(1, 100);
        when(shelfRepository.findById(1)).thenReturn(Optional.of(shelf));

        // Call the service method
        Shelf result = shelfService.getShelfById(1);

        // Verify the result and interactions
        assertEquals(100, result.getCapacity());
        verify(shelfRepository, times(1)).findById(1);
    }

    @Test
    void testGetShelfById_NotFound() {
        // Mock the repository to return empty when ID is not found
        when(shelfRepository.findById(1)).thenReturn(Optional.empty());

        // Call the service method
        Shelf result = shelfService.getShelfById(1);

        // Verify that null is returned and the repository was called
        assertNull(result);
        verify(shelfRepository, times(1)).findById(1);
    }

    @Test
    void testAddShelf() {
        // Mock the repository's save method
        Shelf shelf = new Shelf(1, 100);
        when(shelfRepository.save(shelf)).thenReturn(shelf);

        // Call the service method
        shelfService.addShelf(shelf);

        // Verify that the save method was called
        verify(shelfRepository, times(1)).save(shelf);
    }

    @Test
    void testUpdateShelf() {
        // Mock the repository's existsById and save methods
        Shelf existingShelf = new Shelf(1, 100);
        Shelf updatedShelf = new Shelf(1, 150);

        when(shelfRepository.existsById(1)).thenReturn(true);
        when(shelfRepository.save(updatedShelf)).thenReturn(updatedShelf);

        // Call the service method
        shelfService.updateShelf(1, updatedShelf);

        // Verify the interactions
        verify(shelfRepository, times(1)).existsById(1);
        verify(shelfRepository, times(1)).save(updatedShelf);
    }

    @Test
    void testUpdateShelf_NotFound() {
        // Mock the repository's existsById to return false
        Shelf updatedShelf = new Shelf(1, 150);
        when(shelfRepository.existsById(1)).thenReturn(false);

        // Call the service method
        shelfService.updateShelf(1, updatedShelf);

        // Verify that save was not called
        verify(shelfRepository, times(0)).save(updatedShelf);
    }

    @Test
    void testDeleteShelf() {
        // Mock the repository's deleteById method
        doNothing().when(shelfRepository).deleteById(1);

        // Call the service method
        shelfService.deleteShelf(1);

        // Verify the interaction
        verify(shelfRepository, times(1)).deleteById(1);
    }
}
