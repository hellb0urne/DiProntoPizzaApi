package com.example.dipronto.diprontoDemo.exception;

import com.example.dipronto.diprontoDemo.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(UserExistException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorDto handlerUserExistException(UserExistException e) {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setHttpStatus(HttpStatus.CONFLICT);
        errorDto.setMessage(e.getMessage());
        return errorDto;
    }

    @ExceptionHandler(InvalidRoleException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorDto handlerInvalidRoleException(InvalidRoleException e) {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setHttpStatus(HttpStatus.CONFLICT);
        errorDto.setMessage(e.getMessage());
        return errorDto;
    }

    @ExceptionHandler(NullRoleException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorDto handlerNullRoleException(NullRoleException e) {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setHttpStatus(HttpStatus.CONFLICT);
        errorDto.setMessage(e.getMessage());
        return errorDto;
    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<?> handlerCustomException(CustomException e) {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage(e.getMessage());
        errorDto.setHttpStatus(e.getHttpStatus());
        return new ResponseEntity<>(errorDto, e.getHttpStatus());
    }

}
