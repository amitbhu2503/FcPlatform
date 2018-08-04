package com.tiia.fcplatform.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tiia.fcplatform.dto.*;
import com.tiia.fcplatform.exception.FcPlatformException;
import com.tiia.fcplatform.util.Constants;
import com.tiia.fcplatform.util.FcPlatformErrorEnum;
import com.tiia.fcplatform.util.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by AmitG on 8/3/2018.
 */

@Service
public class RevenueCalculationService {

    private static final Logger logger = LoggerFactory.getLogger(RevenueCalculationService.class);

    public void processCalculations(String inputDirPath, String outputDirPath, Date schedulerStartDate) {
        if(inputDirPath == null || outputDirPath == null){
            throw new FcPlatformException(FcPlatformErrorEnum.REVENUE_COLLECTION_INVALID_INPUT_PATH.name(), FcPlatformErrorEnum.REVENUE_COLLECTION_INVALID_INPUT_PATH.getMessage());
        }

        // check for input directory
        File inputDirectory = new File(inputDirPath);

        if (!inputDirectory.exists()) {
            logger.error("Error in processing file, input path does not exist {}", inputDirPath);
            throw new FcPlatformException(FcPlatformErrorEnum.REVENUE_COLLECTION_INVALID_INPUT_PATH.name(), FcPlatformErrorEnum.REVENUE_COLLECTION_INVALID_INPUT_PATH.getMessage());
        }

        // check for output directory
        File outputDirectory = new File(outputDirPath);

        if (!outputDirectory.exists()) {
            logger.error("Error in processing file, output path does not exist {}", inputDirPath);
            throw new FcPlatformException(FcPlatformErrorEnum.REVENUE_COLLECTION_INVALID_OUTPUT_PATH.name(), FcPlatformErrorEnum.REVENUE_COLLECTION_INVALID_OUTPUT_PATH.getMessage());
        }
        CmFoodChainSummary summary = new CmFoodChainSummary();
        for (File file : inputDirectory.listFiles()) {
            if (file.isFile()) {
                logger.info("Started processing file with name {}", file.getName());
                BranchDetails branchDetails = process(file);
                if (branchDetails != null) {
                    if (branchDetails.isMatch()) {
                        summary.addMatch(getBranchSummary(branchDetails));
                    } else {
                        summary.addMisMatch(getBranchSummary(branchDetails));
                    }
                }
                logger.info("Finished processing file with name {}", file.getName());
            }
        }
        writeOutputTOFile(outputDirPath, summary, schedulerStartDate);
    }

    private void writeOutputTOFile(String outputDirPath, CmFoodChainSummary summary, Date schedulerStartDate) {
        String schedulerStartDateStr = Util.getDateString(schedulerStartDate);
        File matchFile = new File(outputDirPath + Constants.FILE_SEPARATOR + schedulerStartDateStr + Constants.FILE_SEPARATOR +
                Constants.OUTPUT_MATCH_FILE_NAME);
        File misMatchFile = new File(outputDirPath + Constants.FILE_SEPARATOR + schedulerStartDateStr + Constants.FILE_SEPARATOR +
                Constants.OUTPUT_MISMATCH_FILE_NAME);

        matchFile.getParentFile().mkdirs();
        misMatchFile.getParentFile().mkdirs();
        // write to file
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(matchFile, summary.getMatch());
        } catch (IOException e) {
            logger.error("Error in writing data to match output files");
        }
        try {
            mapper.writeValue(misMatchFile, summary.getMatch());
        } catch (IOException e) {
            logger.error("Error in writing data to mismatch output files");
        }
    }

    private BranchDetails process(File file) {
        ObjectMapper mapper = new ObjectMapper();
        CmFoodChain cmFoodChain = null;
        try {
            cmFoodChain = mapper.readValue(file, CmFoodChain.class);
        } catch (IOException e) {
            logger.error("Error in object mapping for file with name {}", file.getName());
        }

        try {
            if (cmFoodChain != null) {
                BranchDetails branchDetails = new BranchDetails();
                branchDetails.setLocation(cmFoodChain.getBranch().getLocation());
                branchDetails.setLocationId(cmFoodChain.getBranch().getLocationId());
                branchDetails.setTotalCollection(cmFoodChain.getBranch().getTotalCollection());

                List<OrderDetail> orders = cmFoodChain.getOrders();
                Double aggregatedRevenue = 0d;
                for (OrderDetail order : orders) {
                    aggregatedRevenue += order.getBillAmount();
                }
                branchDetails.setSumOfOrder(aggregatedRevenue);
                if (aggregatedRevenue.equals(cmFoodChain.getBranch().getTotalCollection())) {
                    branchDetails.setIsMatch(true);
                } else {
                    branchDetails.setIsMatch(false);
                }
                return branchDetails;
            }
        } catch (Exception ex) {
            logger.error("Error in data processing for file with name {}", file.getName());
        }
        return null;
    }

    private BranchSummary getBranchSummary(BranchDetails branchDetails) {
        BranchSummary branchSummary = new BranchSummary();
        branchSummary.setLocation(branchDetails.getLocation());
        branchSummary.setLocationId(branchDetails.getLocationId());
        branchSummary.setSumOfOrder(branchDetails.getSumOfOrder());
        branchSummary.setTotalCollection(branchDetails.getTotalCollection());
        return branchSummary;
    }
}
