package IMS.com.InventoryManagementSystem.Controller;

import IMS.com.InventoryManagementSystem.Model.Item;
import IMS.com.InventoryManagementSystem.Response.ItemResponseDTO;
import IMS.com.InventoryManagementSystem.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping
    public List<ItemResponseDTO> getFilteredItems(
            @RequestParam(required = false) String categoryName,
            @RequestParam(required = false) String vendorName,
            @RequestParam(required = false) Integer minPrice,
            @RequestParam(required = false) Integer maxPrice) {
        return itemService.getFilteredItems(categoryName, vendorName, minPrice, maxPrice);
    }

    // Add the POST method to handle new item creation
    @PostMapping
    public Item createItem(@RequestBody Item item) {
        return itemService.createItem(item);  // Call service to handle item creation
    }

    // PUT method to update an item by ID
    @PutMapping("/{id}")
    public ItemResponseDTO updateItem(
            @PathVariable int id,
            @RequestBody Item item) {
        return itemService.updateItem(id, item);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable int id) {
        itemService.deleteItem(id);
    }

    @GetMapping("/{id}/shelf-capacity")
    public ResponseEntity<Integer> getShelfCapacity(@PathVariable Integer id) {
        return ResponseEntity.ok(itemService.getShelfCapacityForItem(id));
    }

}
