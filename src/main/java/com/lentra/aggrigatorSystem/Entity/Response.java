package com.lentra.aggrigatorSystem.Entity;

public class Response {

    private String token;
    private int StatusCode;
    private boolean success;

    public Response(String token , int statusCode , boolean success) {
        this.token = token;
        StatusCode = statusCode;
        this.success = success;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getStatusCode() {
        return StatusCode;
    }

    public void setStatusCode(int statusCode) {
        StatusCode = statusCode;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }



}
