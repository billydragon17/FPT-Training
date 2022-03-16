package com.example.backend.common.exception;

import com.example.backend.common.ApiErrorResponse;
import com.example.backend.constant.CommonResponseCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;


@ControllerAdvice
@RestController
public class GeneralExceptionHandler extends Throwable {
    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public Object handleBusinessException(BusinessException ex) {
        return genError(ex);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Object handleBadRequestException(MethodArgumentNotValidException ex) {
        System.out.println(ex);
        return new ApiErrorResponse(CommonResponseCode.BAD_REQUEST);
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public Object handleExceptionError(Exception ex) {
        System.out.println(ex);
        return new ApiErrorResponse(CommonResponseCode.INTERNAL_SERVER_ERROR);
    }

    private ApiErrorResponse genError(BaseException ex){
        return new ApiErrorResponse(ex.getCode(),ex.getError(),ex.getMessage());
    }

}
