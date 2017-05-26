package narutoRPG;

public class Inventory<E extends Item> {
	
	private Item[] inven = new Item[10];
	
	public int addItem(E item){
		int idx = findEmptyInven();
		if( isUsableIdx(idx) ){
			inven[idx] = item;
		}
		return idx;
	}
	
	public void dropItem(int idx){
		if( isUsableIdx(idx) ) inven[idx] = null;
	}
	
	private int findEmptyInven(){
		int idx = -1;
		for (int i = 0; i < inven.length; i++) {
			if( inven[i] == null ) idx = i;
		}
		return idx;
	}
	
	private boolean isUsableIdx(int idx){
		return idx >= 0 && idx < inven.length;
	}
}
