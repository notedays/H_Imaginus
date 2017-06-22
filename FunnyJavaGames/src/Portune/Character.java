package Portune;

public class Character {

	String name;
	int age = 20;
	String [] fortune = new String[5];
	
	public Character(String name) {
		super();
		this.name = name;
		this.age = age;
		this.fortune = fortune;
	}

	
	//	setter, getter
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

	public String[] getFortune() {
		return fortune;
	}

	public void setFortune(String[] fortune) {
		this.fortune = fortune;
	} 
	
}
