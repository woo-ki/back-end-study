package ex04_quiz;

class Food {
	private String foodName;
	private int foodCalorie;
	
	public Food(String foodName, int foodCalorie) {
		super();
		this.foodName = foodName;
		this.foodCalorie = foodCalorie;
	}

	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public int getFoodCalorie() {
		return foodCalorie;
	}
	public void setFoodCalorie(int foodCalorie) {
		this.foodCalorie = foodCalorie;
	}
	public void eat() {
		System.out.println(foodName+ " " + foodCalorie + "kcal를 먹습니다.");
	}
}

interface Eatable{}	// 먹을 수 있는 음식은 Eatalbe

class Apple extends Food implements Eatable {
	public Apple(String foodName, int foodCalorie) {
		super(foodName, foodCalorie);
	}
	
}

class Burger extends Food {
	public Burger(String foodName, int foodCalorie) {
		super(foodName, foodCalorie);
	}

}

class Person {
	private int calori;
	private String name;
	
	public Person(String name) {
		super();
		this.name = name;
	}

	public int getCalori() {
		return calori;
	}

	public void setCalori(int calori) {
		this.calori = calori;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void eat(Eatable food) {
		((Food)food).eat();
		setCalori(this.calori + ((Food)food).getFoodCalorie());
	}
	public void info() {
		System.out.println(name + "는 현재 " + calori + "입니다.");
	}
}
public class Quiz03 {

	public static void main(String[] args) {

		
		Person p = new Person("제시카");
		
		p.setCalori(300);
		p.info();	//제시카는 현재 300kcal 입니다.
		
		p.eat(new Apple("청송사과", 200));	// 청송사과 200kcal
		p.info();	// 제시카는 현재 500kcal 입니다.
		
		//p.eat(new Burger("빅맥", 1000));	// 못 먹게 막아보세요.
	}

}
