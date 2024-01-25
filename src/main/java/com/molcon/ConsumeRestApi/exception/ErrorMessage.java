package com.molcon.ConsumeRestApi.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ErrorMessage {
    String errorCode;
    String errorMsg;
    int status;
    LocalDateTime timestamp;
}
