package musaRPG1;

public enum Item {
	
	// # 무기(100~199)
	WOOD_SWORD(100,"목검","연습용으로 많이 쓰이는 목검", 7),
	WOOD_LONG_SWORD(101, "긴 목검", "살상이 가능한 목검", 9),
	STILL_SWORD(102, "철검", "살상이 가능한 목검", 11),
	STILL_LONG_SWORD(103, "긴 철검", "살상이 가능한 목검", 13),
	
	// # 방어구(200~299)
	WOOD_AMOR(200,"나무 갑옷","초급자의 나무 갑옷", 5),
	WOOD_THICK_AMOR(201, "두꺼운 나무 갑옷", "두꺼운 나무 갑옷", 7),	
	STILL_AMOR(202, "철 갑옷", "철 갑옷", 9),	
	STILL_THICK_AMOR(203, "두꺼운 철 갑옷", "두꺼운 철 갑옷", 11),	
	
	// # 몬스터 보상(300~399)
	DOG_BORN(300,"개 뼈다귀","미친 개의 뼈다귀로 잘 다듬으면 기본적인 무기 재료이다.", 1),
	BEAR_SKIN(301, "곰 가죽", "야생 곰의 가죽으로 기본적인 갑옷 재료이다.", 2),
	TIGER_BORN(302, "호랑이 뼈다귀", "야생 호랑이의 뼈다귀로 잘 다듬으면 무기 재료이다.", 3),
	GHOST_BLOOD(303, "처녀귀신의 피", "처녀귀신의 피로 무기 재료이다", 4);

	public static final int ITEM_TYPE_WEAPON = 1;
	public static final int ITEM_TYPE_ARMOR= 2;	
	public static final int ITEM_TYPE_MATERIAL = 3;	
	
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
	
	public int getItemType(){
		return code/100;
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
