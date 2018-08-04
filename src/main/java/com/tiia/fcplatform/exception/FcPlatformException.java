package com.tiia.fcplatform.exception;

/**
 * Created by AmitG on 8/4/2018.
 */
public class FcPlatformException extends RuntimeException {
    private final String errorCode;
    private final String message;

    public FcPlatformException(String errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    @Override
    public String getMessage() {
        return message;
    }
}