package IMS.com.InventoryManagementSystem.Controller;

import IMS.com.InventoryManagementSystem.Model.Shelf;
import IMS.com.InventoryManagementSystem.Service.ShelfService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shelves")
public class ShelfController {

    @Autowired
    private ShelfService shelfService;

    @GetMapping
    public List<Shelf> getAllShelves() {
        return shelfService.getAllShelves();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Shelf> getShelfById(@PathVariable int id) {
        Shelf shelf = shelfService.getShelfById(id);
        return shelf != null ? ResponseEntity.ok(shelf) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Void> addShelf(@Valid @RequestBody Shelf shelf) {
        shelfService.addShelf(shelf);
        return ResponseEntity.ok().build(); // Return 200 OK on success
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateShelf(@PathVariable int id, @Valid @RequestBody Shelf shelf) {
        shelfService.updateShelf(id, shelf);
        return ResponseEntity.ok().build(); // Return 200 OK on success
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShelf(@PathVariable int id) {
        shelfService.deleteShelf(id);
        return ResponseEntity.noContent().build(); // Return 204 No Content on success
    }
}