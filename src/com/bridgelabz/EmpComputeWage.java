package com.bridgelabz;

public class EmpComputeWage {

    public final String company;
    public final int empRatePerHour;
    public final int numOfWorkingDays;
    public final int maxHoursPerMonth;
    public int totalEmpWage;

    public EmpComputeWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth)
    {
        this.company = company;
        this.empRatePerHour = empRatePerHour;
        this.maxHoursPerMonth = maxHoursPerMonth;
        this.numOfWorkingDays = numOfWorkingDays;
        totalEmpWage =0;
    }

    public void setTotalEmpWage(int totalEmpWage){
        this.totalEmpWage=totalEmpWage;
    }
    @Override
    public String toString()
    {
        return "Total wage for company "+ company+ " is " + totalEmpWage;
    }
}
