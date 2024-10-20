package IMS.com.InventoryManagementSystem.Exception;

import java.time.LocalDateTime;

public class ErrorResponse {
    private int status;
    private String message;
    private String details;
    private LocalDateTime timestamp;

    public ErrorResponse(int status, String message, String details, LocalDateTime now) {
        this.status = status;
        this.message = message;
        this.details = details;
        this.timestamp = LocalDateTime.now();
    }
    // Getters and Setters
}
