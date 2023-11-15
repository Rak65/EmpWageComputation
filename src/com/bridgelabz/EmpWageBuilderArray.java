package com.bridgelabz;

public class EmpWageBuilderArray {
    public static final int IS_PART_TIME = 1;
    public static final int IS_FULL_TIME = 2;

    private int numOfCompany = 0;
    private EmpComputeWage[] empComputeWagesArray;
    public EmpWageBuilderArray(){
        empComputeWagesArray = new EmpComputeWage[5];
    }
    private void addCompanyEmpWage(String company, int empRatePerHour,int numOfWorkingDays, int maxHoursPerMonth){
        empComputeWagesArray[numOfCompany] = new EmpComputeWage(company,empRatePerHour,numOfWorkingDays,maxHoursPerMonth);
        numOfCompany++;
    }
    private void computeEmpWage(){
        for (int i = 0; i<numOfCompany; i++){
            empComputeWagesArray[i].setTotalEmpWage(this.computeEmpWage(empComputeWagesArray[i]));
            System.out.println(empComputeWagesArray[i]);
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
