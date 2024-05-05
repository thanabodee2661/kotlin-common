package com.thanabodee2661.springcommon.exceptionhandler;

import com.thanabodee2661.springcommon.enumeration.ResponseStatusEnum;
import com.thanabodee2661.springcommon.exception.InvalidException;
import com.thanabodee2661.springcommon.exception.NotFoundException;
import com.thanabodee2661.springcommon.model.ResponseModel;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.List;
import java.util.Objects;

@ControllerAdvice
public final class GlobalExceptionHandler {
    @ExceptionHandler({Exception.class, RuntimeException.class, Throwable.class})
    public <T> ResponseEntity<ResponseModel<T>> handleExceptionInternal(Exception ex, WebRequest request) {
        return ResponseEntity.status(ResponseStatusEnum.JABZA5000.getHttpStatus())
                .body(new ResponseModel<T>(ResponseStatusEnum.JABZA5000));
    }

    @ExceptionHandler({NotFoundException.class, NoHandlerFoundException.class})
    public <T> ResponseEntity<ResponseModel<T>> handleExceptionNotFound(Exception ex, WebRequest request) {
        ResponseModel<T> responseModel = new ResponseModel<>(ResponseStatusEnum.JABZA4040);
        if (ex instanceof NoHandlerFoundException) {
            responseModel.getStatus().setDescription(ex.getMessage());
        }
        return ResponseEntity.status(ResponseStatusEnum.JABZA4040.getHttpStatus())
                .body(responseModel);
    }

    @ExceptionHandler({InvalidException.class, MethodArgumentNotValidException.class, IllegalStateException.class, IllegalArgumentException.class})
    public <T> ResponseEntity<ResponseModel<T>> handleExceptionBadRequest(Exception ex, WebRequest request) {
        String description = null;
        if (ex instanceof MethodArgumentNotValidException) {
            List<FieldError> fieldErrors = ((MethodArgumentNotValidException) ex).getFieldErrors();
            if (!fieldErrors.isEmpty()) {
                String errMsg = Objects.requireNonNullElse(fieldErrors.get(0).getDefaultMessage(), "");
                description = fieldErrors.get(0).getField();
                if (!errMsg.isEmpty()) {
                    description += " " + errMsg;
                }
            }
        }
        return ResponseEntity.status(ResponseStatusEnum.JABZA4000.getHttpStatus())
                .body(new ResponseModel<T>(ResponseStatusEnum.JABZA4000, description));
    }
}
