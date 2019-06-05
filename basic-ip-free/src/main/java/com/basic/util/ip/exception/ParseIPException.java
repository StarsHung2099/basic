package com.basic.util.ip.exception;

/**
 * @description:
 * @name: ParseIPException
 * @author: Stars Hung
 * @date: 16:59 2019/6/3
 **/
public class ParseIPException extends Exception {
    private String exceptionCode;

    public ParseIPException() {
        super();
    }

    public ParseIPException(String message) {
        super(message);
    }

    public ParseIPException(String code, String message) {
        super(message);
        this.exceptionCode = code;
    }

    public String getExceptionCode() {
        return exceptionCode;
    }

    public void setExceptionCode(String exceptionCode) {
        this.exceptionCode = exceptionCode;
    }
}
