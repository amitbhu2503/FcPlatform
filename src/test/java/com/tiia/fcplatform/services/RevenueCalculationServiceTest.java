package com.tiia.fcplatform.services;

import com.tiia.fcplatform.exception.FcPlatformException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.*;

public class RevenueCalculationServiceTest {

    private RevenueCalculationService revenueCalculationService;

    @Before
    public void setup(){
        revenueCalculationService = Mockito.mock(RevenueCalculationService.class);
    }

    @Test(expected = FcPlatformException.class)
    public void processCalculations() {
        revenueCalculationService.processCalculations(null, null, new Date());
    }
}