package capgemini;



public class EmpWageBuilder {
	
	public static final int IS_FULL_TIME = 1;
	public static final int IS_PART_TIME = 2;
   
	public int numOfCompany = 0;
	private Company[] companyEmpWageArray;
	
    public EmpWageBuilder() {
    	companyEmpWageArray = new Company[5];
    }
    private void addCompanyEmpWage(String company, int empRatePerHour,int numOfWorkingDays, int maxHoursPerMonth ) {
    	companyEmpWageArray[numOfCompany] = new Company(company, empRatePerHour, numOfWorkingDays, maxHoursPerMonth);
    numOfCompany++;
    }
    
	private void computeEmpWage() {
		for(int i =0; i < numOfCompany; i++) {
			companyEmpWageArray[i].setTotalEmpWage(this.computeEmpWage(companyEmpWageArray[i]));
		System.out.println(companyEmpWageArray[i]);
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
	 public static void main(String[] args) {
		 EmpWageBuilder empWageBuilder = new EmpWageBuilder();
		 empWageBuilder.addCompanyEmpWage("Heritage",  20,  2,  10);
		 empWageBuilder.addCompanyEmpWage("smart",  10,  4,  20);
		 empWageBuilder.computeEmpWage();
	 }
	
}