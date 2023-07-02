package com.cybersoft.cozastore_java21.exception;

import com.cybersoft.cozastore_java21.payload.response.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.attribute.UserPrincipalNotFoundException;

@RestControllerAdvice // lắng nghe các exception
public class GlobalCustomException {

//    Nơi đăng ký các Exception sẽ kích hoạt code bên trong hàm
    @ExceptionHandler(CustomFileNotFoundException.class)
    public ResponseEntity<?> handleUserNotFound(Exception e){

        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatusCode(500);
        baseResponse.setData(e.getMessage());
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<?> handleCustomException(Exception e){

        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatusCode(500);
        baseResponse.setData(e.getMessage());
        return new ResponseEntity<>(baseResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
