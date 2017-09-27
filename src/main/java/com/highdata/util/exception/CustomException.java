package com.highdata.util.exception;

public class CustomException extends Exception {

    private static final long serialVersionUID = -7668244147380888034L;

    //异常信息
    public String message;

    public CustomException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
