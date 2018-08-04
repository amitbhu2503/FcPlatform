package com.tiia.fcplatform.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AmitG on 8/4/2018.
 */
public class CmFoodChainSummary {

    private List<BranchSummary> match;
    private List<BranchSummary> misMatch;

    public CmFoodChainSummary() {
        this.match = new ArrayList<>();
        this.misMatch = new ArrayList<>();
    }

    public List<BranchSummary> getMatch() {
        return match;
    }

    public List<BranchSummary> getMisMatch() {
        return misMatch;
    }

    public void addMatch(BranchSummary branchSummary) {
        this.match.add(branchSummary);
    }

    public void addMisMatch(BranchSummary branchSummary) {
        this.misMatch.add(branchSummary);
    }
}
