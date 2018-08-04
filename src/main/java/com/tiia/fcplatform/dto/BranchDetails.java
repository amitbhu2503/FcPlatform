package com.tiia.fcplatform.dto;

/**
 * Created by AmitG on 8/4/2018.
 */
public class BranchDetails {
    private String location;
    private Double totalCollection;
    private Double sumOfOrder;
    private String locationId;
    private boolean isMatch;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public boolean isMatch() {
        return isMatch;
    }

    public void setIsMatch(boolean isMatch) {
        this.isMatch = isMatch;
    }

    public Double getTotalCollection() {
        return totalCollection;
    }

    public void setTotalCollection(Double totalCollection) {
        this.totalCollection = totalCollection;
    }

    public Double getSumOfOrder() {
        return sumOfOrder;
    }

    public void setSumOfOrder(Double sumOfOrder) {
        this.sumOfOrder = sumOfOrder;
    }
}
