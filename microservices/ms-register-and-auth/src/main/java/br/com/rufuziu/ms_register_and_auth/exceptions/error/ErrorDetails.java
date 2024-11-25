package br.com.rufuziu.ms_register_and_auth.exceptions.error;

import java.time.LocalDateTime;

public class ErrorDetails {
    public ErrorDetails() {}
    private LocalDateTime timestamp;
    private String message;
    private String details;

    public ErrorDetails(LocalDateTime timestamp,
                        String message,
                        String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}