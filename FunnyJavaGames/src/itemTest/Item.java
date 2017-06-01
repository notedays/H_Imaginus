package itemTest;

public enum Item {
	//Weapon_List 100~199
	SWORD(100, 10), 
	SHORT_SWORD(101, 10), 
	LONG_SWORD(102, 30),
	
	//Material_List 200~299
	BONE(200, 1),
	WATER(201, 2);
	
	int code;
	int value;
	
	public static final int WEAPON_LIST = 1;
	public static final int MATERIAL_LIST = 2;
	
	private Item(int code, int value) {
		this.code = code;
		this.value = value;
	}

	public int getItemType(){
		int type = code / 100;
		return type;
	}
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
