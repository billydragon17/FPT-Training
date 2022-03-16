package com.example.backend.constant;

import com.example.backend.common.ApiResponse;

public enum CommonResponseCode implements ApiResponse {
    BAD_REQUEST("400", "BAD_REQUEST","BAD_REQUEST"),
    INTERNAL_SERVER_ERROR("400", "INTERNAL_SERVER_ERROR","Có lỗi xảy ra");


    private String code;
    private String error;
    private String message;

    CommonResponseCode(String code, String error, String message){
        this.code = code;
        this.error = error;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
