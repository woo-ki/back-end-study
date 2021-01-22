package ex03_exception_quiz;

// 1. 입금 예외
// 1) 마이너스 입금 시 예외 발생
class DepositException extends Exception {
	public DepositException(String message) {
		super(message);
	}
}

// 2. 출금 예외
// 1) 마이너스 출금 시 예외 발생
// 2) 통장잔고보다 큰 금액 출금 시 예외 발생
class WithdrawException extends Exception {
	public WithdrawException(String message) {
		super(message);
	}
}

class BankAccount {
	private String accNo;	// 계좌번호
	private long balance;	// 잔고
	
	public BankAccount(String accNo, long balance) {
		super();
		this.accNo = accNo;
		this.balance = balance;
	}
	
	// 1. 입금 deposit
	public void deposit(long money) throws DepositException {
		if(money < 0) {
			DepositException e = new DepositException("입력금액 오류입니다.");
			throw e;
		}
		balance += money;
	}
	// 2. 출급 withdraw
	// 1) 결과 실제로 출금된 금액
	// 2) 매개변수 출금 요청 금액
	public long withdraw(long money) throws WithdrawException {
		if(money < 0) {
			WithdrawException e = new WithdrawException("입력금액 오류입니다.");
			throw e;
		} else if(money > balance) {
			WithdrawException e = new WithdrawException("잔액부족 입니다.");
			throw e;
		}
		balance -= money;
		return money;
	}
	// 3. 조회 inquiry
	public void inquiry() {
		System.out.println(accNo + "(잔고: " + balance + "원)");		
	}
	// 4. 이체 transfer
	public void transfer(BankAccount you, long money) throws DepositException, WithdrawException {
		this.withdraw(money);
		you.deposit(money);
	}
}

public class Quiz03 {

	public static void main(String[] args) {

		BankAccount me = new BankAccount("123-456", 50000);
		BankAccount you = new BankAccount("654-321", 50000);
		
		try {
			me.transfer(you, 20000);	// 정상동작
		} catch(DepositException e) {
			System.out.println(e.getMessage());
		} catch(WithdrawException e) {
			System.out.println(e.getMessage());
		}
		me.inquiry(); 				// 123-456(잔고: 0원)
		you.inquiry(); 				// 654-321(잔고: 100000원)
		
	}

}
