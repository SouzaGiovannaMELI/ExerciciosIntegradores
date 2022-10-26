package com.example.exerciciointegrador18.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class HandlerExceptions extends ResponseEntityExceptionHandler {

    @ExceptionHandler(InvalidParamException.class)
    public ResponseEntity<ExceptionDetails> handlerNotFoundException(InvalidParamException ex){
        ExceptionDetails exceptionDetails = ExceptionDetails.builder()
                .title("Parâmetro inválido")
                .message(ex.getMessage())
                .timeStamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(exceptionDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDetails> handlerNotFoundException(NotFoundException ex){
        ExceptionDetails exceptionDetails = ExceptionDetails.builder()
                .title("Objeto não encontrado")
                .message(ex.getMessage())
                .timeStamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(exceptionDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ExceptionDetails> handlerDataIntegrityViolationException(DataIntegrityViolationException ex){
        ExceptionDetails exceptionDetails = ExceptionDetails.builder()
                .title("Dados inválidos")
                .message("Um ou mais valores fornecidos ferem as regras de integridade")
                .timeStamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(exceptionDetails, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<FieldError> errors = ex.getFieldErrors();

        return new ResponseEntity<>(
                ExceptionDetails.builder()
                        .title("Parâmetros inválidos")
                        .message("Um ou mais campos estão com valores inválidos")
                        .fields(errors.stream().map(FieldError::getField).collect(Collectors.joining("; ")))
                        .fieldsMessage(errors.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining("; ")))
                        .timeStamp(LocalDateTime.now())
                        .build(), status
        );
    }
}
