package com.thanabodee2661.springcommon.model;

import com.thanabodee2661.springcommon.enumeration.ResponseStatusEnum;
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

    public ResponseStatusModel(ResponseStatusEnum statusEnum, String customDescription) {
        this.code = statusEnum.getCode();
        this.message = statusEnum.getMessage();
        this.description = customDescription;
    }
}
