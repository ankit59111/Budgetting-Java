package com.ebs.model;

/**
 * Created by gaurav on 05/07/17.
 */
public class RevenueType {
    private int revenueId;
    private String revenueName;

    public RevenueType(int revenueId, String revenueName) {
        this.revenueId = revenueId;
        this.revenueName = revenueName;
    }

    public int getRevenueId() {
        return revenueId;
    }

    public void setRevenueId(int revenueId) {
        this.revenueId = revenueId;
    }

    public String getRevenueName() {
        return revenueName;
    }

    public void setRevenueName(String revenueName) {
        this.revenueName = revenueName;
    }
}
