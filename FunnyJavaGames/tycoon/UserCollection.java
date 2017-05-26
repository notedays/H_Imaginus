package tycoon;

public enum UserCollection {

	Silver(1, "Silver Class", 1000, 50, 10),
	Gold(2, "Gold Class", 5000, 100, 20),
	Platinum(3, "Platinum Class", 10000, 150, 30),
	Vip(4, "Vip Class", 15000, 200, 40);
	
	private final int code;
	private final String name;
	private final int money;
	private final int powder;
	private final int numberOfBread;

	private UserCollection(int code, String name, int money, int powder, int numberOfBread) {
		this.code = code;
		this.name = name;
		this.money = money;
		this.powder = powder;
		this.numberOfBread = numberOfBread;
	}

	public String getName() {
		return name;
	}
	
	public int getCode() {
		return code;
	}

	public int getMoney() {
		return money;
	}

	public int getPowder() {
		return powder;
	}

	public int getNumberOfBread() {
		return numberOfBread;
	}
	
}
