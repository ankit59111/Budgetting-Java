package com.ebs.model;

/**
 * Created by gaurav on 05/07/17.
 */
public class ExpenditureType {

    private int expenditureId;
    private String expenditureName;

    public ExpenditureType(int expenditureId, String expenditureName) {
        this.expenditureId = expenditureId;
        this.expenditureName = expenditureName;
    }

    public int getExpenditureId() {
        return expenditureId;
    }

    public void setExpenditureId(int expenditureId) {
        this.expenditureId = expenditureId;
    }

    public String getExpenditureName() {
        return expenditureName;
    }

    public void setExpenditureName(String expenditureName) {
        this.expenditureName = expenditureName;
    }
}
