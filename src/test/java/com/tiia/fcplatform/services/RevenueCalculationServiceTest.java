package com.tiia.fcplatform.services;

import com.tiia.fcplatform.exception.FcPlatformException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;

import static org.junit.Assert.*;

public class RevenueCalculationServiceTest {

    private RevenueCalculationService revenueCalculationService;

    @Before
    public void setup(){
        revenueCalculationService = Mockito.mock(RevenueCalculationService.class);
    }

    @Test(expected = FcPlatformException.class)
    public void throwsError() {
        revenueCalculationService.processCalculations(null, null, new Date());
    }

    @Test
    public void processCalculations() {
        String inputDirPath = "E:/amitg/github/FcPlatform/src/main/resources/input";
        String outputDirPath = "E:/amitg/github/FcPlatform/src/main/resources/output";
        revenueCalculationService.processCalculations(inputDirPath, outputDirPath, new Date());
    }
}