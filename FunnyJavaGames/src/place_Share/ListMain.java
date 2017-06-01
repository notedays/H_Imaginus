package place_Share;

public class ListMain {
	public static void main(String[] args) {
		new ListMain();
	}
	
	InventoryTest<ItemTest> inven = new InventoryTest<>();
	public ListMain() {
		inven.add(ItemTest.AXE);
		inven.add(ItemTest.SPEAR);
		inven.add(ItemTest.SWORD);
	}
	
	public void test(){
		
	}
}
