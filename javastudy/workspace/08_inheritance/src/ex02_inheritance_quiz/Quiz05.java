package ex02_inheritance_quiz;

class Staff {
	String name;	// 이름
	String depart;	// 부서
	
	Staff(String name, String depart) {
		this.name = name;
		this.depart = depart;
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

public class Quiz05 {

	public static void main(String[] args) {

		SalaryMan s1 = new SalaryMan("제임스", "총무부", 300);
		System.out.println("s1의 급여: " + s1.pay() + "만원");	// s1의 급여: 300만원
		
		SalesMan s2 = new SalesMan("에밀리", "판매부", 100);
		s2.setSalesVolume(200);	// 판매량 설정
		System.out.println("s2의 급여: " + s2.pay() + "만원");	// s2의 급여: 140만원
		
		Alba s3 = new Alba("데이빗", "홍보부", 1);
		s3.setTimes(100);	// 일한 시간 설정
		System.out.println("s3의 급여: " + s3.pay() + "만원");	// s2의 급여: 100만원
		
	}

}
