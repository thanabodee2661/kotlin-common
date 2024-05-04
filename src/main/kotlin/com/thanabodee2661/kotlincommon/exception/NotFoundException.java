package com.thanabodee2661.kotlincommon.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotFoundException extends RuntimeException {
    private String message;
    private Throwable ex;
    public NotFoundException (String message, Throwable ex) {
        this.message = message;
        this.ex = ex;
    }

    public NotFoundException (String message) {
        this.message = message;
        this.ex = null;
    }

    public NotFoundException (Throwable ex) {
        this.message = null;
        this.ex = ex;
    }
}