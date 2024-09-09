package com.sartyro.pubberrestapi.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class RestControllerExceptionHandler {
    private final ObjectMapper objectMapper;
    @ResponseBody
    @ExceptionHandler(EntityIdNotFoundException.class)
    public ResponseEntity<ApiError> handleException(EntityIdNotFoundException exception, HttpServletRequest request){
        ApiError apiError = new ApiError(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                EntityIdNotFoundException.class.getSimpleName(),
                request.getServletPath(),
                exception.getMessage()
        );
        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }
    @ResponseBody
    @ExceptionHandler(NullFieldException.class)
    public ResponseEntity<ApiError> handleNullFiledException(NullFieldException exception, HttpServletRequest request){
        ApiError apiError = new ApiError(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                NullFieldException.class.getSimpleName(),
                request.getServletPath(),
                exception.getMessage()
        );
        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<?> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
                                                             HttpServletRequest request) throws JsonProcessingException {
        Map<String,String> errors=new HashMap<>();
        exception.getBindingResult()
                .getAllErrors()
                .forEach(err->{
                    String fieldName = ((FieldError)err).getField();
                    String message = err.getDefaultMessage();
                    errors.put(fieldName, message);
                });
        ApiError apiError = new ApiError(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                "Client Request Validation Error",
                request.getServletPath(),
                objectMapper.writeValueAsString(errors)
        );
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }
    @ResponseBody
    @ExceptionHandler(ConstraintViolationException.class)
    protected ResponseEntity<ApiError> handlePathVariableNotValid(ConstraintViolationException exception,
                                                                  HttpServletRequest request) {
        ApiError apiError = new ApiError(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                "Client Path Variable Validation Error",
                request.getServletPath(),
                exception.getMessage()
        );
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }
}
