package com.ebs.model;

/**
 * Created by gaurav on 05/07/17.
 */
public class Expenditure {
    private int expenditureId;
    private  String departmentName;
    private String month;
    private  String activityName;
    private String amount;

    public Expenditure(int expenditureId, String departmentName, String month, String activityName, String amount) {
        this.expenditureId = expenditureId;
        this.departmentName = departmentName;
        this.month = month;
        this.activityName = activityName;
        this.amount = amount;

    }

    public int getExpenditureId() {
        return expenditureId;
    }

    public void setExpenditureId(int expenditureId) {
        this.expenditureId = expenditureId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }


}
