package com.pm.apigateway.common;

import java.time.LocalDateTime;

public class AuthResponse {
    private boolean success;
    private int status;
    private String message;
    private String token;
    private LocalDateTime timestamp;

    public AuthResponse() {
        this.timestamp = LocalDateTime.now();
    }

    public AuthResponse(boolean success, int status, String message, String token) {
        this.success = success;
        this.status = status;
        this.message = message;
        this.token = token;
        this.timestamp = LocalDateTime.now();
    }

    public static AuthResponse success(int status, String message, String token){
        return new AuthResponse(true, status, message, token);
    }

    public static AuthResponse error(int status, String message){
        return new AuthResponse(false, status, message, null);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
