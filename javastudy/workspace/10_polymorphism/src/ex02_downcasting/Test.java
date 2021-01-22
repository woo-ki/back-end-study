package ex02_downcasting;

import java.util.Scanner;

class Staff {
	String name;	// 이름
	String depart;	// 부서
	
	Staff(String name, String depart) {
		this.name = name;
		this.depart = depart;
	}
	
	public String getName() {
		return name;
	}
	
	int pay() {
		return 0;
	}
}

class SalaryMan extends Staff {
	int salary;		// 기본급
	
	SalaryMan(String name, String depart, int salary) {
		super(name, depart);
		this.salary = salary;
	}
	
	@Override
	int pay() {
		return salary;
	}
}

class SalesMan extends SalaryMan {
	int salesVolume;	// 판매량
	double incentive;	// 인센티브(판매량이 100 이상이면 20%, 아니면 5%)
	
	SalesMan(String name, String depart, int salary) {
		super(name, depart, salary);
	}
	
	void setSalesVolume(int salesVolume) {
		this.salesVolume = salesVolume;
		this.incentive = salesVolume >= 100 ? 0.2 : 0.05;
	}
	
	int salesPay() {
		return (int)(salesVolume * incentive);
	}
	
	@Override
	int pay() {
		return super.pay() + salesPay();
	}
}

class Alba extends Staff {
	int times;		// 일한 시간
	int payPerHour;	// 시급
	
	Alba(String name, String depart, int payPerHour) {
		super(name, depart);
		this.payPerHour = payPerHour;
	}
	
	void setTimes(int times) {
		this.times = times;
	}
	
	@Override
	int pay() {
		return payPerHour * times;
	}
}

class Company {
	private Staff[] staffs;
	private int idx;
	Scanner sc = new Scanner(System.in);
	
	Company() {
		staffs = new Staff[10];
		idx = 0;
	}
	
	public void addStaff(Staff staff) {
		staffs[idx++] = staff;
	}
	
	public void info() {
		for(Staff staff : staffs) {
			if(staff != null) {
				if(staff instanceof SalesMan) {
					System.out.print("판매량을 입력하세요 >> ");
					((SalesMan)staff).setSalesVolume(sc.nextInt());
					sc.nextLine();
					System.out.println(staff.getName() + "의 급여: " + staff.pay() + "만원");
				} else if(staff instanceof Alba) {
					System.out.print("알바 시간을 입력하세요 >> ");
					((Alba)staff).setTimes(sc.nextInt());
					sc.nextLine();
					System.out.println(staff.getName() + "의 급여: " + staff.pay() + "만원");
				} else {
					System.out.println(staff.getName() + "의 급여: " + staff.pay() + "만원");
				}
			}
		}
		sc.close();
	}
}

//SalaryMan s1 = new SalaryMan("제임스", "총무부", 300);
//System.out.println("s1의 급여: " + s1.pay() + "만원");	// s1의 급여: 300만원
//
//SalesMan s2 = new SalesMan("에밀리", "판매부", 100);
//s2.setSalesVolume(200);	// 판매량 설정
//System.out.println("s2의 급여: " + s2.pay() + "만원");	// s2의 급여: 140만원
//
//Alba s3 = new Alba("데이빗", "홍보부", 1);
//s3.setTimes(100);	// 일한 시간 설정
//System.out.println("s3의 급여: " + s3.pay() + "만원");	// s2의 급여: 100만원

public class Test {

	public static void main(String[] args) {

		Company company = new Company();
		company.addStaff(new Alba("데이빗", "홍보부", 1));
		company.addStaff(new SalaryMan("제임스", "총무부", 300));
		company.addStaff(new SalesMan("에밀리", "판매부", 100));
		company.info();
		
	}

}
