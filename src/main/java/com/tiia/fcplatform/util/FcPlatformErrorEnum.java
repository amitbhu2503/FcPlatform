package com.tiia.fcplatform.util;

/**
 * Created by AmitG on 8/4/2018.
 */
public enum FcPlatformErrorEnum {
    REVENUE_COLLECTION_INVALID_INPUT_PATH("Please provide and valid input path"),
    REVENUE_COLLECTION_INVALID_OUTPUT_PATH("Please provide and valid output path"),
    REVENUE_COLLECTION_INVALID_PATH("Please provide and valid input/output path");

    private String message;

    FcPlatformErrorEnum(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}
