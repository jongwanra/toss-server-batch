package com.numble.tossserverbatch.global;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Result<T> {
    private T result;
    private int statusCode;
    private String message;

    public Result(T result, int statusCode, String message) {
        this.result = result;
        this.statusCode = statusCode;
        this.message = message;
    }

    public Result(int statusCode) {
        this.result = null;
        this.statusCode = statusCode;
        this.message = "";

    }
}
