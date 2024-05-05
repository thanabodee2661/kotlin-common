package com.thanabodee2661.springcommon.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvalidException extends RuntimeException {
    private String message;
    private Throwable ex;
    public InvalidException (String message, Throwable ex) {
        this.message = message;
        this.ex = ex;
    }

    public InvalidException (String message) {
        this.message = message;
        this.ex = null;
    }

    public InvalidException (Throwable ex) {
        this.message = null;
        this.ex = ex;
    }
}