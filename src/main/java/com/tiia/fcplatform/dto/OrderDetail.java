package com.tiia.fcplatform.dto;

/**
 * Created by AmitG on 8/3/2018.
 */
public class OrderDetail {
    private Long orderId;
    private Double billAmount;

    public Double getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(Double billAmount) {
        this.billAmount = billAmount;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
