package com.thanabodee2661.springcommon.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.thanabodee2661.springcommon.enumeration.ResponseStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseModel<T> {
    private ResponseStatusModel status;
    private T data;

    public ResponseModel(ResponseStatusEnum statusEnum) {
        this.status = new ResponseStatusModel(statusEnum);
    }

    public ResponseModel(ResponseStatusEnum statusEnum, String customDescription) {
        this.status = new ResponseStatusModel(statusEnum, customDescription);
    }
}
