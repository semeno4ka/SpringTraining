package com.cydeo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseWrapper {//customization of operations message in THE BODY

    private boolean success;
    private String message;
    private Integer code;
    private Object data;// used to wrap up DTO classes, lists of DTO we will pass

    //Custom constructors for better customization
    public ResponseWrapper(String message, Object data) {// return data
        this.success = true;
        this.message = message;
        this.code = HttpStatus.OK.value();
        this.data = data;
    }

    public ResponseWrapper(String message) {// return message only
        this.success = true;
        this.message = message;
        this.code = HttpStatus.OK.value();
    }

}
