package Jeongs_HomeWork;

public class Bomb {
	int code;
	String name;
	int power;
	
	String[] names = {"물폭탄","최루탄","수류탄","다이너마이트","핵폭탄"};
	
	public Bomb(int code) {
		code = code >= names.length ? names.length-1 : code;
 		this.code = code;
		name = names[code];
		power = (code+1) * 15;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}
	
	
	
	
}
