package com.ebs.model;

/**
 * Created by gaurav on 04/07/17.
 */
public class Revenue {

    private int revenueId;
    private String type;
    private String amount;
    private String month;

    public Revenue(int revenueId,String type, String amount, String month) {
        this.revenueId = revenueId;
        this.type = type;
        this.amount = amount;
        this.month = month;
    }

    public int getRevenueId() {
        return revenueId;
    }

    public void setRevenueId(int revenueId) {
        this.revenueId = revenueId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }
}
