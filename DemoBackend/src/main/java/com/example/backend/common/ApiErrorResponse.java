package com.example.backend.common;

public class ApiErrorResponse {
    private String code;
    private String error;
    private String message;

    public ApiErrorResponse() {
    }

    public ApiErrorResponse(String code, String error, String message) {
        this.code = code;
        this.error = error;
        this.message = message;
    }
    public ApiErrorResponse(ApiResponse ex) {
        this.code = ex.getCode();
        this.error = ex.getError();
        this.message = ex.getMessage();
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
