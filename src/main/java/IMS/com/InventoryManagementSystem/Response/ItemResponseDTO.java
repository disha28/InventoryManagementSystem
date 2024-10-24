package IMS.com.InventoryManagementSystem.Response;

import IMS.com.InventoryManagementSystem.Model.Item;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ItemResponseDTO {

    private Integer id; // Added the missing id field
    private String productName;
    private Integer quantity;
    private String category;
    private Integer pricePerUnit;
    private Integer shelfNumber;
    private String vendorLink;

    // Constructor for custom initialization
    public ItemResponseDTO(Integer id, String productName, Integer quantity, String category, Integer pricePerUnit, Integer shelfNumber, String vendorLink) {
        this.id = id;
        this.productName = productName;
        this.quantity = quantity;
        this.category = category;
        this.pricePerUnit = pricePerUnit;
        this.shelfNumber = shelfNumber;
        this.vendorLink = vendorLink;
    }

    // Constructor to convert Item entity into ItemResponseDTO
    public ItemResponseDTO(Item item) {
        this.id = item.getId();
        this.productName = item.getProduct().getName();
        this.quantity = item.getQuantity();
        this.category = item.getCategory().getName();
        this.pricePerUnit = item.getPricePerUnit();
        this.shelfNumber = item.getShelf().getId();
        this.vendorLink = item.getVendor().getLink();
    }
}
