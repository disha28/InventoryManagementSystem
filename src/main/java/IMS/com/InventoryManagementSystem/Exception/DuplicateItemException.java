package IMS.com.InventoryManagementSystem.Exception;

public class DuplicateItemException extends RuntimeException {
    public DuplicateItemException(String message) {
        super(message);
    }
}
