package capgemini;

public class EmpWageBuilder {
	public static void main(String[] args) {

		System.out.println("Employee Wage Builder");
		

		int IS_FULL_TIME=1;
    int EMP_RATE_PER_HOUR=20;
    
    int empHrs=0;
		int empWage=0;
    
		double empcheck= Math.floor(Math.random()*10)%2; 
		if(empcheck==IS_FULL_TIME) {
			System.out.println("Employee present");
		}
		else {
			System.out.println("Employee absent");
		}
    
		double empCheck=Math.floor(Math.random()*10)%2;
		if(empCheck== IS_FULL_TIME) {
			empHrs=8;
		}
		else {
			empHrs=0;
		}
		empWage= empHrs*EMP_RATE_PER_HOUR;
		System.out.println("Employee Wage: "+empWage);

	}
}