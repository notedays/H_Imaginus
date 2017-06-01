package place_Share;

public enum ItemTest {
	SWORD(1, "검"),
	AXE(2, "도끼"),
	SPEAR(3, "창");
	
	private int no;
	private String name;
	
	private ItemTest(int no, String name) {
		this.no = no;
		this.name = name;
	}
	
}
