package com.thanabodee2661.kotlincommon.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.thanabodee2661.kotlincommon.enumeration.ResponseStatusEnum;
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
}
