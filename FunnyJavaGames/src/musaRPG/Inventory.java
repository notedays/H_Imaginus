package musaRPG;

import java.util.HashMap;
import java.util.Map;

public class Inventory<E extends Item> {
	
	private static final int MAX_SIZE = 10;
	private Map<Item, Integer> inven = new HashMap<Item,Integer>();
	
	public boolean addItem(E item){
		int no = inven.get(item);
		if(no == 0){
			if( inven.values().size() <= MAX_SIZE ){
				inven.put(item, 1);
				return true;
			}else{
				return false;
			}
		}else{
			inven.put(item, no+1);
			return true;
		}
	}
	
	public void dropItem(Item item){
		int no = inven.get(item);
		if(no > 1){
			inven.put(item, no-1);
		}else{
			inven.remove(item);
		}
	}
	
	public int getItemCount(Item item){
		return inven.get(item);
	}
}
