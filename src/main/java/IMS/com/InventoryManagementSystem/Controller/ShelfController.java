package IMS.com.InventoryManagementSystem.Controller;

import IMS.com.InventoryManagementSystem.Model.Shelf;
import IMS.com.InventoryManagementSystem.Service.ShelfService;
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
    public void addShelf(@RequestBody Shelf shelf) {
        shelfService.addShelf(shelf);
    }

    @PutMapping("/{id}")
    public void updateShelf(@PathVariable int id, @RequestBody Shelf shelf) {
        shelfService.updateShelf(id, shelf);
    }

    @DeleteMapping("/{id}")
    public void deleteShelf(@PathVariable int id) {
        shelfService.deleteShelf(id);
    }
}

