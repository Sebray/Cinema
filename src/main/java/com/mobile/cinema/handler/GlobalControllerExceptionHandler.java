package com.mobile.cinema.handler;

import com.mobile.cinema.dto.ErrorDto;
import com.mobile.cinema.exception.PaymentFailedException;
import com.mobile.cinema.exception.ResourceAlreadyExistsException;
import com.mobile.cinema.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.*;

@ControllerAdvice
public class GlobalControllerExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public @ResponseBody
    ResponseEntity<ErrorDto> handleResourceNotFoundException(Exception e) {
        Calendar timestamp = Calendar.getInstance();
        return new ResponseEntity<>(
                new ErrorDto(e.getMessage(), timestamp.getTime()),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(ResourceAlreadyExistsException.class)
    public @ResponseBody ResponseEntity<ErrorDto> handleResourceAlreadyExistsException(Exception e) {
        Calendar timestamp = Calendar.getInstance();
        return new ResponseEntity<>(
                new ErrorDto(e.getMessage(), timestamp.getTime()),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(PaymentFailedException.class)
    public @ResponseBody ResponseEntity<ErrorDto> handlePaymentFailedException(Exception e) {
        Calendar timestamp = Calendar.getInstance();
        return new ResponseEntity<>(
                new ErrorDto(e.getMessage(), timestamp.getTime()),
                HttpStatus.PAYMENT_REQUIRED
        );
    }
}
