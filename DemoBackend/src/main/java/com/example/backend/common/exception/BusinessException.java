package com.example.backend.common.exception;

import com.example.backend.constant.BusinessResponseCode;


public class BusinessException extends BaseException{
    public BusinessException(){
    }

    public BusinessException(String code, String error, String message){
        super(code,error,message);
    }

    public BusinessException(BusinessResponseCode businessResponseCode){
        super(businessResponseCode);
    }

}
