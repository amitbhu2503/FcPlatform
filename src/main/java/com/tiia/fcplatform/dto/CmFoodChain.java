package com.tiia.fcplatform.dto;

import java.util.List;

/**
 * Created by AmitG on 8/3/2018.
 */
public class CmFoodChain {
    private Branch branch;
    private List<OrderDetail> orders;

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public List<OrderDetail> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderDetail> orders) {
        this.orders = orders;
    }
}
