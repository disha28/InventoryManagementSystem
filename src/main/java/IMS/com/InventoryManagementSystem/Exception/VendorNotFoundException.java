package IMS.com.InventoryManagementSystem.Exception;

public class VendorNotFoundException extends RuntimeException {
    public VendorNotFoundException(String message) {
        super(message);
    }
}
