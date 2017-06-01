package place_Jeong;

public enum Item {

	WOOD_SWORD(100,"목검","초보 무사들의 기본 목검"),
	
	DOG_BONE(200, "개 뼈다귀", "개의 뼈다귀. 잘하면 무기로 만들 수 있겠는데?"),
	DRAGON_BONE(201, "용의 뼈","그 자체로 다이아몬드 보다 강도가 높은 용의 뼈. 오직 전설의 대장장이만이 무기로 제작이 가능하다.");
	
	
	public static final int ITEM_TYPE_WEAPON = 1;
	public static final int ITEM_TYPE_MATERIAL = 2;
	
	private int code;
	private String name;
	private String detail;
	
	private Item(int code, String name, String detail) {
		this.code = code;
		this.name = name;
		this.detail = detail;
	}
	
	public int getItemType(){
		return code / 100;
	}
}
