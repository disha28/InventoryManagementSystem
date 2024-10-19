package IMS.com.InventoryManagementSystem.Exception;

public class ShelfCapacityExceededException extends RuntimeException {
    public ShelfCapacityExceededException(String message) {
        super(message);
    }
}
