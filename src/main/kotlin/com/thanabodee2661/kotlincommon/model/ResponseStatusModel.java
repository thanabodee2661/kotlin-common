package com.thanabodee2661.kotlincommon.model;

import com.thanabodee2661.kotlincommon.enumeration.ResponseStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ResponseStatusModel {
    private String code;
    private String message;
    private String description;

    public ResponseStatusModel(ResponseStatusEnum statusEnum) {
        this.code = statusEnum.getCode();
        this.message = statusEnum.getMessage();
        this.description = statusEnum.getDescription();
    }
}
