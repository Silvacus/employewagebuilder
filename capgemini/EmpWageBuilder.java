package capgemini;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EmpWageBuilder implements IComputeEmpWage {
	
	public static final int IS_FULL_TIME = 1;
	public static final int IS_PART_TIME = 2;
	
	private ArrayList<Company> companyEmpWageList;
	private Map<String, Company> companyToEmpWageMap;
   
    public EmpWageBuilder() {
    	companyEmpWageList = new ArrayList<>();
    	companyToEmpWageMap = new HashMap<>();
    }
    
    @Override
    public void addCompanyEmpWage(String company, int empRatePerHour,int numOfWorkingDays, int maxHoursPerMonth ) {
    	Company companyEmpWage = new Company(company, empRatePerHour, numOfWorkingDays, maxHoursPerMonth);
		companyEmpWageList.add(companyEmpWage);
		companyToEmpWageMap.put(company, companyEmpWage);
    }
    
    @Override
	public void computeEmpWage() {
	    for(int i=0;i<companyEmpWageList.size();i++) {	
	    	Company companyEmpWage = companyEmpWageList.get(i);
	    	companyEmpWage.setTotalEmpWage(this.computeEmpWage(companyEmpWage));
			System.out.println(companyEmpWage);
    	}	
	}
    
	private int computeEmpWage(Company companyEmpWage) {
		int empHours = 0, totalEmpHours = 0, totalWorkingDays = 0;
		while (totalEmpHours <= companyEmpWage.maxHoursPerMonth && totalWorkingDays < companyEmpWage.numOfWorkingDays) {
			totalWorkingDays++;
            int empCheck = (int)Math.floor(Math.random()* 10)% 3;

			switch (empCheck) {
			case IS_PART_TIME:
				empHours = 4;
				break;
			case IS_FULL_TIME:
				empHours = 8;
				break;
			default:
				empHours = 0;
			}
			totalEmpHours += empHours;
			System.out.println("Day: " + totalWorkingDays + " Emp Hr:  " + empHours);
		}
       return totalEmpHours * companyEmpWage.empRatePerHour;
	}
	
	@Override
	public int getTotalWage(String company) {
		return 0;
	}
	 public static void main(String[] args) {
		 EmpWageBuilder empWageBuilder = new EmpWageBuilder();
		 empWageBuilder.addCompanyEmpWage("Heritage",  20,  2,  10);
		 empWageBuilder.addCompanyEmpWage("smart",  10,  4,  20);
		 empWageBuilder.computeEmpWage();
	 }
	
}