package com.brandonn.springboottemplate2.shared.errorhandler;

import com.brandonn.springboottemplate2.shared.dto.BasicHttpResponseDto;
import com.brandonn.springboottemplate2.shared.dto.ErrorHttpResponseDto;
import com.brandonn.springboottemplate2.shared.errorhandler.customexceptions.ProductsNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Slf4j
public class RestErrorHandler extends ResponseEntityExceptionHandler {

    @Value("${info.app.version}")
    private String version;

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        log.error(ex.getMessage());
        var response = new BasicHttpResponseDto<ErrorHttpResponseDto>();
        response.setVersion(version);
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setMessage("Error");
        var error = new ErrorHttpResponseDto();
        error.setErrorCode(1000);
        var errors = ex.getBindingResult().getAllErrors().stream()
                .map(e -> ((DefaultMessageSourceResolvable) e.getArguments()[0]).getDefaultMessage() + " " + e.getDefaultMessage()).toList();
        error.setDescription(String.valueOf(errors));
        response.setData(error);
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(value = {ProductsNotFoundException.class})
    protected ResponseEntity<Object> handleProductsNotFound(ProductsNotFoundException ex) {
        log.error(ex.getMessage());
        var response = new BasicHttpResponseDto<ErrorHttpResponseDto>();
        response.setVersion(version);
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setMessage("Error");
        var error = new ErrorHttpResponseDto();
        error.setErrorCode(1100);
        error.setDescription(ex.getMessage());
        response.setData(error);
        return ResponseEntity.badRequest().body(response);
    }
}
