package musaRPG;

public enum Item {
	
	// # 무기
	KITCHEN_KNIFE(1,"식칼","일반 가정집에서 흔히 볼 수 있는 식칼", 5),
	WOOD_SWORD(2,"목검","연습용으로 많이 쓰이는 목검", 10),
	
	// # 몬스터 보상
	DOG_BORN(1000,"개 뼈다귀","미친 개의 뼈다귀로 잘 다듬으면 기본적인 무기로 생성 가능해 보인다.", 6);
	
	private final int code;
	private final String name;
	private final String explanation;
	private final int value;
	
	private Item(int code, String name, String explanation, int value) {
		this.code = code;
		this.name = name;
		this.explanation = explanation;
		this.value = value;
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

	public int getValue() {
		return value;
	}
	
}
