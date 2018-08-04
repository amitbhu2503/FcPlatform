package com.tiia.fcplatform.dto;

/**
 * Created by AmitG on 8/4/2018.
 */
public class BranchSummary {
    private String location;
    private Double totalCollection;
    private Double sumOfOrder;
    private String locationId;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }
}
