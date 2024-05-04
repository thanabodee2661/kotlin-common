package com.thanabodee2661.kotlincommon.enumeration;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ResponseStatusEnum {
    JABZA5000(HttpStatus.INTERNAL_SERVER_ERROR, "JZ5000", "Internal Server Error", "Internal server error"),
    JABZA4000(HttpStatus.BAD_REQUEST, "JZ4000", "Bad Request", ""),
    JABZA4040(HttpStatus.NOT_FOUND, "JZ4040", "Not Found", "Data not found");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;
    private final String description;

    ResponseStatusEnum(HttpStatus httpStatus, String code, String message, String description) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
        this.description = description;
    }
}