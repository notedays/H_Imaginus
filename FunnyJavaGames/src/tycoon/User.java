package tycoon;

public class User {

	String name;
	int powder;
	int money;
	int numberOfBread;
	int breadCase = 8;
	
	public int getBreadCase() {
		return breadCase;
	}

	public void setBreadCase(int breadCase) {
		this.breadCase = breadCase;
	}

	public User(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPowder() {
		return powder;
	}
	public void setPowder(int powder) {
		this.powder = powder;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getNumberOfBread() {
		return numberOfBread;
	}
	public void setNumberOfBread(int numberOfBread) {
		this.numberOfBread = numberOfBread;
	}
	
	
	
	
}
