package capgemini;

public class EmpWageBuilder {
	public static final int IS_PART_TIME=1;
	public static final int IS_FULL_TIME=2;
	
	private final String company;
	private final int numofWorkingDays;
	private final int empRatePerHour;
	private final int maxHoursPerMonth;
	private int totalEmpWage;
	
	public EmpWageBuilder(String company,int empRatePerHour,int numofWorkingDays,int maxHoursPerMonth) {
		this.company=company;
		this.empRatePerHour=empRatePerHour;
		this.numofWorkingDays=numofWorkingDays;
		this.maxHoursPerMonth=maxHoursPerMonth;
	}
		
	public void computeEmpWage(){
		int empHrs=0;
       		int totalEmpHrs=0;
       		int totalWorkingDays=0;
       		System.out.println(company+" :");
		while(totalEmpHrs<=maxHoursPerMonth && totalWorkingDays<numofWorkingDays) {
			totalWorkingDays+=1;
			int empCheck=(int) Math.floor(Math.random()*10) % 3;
			switch(empCheck) {
					case IS_PART_TIME:
						empHrs=4;
						System.out.println("Employee is Part time employee");
						break;
					case IS_FULL_TIME:
						empHrs=8;
						System.out.println("Employee is Full time employee");
						break;
					default:
						empHrs=0;	
			}
			totalEmpHrs+=empHrs;
		  System.out.println("Day#: "+totalWorkingDays +" Emp Hr: "+empHrs);
     }
    totalEmpWage=totalEmpHrs*empRatePerHour;     	
	}
	@Override
	public String toString() {
		return "Total Employee Wage for "+company+" is : "+totalEmpWage;
	}
	public static void main(String[] args) {
		System.out.println("Employee Wage Builder");
    		EmpWageBuilder heritage=new EmpWageBuilder("Heritage",30,20,100);
    		EmpWageBuilder smart=new EmpWageBuilder("Smart",15,22,150);
    		heritage.computeEmpWage();
    		System.out.println(heritage);
    		smart.computeEmpWage();
    		System.out.println(smart);
	}
}