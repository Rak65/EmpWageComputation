package com.bridgelabz;

public interface IComputeEmpWage {
    void addCompanyEmpWage(String company, int empRatePerHour,int numOfWorkingDays, int maxHoursPerMonth);
    void computeEmpWage();
}
