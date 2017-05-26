package tycoon;

public enum UserCollection {

	Silver(1, "Silver Class", 1000, 50, 10, 8),
	Gold(2, "Gold Class", 5000, 100, 20, 16),
	Platinum(3, "Platinum Class", 10000, 150, 30, 24),
	Vip(4, "Vip Class", 15000, 200, 40, 32);
	
	private final int code;
	private final String name;
	private final int money;
	private final int powder;
	private final int numberOfBread;
	private final int breadCase;
	

	private UserCollection(int code, String name, int money, int powder, int numberOfBread, int breadCase) {
		this.code = code;
		this.name = name;
		this.money = money;
		this.powder = powder;
		this.numberOfBread = numberOfBread;
		this.breadCase = breadCase;
	}

	public String getName() {
		return name;
	}
	
	public int getBreadCase() {
		return breadCase;
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
