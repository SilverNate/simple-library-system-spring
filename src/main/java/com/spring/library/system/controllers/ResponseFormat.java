package com.spring.library.system.controllers;

import lombok.Data;

@Data
public class ResponseFormat {
    private int code;
    private String message;
    private String status;
    private Object data;

    // No-argument constructor
    public ResponseFormat() {}

    // All-arguments constructor
    public ResponseFormat(int code, String message, String status, Object data) {
        this.code = code;
        this.message = message;
        this.status = status;
        this.data = data;
    }

    // Getters and Setters
    public int getCode() { return code; }
    public void setCode(int code) { this.code = code; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Object getData() { return data; }
    public void setData(Object data) { this.data = data; }
}
