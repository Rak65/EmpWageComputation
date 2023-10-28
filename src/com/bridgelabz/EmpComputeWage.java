package com.bridgelabz;

public class EmpComputeWage {
    public static final int IS_PART_TIME = 1;
    public static final int IS_FULL_TIME = 2;

    private final String company;
    private final int empRatePerHour;
    private final int numOfWorkinDays;
    private final int maxHoursPerMonth;
    private int totalEmpWage;

    public EmpComputeWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth)
    {
        this.company = company;
        this.empRatePerHour = empRatePerHour;
        this.maxHoursPerMonth = maxHoursPerMonth;
        this.numOfWorkinDays = numOfWorkingDays;
    }

    public void computeEmpWage()
    {
        //variables
        int empHrs = 0 , totalEmpHours =0 , totalWorkingDays = 0;

        //computation
        while(totalEmpHours < maxHoursPerMonth && totalWorkingDays < numOfWorkinDays )
        {
            totalWorkingDays++;
            int empCheck = (int) Math.floor(Math.random() * 10) % 3;

            empHrs = switch (empCheck) {
                case IS_PART_TIME -> 4;
                case IS_FULL_TIME -> 8;
                default -> 0;
            };
            totalEmpHours += empHrs;
            System.out.println("Day:: "+totalWorkingDays+ " Emp Hrs:: "+totalEmpHours);
        }

        totalEmpWage = totalEmpHours * empRatePerHour;
    }

    public String toString()
    {
        return "Total wage for company "+ company+ " is " + totalEmpWage;
    }

    public static void main(String[] args) {
        EmpComputeWage dMart = new EmpComputeWage("DMart" , 20, 2, 10);
        EmpComputeWage reliance = new EmpComputeWage("Reliance" , 10, 4, 20);
        dMart.computeEmpWage();
        System.out.println(dMart);
        reliance.computeEmpWage();
        System.out.println(reliance);
    }
}
