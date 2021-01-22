package ex02_interface;

interface Walkable {
	void walkingWithPet();
}
class Pet {
	private String name;

	public Pet(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void feed(String food) {
		System.out.println(name + ", " + food + "먹는다.");
	}
}

class Dog extends Pet implements Walkable {
	public Dog(String name) {
		super(name);
	}
	
	@Override
	public void walkingWithPet() {
		System.out.println(getName() + "와 산책하기");
	}
}

class Turtle extends Pet {
	public Turtle(String name) {
		super(name);
	}
}

class Person {
	// method
	public void feed(Pet pet, String food) {
		pet.feed(food);
	}
	
//	public void walkingWithPet(Pet pet) {
//		((Walkable)pet).walkingWithPet();
//	}
	public void walkingWithPet(Walkable pet) {
		System.out.println(((Pet)pet).getName() + "와 산책하기");
	}
}

public class Ex04_Walkable {

	public static void main(String[] args) {

		Person p = new Person();
		Dog dog = new Dog("멍뭉이");
		Turtle turtle = new Turtle("꼬북이");
		p.feed(dog, "닭가슴살");
		p.feed(turtle, "참치");
		
		p.walkingWithPet(dog);		// 멍뭉이와 산책하기
		// p.walkingWithPet(turtle);	// 실행이 되지 않도록 처리
		
	}

}
