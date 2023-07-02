package com.cybersoft.cozastore_java21.exception;

public class CustomFileNotFoundException extends RuntimeException {
    private int status;
    private String message;

    public CustomFileNotFoundException() {
    }

    public CustomFileNotFoundException(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
