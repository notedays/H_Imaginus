package tycoon;

public enum BreadCase {

	White(1, "White 제빵틀", 4, 10),
	Red(2, "Red 제빵틀", 3, 12),
	Black(3, "Black 제빵틀", 2, 14),
	Pink(4, "Pink 제빵틀", 1, 16);
	
	private final int code;
	private final String breadCaseName;
	private final int makeSpeed;
	private final int numberOfCase;
	
	private BreadCase(int code, String name, int makeSpeed, int numberOfCase) {
		this.code = code;
		this.breadCaseName = name;
		this.makeSpeed = makeSpeed;
		this.numberOfCase = numberOfCase;
	}
	public int getCode() {
		return code;
	}
	public String getName() {
		return breadCaseName;
	}
	public int getMakeSpeed() {
		return makeSpeed;
	}
	public int getNumberOfCase() {
		return numberOfCase;
	}
}
