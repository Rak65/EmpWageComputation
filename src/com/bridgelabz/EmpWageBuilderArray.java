package com.bridgelabz;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class EmpWageBuilderArray implements IComputeEmpWage{
    public static final int IS_PART_TIME = 1;
    public static final int IS_FULL_TIME = 2;

    private LinkedList<EmpComputeWage> companyEmpWageList;
    private Map<String, EmpComputeWage> companyToEmpWageMap;
    public EmpWageBuilderArray(){
        companyEmpWageList = new LinkedList<>();
        companyToEmpWageMap = new HashMap<>();
    }
    public void addCompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth){
        EmpComputeWage companyEmpWage= new EmpComputeWage(company,empRatePerHour,numOfWorkingDays,maxHoursPerMonth);
        companyEmpWageList.add(companyEmpWage);
        companyToEmpWageMap.put(company,companyEmpWage);
    }
    public void computeEmpWage(){
        for (int i = 0; i<companyEmpWageList.size(); i++){
            EmpComputeWage companyEmpWage = companyEmpWageList.get(i);
            companyEmpWage.setTotalEmpWage(this.computeEmpWage(companyEmpWage));
            System.out.println(companyEmpWage);
        }
    }

    private int computeEmpWage(EmpComputeWage empComputeWage){
        //variables
        int empHrs = 0 , totalEmpHours =0 , totalWorkingDays = 0;

        //computation
        while(totalEmpHours <= empComputeWage.maxHoursPerMonth && totalWorkingDays < empComputeWage.numOfWorkingDays)
        {
            totalWorkingDays++;
            int empCheck = (int) Math.floor(Math.random() * 10) % 3;

            empHrs = switch (empCheck) {
                case IS_PART_TIME -> 4;
                case IS_FULL_TIME -> 8;
                default -> 0;
            };
            totalEmpHours += empHrs;
            System.out.println("Day#: "+totalWorkingDays+ " Emp Hrs#: "+empHrs);
        }

        return totalEmpHours * empComputeWage.empRatePerHour;
    }
    public static void main(String[] args) {
        EmpWageBuilderArray empWageBuilderArray = new EmpWageBuilderArray();
        empWageBuilderArray.addCompanyEmpWage("DMart",20,2,10);
        empWageBuilderArray.addCompanyEmpWage("Reliance",10,4,20);
        empWageBuilderArray.computeEmpWage();
    }
}
