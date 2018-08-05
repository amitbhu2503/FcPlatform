package com.tiia.fcplatform.exception;

import com.tiia.fcplatform.util.FcPlatformErrorEnum;
import org.junit.Test;

import static org.junit.Assert.*;

public class FcPlatformExceptionTest {

    @Test
    public void getErrorCode() {
        FcPlatformException exception = new FcPlatformException(FcPlatformErrorEnum.REVENUE_COLLECTION_INVALID_INPUT_PATH.name(),
                FcPlatformErrorEnum.REVENUE_COLLECTION_INVALID_INPUT_PATH.getMessage());
        assertEquals(FcPlatformErrorEnum.REVENUE_COLLECTION_INVALID_INPUT_PATH.name(), exception.getErrorCode());
    }

    @Test
    public void getMessage() {
        FcPlatformException exception = new FcPlatformException(FcPlatformErrorEnum.REVENUE_COLLECTION_INVALID_INPUT_PATH.name(),
                FcPlatformErrorEnum.REVENUE_COLLECTION_INVALID_INPUT_PATH.getMessage());
        assertEquals(FcPlatformErrorEnum.REVENUE_COLLECTION_INVALID_INPUT_PATH.getMessage(), exception.getMessage());
    }
}