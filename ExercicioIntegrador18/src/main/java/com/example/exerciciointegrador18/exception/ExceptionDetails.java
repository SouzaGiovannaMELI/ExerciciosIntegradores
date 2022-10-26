package com.example.exerciciointegrador18.exception;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ExceptionDetails {
    private String title;
    private String message;
    private String fields;
    private String fieldsMessage;
    private LocalDateTime timeStamp;
}
