package com.tiia.fcplatform.seheduler;

import com.tiia.fcplatform.services.RevenueCalculationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by AmitG on 8/3/2018.
 */
@Component
public class RevenueCalculationScheduler {
    private static final Logger logger = LoggerFactory.getLogger(RevenueCalculationScheduler.class);

    @Autowired
    private RevenueCalculationService revenueCalculationService;

    @Value("${com.tiia.pricecollection.inputDir}")
    private String inputDirPath;

    @Value("${com.tiia.pricecollection.outputDir}")
    private String outputDirPath;

    @Scheduled(cron= "${com.tiia.pricecollection.schedulingTime}")
    public void calculate(){
        Date schedulerStartDate = new Date();
        logger.info("Started processing revenue collector for date {} ", schedulerStartDate);
        revenueCalculationService.processCalculations(inputDirPath, outputDirPath, schedulerStartDate);
        logger.info("Finished processing revenue collector for date {} ", schedulerStartDate);
    }
}
