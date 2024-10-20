package IMS.com.InventoryManagementSystem.Controller;

import IMS.com.InventoryManagementSystem.Model.Item;
import IMS.com.InventoryManagementSystem.Response.ItemResponseDTO;
import IMS.com.InventoryManagementSystem.Service.ItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    // GET method to filter items based on query parameters
    @GetMapping
    public List<ItemResponseDTO> getFilteredItems(
            @RequestParam(required = false) String categoryName,
            @RequestParam(required = false) String vendorName,
            @RequestParam(required = false) Integer minPrice,
            @RequestParam(required = false) Integer maxPrice) {
        return itemService.getFilteredItems(categoryName, vendorName, minPrice, maxPrice);
    }

    // POST method to handle new item creation with validation
    @PostMapping
    public ResponseEntity<Item> createItem(@Valid @RequestBody Item item) {
        Item createdItem = itemService.createItem(item);
        return ResponseEntity.ok(createdItem);  // Return the created item
    }

    // PUT method to update an item by ID with validation
    @PutMapping("/{id}")
    public ResponseEntity<ItemResponseDTO> updateItem(
            @PathVariable int id,
            @Valid @RequestBody Item item) {
        ItemResponseDTO updatedItem = itemService.updateItem(id, item);
        return ResponseEntity.ok(updatedItem);  // Return the updated item
    }

    // DELETE method to delete an item by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable int id) {
        itemService.deleteItem(id);
        return ResponseEntity.noContent().build();  // Return no content after deletion
    }

    // GET method to get shelf capacity for an item by ID
    @GetMapping("/{id}/shelf-capacity")
    public ResponseEntity<Integer> getShelfCapacity(@PathVariable Integer id) {
        return ResponseEntity.ok(itemService.getShelfCapacityForItem(id));
    }
}
