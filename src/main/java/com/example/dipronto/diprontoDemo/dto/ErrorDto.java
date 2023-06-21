package com.example.dipronto.diprontoDemo.dto;

import lombok.Data;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Data
@Setter
public class ErrorDto {

    private HttpStatus httpStatus;
    private String message;

}
