package com.ebs.model;

/**
 * Created by gaurav on 05/07/17.
 */
public class Department {

    private int departmentId;
    private String departmentName;
    private long allottedRevenue;

    public Department(int departmentId, String departmentName) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
    }

    public Department(int departmentId, String departmentName, long allottedRevenue) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.allottedRevenue = allottedRevenue;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public long getAllottedRevenue() {
        return allottedRevenue;
    }

    public void setAllottedRevenue(long allottedRevenue) {
        this.allottedRevenue = allottedRevenue;
    }
}
