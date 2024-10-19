package IMS.com.InventoryManagementSystem.Service;

import IMS.com.InventoryManagementSystem.Model.Shelf;
import IMS.com.InventoryManagementSystem.Repository.ShelfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShelfService {
    @Autowired
    private ShelfRepository shelfRepository;

    public List<Shelf> getAllShelves() {
        return shelfRepository.findAll();
    }

    public Shelf getShelfById(int id) {
        return shelfRepository.findById(id).orElse(null);
    }

    public void addShelf(Shelf shelf) {
        shelfRepository.save(shelf);
    }

    public void updateShelf(int id, Shelf shelf) {
        if (shelfRepository.existsById(id)) {
            shelf.setId(id);
            shelfRepository.save(shelf);
        }
    }

    public void deleteShelf(int id) {
        shelfRepository.deleteById(id);
    }
}
