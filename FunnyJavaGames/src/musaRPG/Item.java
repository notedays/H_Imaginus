package musaRPG;

public enum Item {
	
	SHURIKEN(1,"수리검","닌자들이 기본으로 가지고 다니는 수리검", 5),
	KUNAI(2,"쿠나이","던지는 용으로도 근접전에서도 쓸 수 있는 쿠나이", 10);
	
	private final int code;
	private final String name;
	private final String explanation;
	private final int attack;
	
	private Item(int code, String name, String explanation, int attack) {
		this.code = code;
		this.name = name;
		this.explanation = explanation;
		this.attack = attack;
	}
	
	public Item fromName(String name){
		return Item.valueOf(name);
	}
	
	public int getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public String getExplanation() {
		return explanation;
	}

	public int getAttack() {
		return attack;
	}
	
}
