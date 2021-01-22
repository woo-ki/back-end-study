package ex04_quiz;

abstract class Fighter {
	private String name;
	private boolean isAlive;
	private int energy;	// 에너지(80 ~ 100)
	private int power;	// 공격력(0 ~ 9)
	
	public Fighter(String name) {
		super();
		this.name = name;
		energy = (int)(Math.random() * 21) + 80;
		isAlive = energy != 0;
	}

	public abstract void attack(Fighter fighter);
	// KoreanFighter 는 20% 확률로 한 방에 죽임
	// ForeignFighter 는 10% 확률로 한 방에 죽임

	public String getName() {
		return name;
	}
	public boolean isAlive() {
		if(getEnergy() <= 0) {
			setAlive(false);
		} else {
			setAlive(true);
		}
		return isAlive;
	}
	private void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public int getEnergy() {
		return energy;
	}
	public void setEnergy(int energy) {
		this.energy = energy;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
}

class KoreanFighter extends Fighter {
	public KoreanFighter(String name) {
		super(name);
	}

	@Override
	public void attack(Fighter fighter) {
		double KO = Math.random();
		if(KO <= 0.2) {
			fighter.setEnergy(0);
			System.out.println(fighter.getName() + "을(를) K.O 시켰습니다.");
			return;
		}
		this.setPower((int)(Math.random() * 9));
		int residualEnergy = fighter.getEnergy() - this.getPower();
		fighter.setEnergy(residualEnergy);
		System.out.println(this.getPower() + "의 데미지를 입혔습니다.");
	}
}

class ForeignFighter extends Fighter {
	public ForeignFighter(String name) {
		super(name);
	}

	@Override
	public void attack(Fighter fighter) {
		double KO = Math.random();
		if(KO <= 0.1) {
			fighter.setEnergy(0);
			System.out.println(fighter.getName() + "을(를) K.O 시켰습니다.");
			return;
		}
		this.setPower((int)(Math.random() * 9));
		int residualEnergy = fighter.getEnergy() - this.getPower();
		fighter.setEnergy(residualEnergy);
		System.out.println(this.getPower() + "의 데미지를 입혔습니다.");
	}
}

public class Quiz01 {

	public static void main(String[] args) {

		Fighter fighter1 = new KoreanFighter("정찬성");
		Fighter fighter2 = new ForeignFighter("에드가");
		
		System.out.println("싸움 시작");
		
		// 공격 차례
		boolean myTurn = Math.random() < 0.5 ? false : true;
		
		do {	// 둘 다 살아있으면 진행
			if(myTurn) {
				System.out.println(fighter1.getName() + "의 공격");
				fighter1.attack(fighter2);
				myTurn = false;
			} else {
				System.out.println(fighter2.getName() + "의 공격");
				fighter2.attack(fighter1);
				myTurn = true;
			}
		} while(fighter1.isAlive() && fighter2.isAlive());
		
		System.out.println("싸움 끝");
		
		// 누가 이겼는가?
		if(fighter1.isAlive()) {
			System.out.println(fighter1.getName() + "의 승리. 남은 에너지: " + fighter1.getEnergy());
		} else {
			System.out.println(fighter2.getName() + "의 승리. 남은 에너지: " + fighter2.getEnergy());
		}
		
	}

}
