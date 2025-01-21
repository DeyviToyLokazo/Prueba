package com.examen.app_movement.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.examen.app_movement.dto.ExceptionDTO;

@ControllerAdvice
public class GlobalException {
    private final Logger logError =  LoggerFactory.getLogger(GlobalException.class);
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ExceptionDTO> handleIllegalArgumentException(IllegalArgumentException ex) {

       ExceptionDTO error = ExceptionDTO.builder().code("p-100").message(ex.getMessage()).build();
       logError.error(error.getCode() + ": " + error.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    // Manejo de excepción genérica
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDTO> handleGeneralException(Exception ex) {
        ExceptionDTO error = ExceptionDTO.builder().code("p-200").message(ex.getMessage()).build();
        logError.error(error.getCode() + ": " + error.getMessage());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionDTO> handleRuntimeException(RuntimeException ex) {
        ExceptionDTO error = ExceptionDTO.builder().code("p-300").message(ex.getMessage()).build();
        logError.error(error.getCode() + ": " + error.getMessage());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
