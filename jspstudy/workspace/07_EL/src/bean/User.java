
package bean;

public class User {
	private String name;
	private int age;
	private String gender;
	private String[] hobbies;
	private String addr;
	private String[] foods;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String[] getHobbies() {
		return hobbies;
	}
	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String[] getFoods() {
		return foods;
	}
	public void setFoods(String[] foods) {
		this.foods = foods;
	}
}
