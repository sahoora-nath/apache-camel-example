package com.sahoora.cxf.camel.error;

public class ValidationException extends Exception {
    public ValidationException(String msg) {
        super(msg);
    }

    public ValidationException(String msg, Exception ex) {
        super(msg, ex);
    }
}
