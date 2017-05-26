package tycoon;
public class User {

	String userName;		//유저 이름 
	String name;		//계급 이름  
	int powder;
	int money;
	int numberOfBread;

	//	제빵틀 변수 
	int breadCase = 8;		//한번에 빵 만들수 있는 갯수
	int makeSpeed = 5;		// 빵하나 만드는데 걸리는 시간
	String CaseName;
	
	
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCaseName() {
		return CaseName;
	}

	public void setCaseName(String caseName) {
		CaseName = caseName;
	}

	public int getMakeSpeed() {
		return makeSpeed;
	}

	public void setMakeSpeed(int makeSpeed) {
		this.makeSpeed = makeSpeed;
	}

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
