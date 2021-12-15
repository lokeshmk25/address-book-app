package com.bridgelabz.addressbookapp.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
/**
 * @author LOKESH
 * @version 0.0.1-SNAPSHOT
 * @since 10-12-21
 *
 */
@ControllerAdvice
public class CustomGlobalException extends ResponseEntityExceptionHandler {


    @Override
    protected ResponseEntity handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                          HttpHeaders headers,
                                                          HttpStatus status, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", new Date());
        body.put("status", status.value());

        //Get all errors
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());

        body.put("errors", errors);

        return new ResponseEntity<>(body, headers, status);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity handleEntityNotFoundException(EntityNotFoundException ex) {
        logger.error("Invalid ID");
        return new ResponseEntity("Given id is Not Found", HttpStatus.BAD_REQUEST);
    }
}