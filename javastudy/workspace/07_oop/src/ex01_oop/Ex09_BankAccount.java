package ex01_oop;

class BankAccount {
	// field
	String account;
	long balance;
	// constructor
	BankAccount(String account, long balance) {
		this.account = account;
		this.balance = balance;
	}
	// method
	void deposit(long money) {
		if(money <= 0) {
			System.out.println("입금 오류");
			return;
		}
		this.balance += money;
	}
	void inquiry() {
		System.out.println("계좌번호: " + account + ", 잔액: " + balance + "원");
	}
//	void withdraw(long money) {
//		if(money <= 0) {
//			System.out.println("출금 오류");
//			return;
//		}
//		long tump = this.balance;
//		this.balance -= money;
//		if(this.balance < 0) {
//			System.out.println("잔액 부족. 출금 불가.");
//			this.balance = tump;
//		}
//	}
//	void transfer(BankAccount account, long money) {
//		if(money <= 0 || money > this.balance) {
//			System.out.println("이체 오류");
//			return;
//		}
//		this.withdraw(money);
//		account.deposit(money);
//	}
			
//	boolean withdraw(long money) {
//		if(money <= 0 || this.balance < money) {
//			System.out.println("출금 불가");
//			return false;
//		} else {
//			this.balance -= money;
//			return true;
//		}
//	}	
//	void transfer(BankAccount account, long money) {
//		// 이체
//		// 1. 내계좌 출금
//		// 2. account 계좌 입금
//		if(this.withdraw(money) == true) {
//			account.deposit(money);
//		}
//	}
	
	// 출금
	// 1) 결과타입 : long	(실제로 출금된 금액)
	// 2) 메소드명 : withdraw
	// 3) 매개변수 : long money
	long withdraw(long money) {
		if(money <= 0 || this.balance < money) {
			System.out.println("출금 불가");
			return 0;
		}
		this.balance -= money;
		return money;
	}	
	void transfer(BankAccount account, long money) {
		// 이체
		// 1. 내계좌 출금
		// 2. account 계좌 입금
		account.deposit(this.withdraw(money));
	}
}

public class Ex09_BankAccount {

	public static void main(String[] args) {

		BankAccount me = new BankAccount("1234", 10_000);
		BankAccount mom = new BankAccount("4321", 100_000);
		
		me.deposit(10_000);		// 내 계좌에 10_000원 넣기
		me.deposit(-100);		// 내 계좌에 마이너스 입금 (불가능)
		
		me.withdraw(20_000);	// 내 계좌에서 20_000 출금
		me.withdraw(100);		// 내 계좌에서 잔액보다 큰 금액 출금 (불가능)
		
		me.inquiry();			// 계좌번호: 1234, 잔액: 0원
		
		// 여기까지 1단계
		
		mom.transfer(me, 50_000);		// 엄마가 내 계좌에 50_000원 이체
		mom.transfer(me, -100);			// 실패
		mom.transfer(me, 100_000_000);	// 실패
		
		// 여기까지 2단계
		mom.inquiry();
		me.inquiry();

	}

}
