package com.thanabodee2661.springcommon.exceptionhandler;

import com.thanabodee2661.springcommon.enumeration.ResponseStatusEnum;
import com.thanabodee2661.springcommon.exception.InvalidException;
import com.thanabodee2661.springcommon.exception.NotFoundException;
import com.thanabodee2661.springcommon.model.ResponseModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public final class GlobalExceptionHandler {
    @ExceptionHandler({Exception.class})
    public <T> ResponseEntity<ResponseModel<T>> handleExceptionInternal(RuntimeException ex, WebRequest request) {
        return ResponseEntity.status(ResponseStatusEnum.JABZA5000.getHttpStatus())
                .body(new ResponseModel<T>(ResponseStatusEnum.JABZA5000));
    }

    @ExceptionHandler({NotFoundException.class})
    public <T> ResponseEntity<ResponseModel<T>> handleExceptionNotFound(RuntimeException ex, WebRequest request) {
        return ResponseEntity.status(ResponseStatusEnum.JABZA4040.getHttpStatus())
                .body(new ResponseModel<>(ResponseStatusEnum.JABZA4040));
    }

    @ExceptionHandler({InvalidException.class})
    public <T> ResponseEntity<ResponseModel<T>> handleExceptionBadRequest(RuntimeException ex, WebRequest request) {
        return ResponseEntity.status(ResponseStatusEnum.JABZA4000.getHttpStatus())
                .body(new ResponseModel<T>(ResponseStatusEnum.JABZA4000));
    }
}
