package com.tiia.fcplatform.dto;

/**
 * Created by AmitG on 8/3/2018.
 */
public class Branch {
    private String location;
    private Double totalCollection;
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

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }
}
