package com.ebs.factory;

/**
 * Created by gaurav on 05/07/17.
 */
public class IdFactory {

    public static int getrevenueTypeId(String revenueType) {
        switch (revenueType) {
            case "Fees":
                return 0;
            case "Donation":
                return 6;
            case "Government Grants":
                return 7;
            case "Research Sponsor":
                return 8;
            case "Other Income":
                return 9;
            default:
                return -1;
        }
    }


    public static int getMonthId(String month) {
        switch (month) {
            case "January":
                return 1;
            case "February":
                return 2;
            case "March":
                return 3;
            case "April":
                return 4;
            case "May":
                return 5;
            case "June":
                return 6;
            case "July":
                return 7;
            case "August":
                return 8;
            case "September":
                return 9;
            case "October":
                return 10;
            case "November":
                return 11;
            case "December":
                return 12;
            default:
                return 0;
        }
    }

    public static int getDepartmentId(String department) {
        switch (department) {
            case "Engineering":
                return 1;
            case "Medical":
                return 2;
            case "Management":
                return 3;
            case "Arts":
                return 4;
            case "Commerce":
                return 5;
            case "College Administration":
                return 6;
            case "CCPD":
                return 7;
            default:
                return 0;
        }
    }

    public static int getExpenditureId(String expenditure) {
        switch (expenditure) {
            case "Debt Charges":
                return 1;
            case "Faculty Salary":
                return 2;
            case "Infrastruture":
                return 3;
            case "Event":
                return 4;
            case "State of Art Laboratory":
                return 5;
            case "Placement Drive":
                return 6;
            case "Miscellaneous":
                return 7;
            case "Transportation":
                return 8;
            case "Student Development Program":
                return 9;
            default:
                return 0;

        }
    }

}
