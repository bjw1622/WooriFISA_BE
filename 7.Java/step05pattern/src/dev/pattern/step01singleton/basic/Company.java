package dev.pattern.step01singleton.basic;

public class Company {

	/*
	 * 상황 가정 : 회사 내에 프린터기(CompanyPrinter)가 1대밖에 없기 때문에
	 * 직원(Employee)들이 번갈아가면서 사용해야함
	 * */
	
	// 최대 직원 수
	private static final int EMPLOYEES = 5;
	
	public static void main(String[] args) {
		// 직원 객체를 담고 있는 배열
		Employee[] employees = new Employee[EMPLOYEES];
		for(int i =0; i<employees.length; i++) {
			employees[i] = new Employee("user-"+i);
			employees[i].usePrinter();
		}
		
	}

}
