package IMS.com.InventoryManagementSystem.Service;

import IMS.com.InventoryManagementSystem.Exception.DuplicateItemException;
import IMS.com.InventoryManagementSystem.Exception.ItemNotFoundException;
import IMS.com.InventoryManagementSystem.Exception.ShelfCapacityExceededException;
import IMS.com.InventoryManagementSystem.Model.Item;
import IMS.com.InventoryManagementSystem.Repository.ItemRepository;
import IMS.com.InventoryManagementSystem.Response.ItemResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public List<ItemResponseDTO> getFilteredItems(
            String categoryName,
            String vendorName,
            Integer minPrice,
            Integer maxPrice) {
        List<Item> items = itemRepository.findAllWithFilters(categoryName, vendorName, minPrice, maxPrice);
        return items.stream().map(item -> new ItemResponseDTO(
                item.getProduct().getName(),
                item.getQuantity(),
                item.getCategory().getName(),
                item.getPricePerUnit(),
                item.getShelf().getId(),
                item.getVendor().getLink()
        )).collect(Collectors.toList());
    }

    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    public ItemResponseDTO updateItem(int id, Item item) {
        Optional<Item> existingItem = itemRepository.findById(id);
        if (existingItem.isPresent()) {
            Item updatedItem = existingItem.get();
            // Check if shelf capacity is exceeded
            if (updatedItem.getShelf().getCapacity() < updatedItem.getQuantity()) {
                throw new ShelfCapacityExceededException("Shelf capacity exceeded for item with ID: " + id);
            }
            updatedItem.setProduct(item.getProduct());
            updatedItem.setQuantity(item.getQuantity());
            updatedItem.setCategory(item.getCategory());
            updatedItem.setPricePerUnit(item.getPricePerUnit());
            updatedItem.setShelf(item.getShelf());
            updatedItem.setVendor(item.getVendor());
            itemRepository.save(updatedItem);
            return new ItemResponseDTO(updatedItem);
        } else {
            throw new ItemNotFoundException("Item not found with ID: " + id);
        }
    }

    public void deleteItem(int id) {
        // Check if the item exists
        Optional<Item> existingItem = itemRepository.findById(id);

        if (existingItem.isPresent()) {
            // Delete the item from the repository
            itemRepository.delete(existingItem.get());
        } else {
            throw new ItemNotFoundException("Item not found with ID: " + id);
        }
    }

    public void addItem(Item item) {
        // Check for duplicate item
        if (itemRepository.existsById(item.getId())) {
            throw new DuplicateItemException("Item with ID: " + item.getId() + " already exists.");
        }
        itemRepository.save(item);
    }

    public Integer getShelfCapacityForItem(Integer itemId) {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new ItemNotFoundException("Item not found"));
        return item.getShelf() != null ? item.getShelf().getCapacity() : 0;
    }
}