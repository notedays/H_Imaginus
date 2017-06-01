package itemTest;

import java.util.*;

public class Inventory<E extends Item> {
	Map<Item, Integer> inven = new HashMap<Item, Integer>();
	
	void add(E Item) {
		int itemNumber;
		itemNumber = inven.get(Item) == null ? 0 : inven.get(Item);  
		if (itemNumber == 0) {
			inven.put(Item, 1);
		} else {
			inven.put(Item, itemNumber+1);
		}
	}

	int get(E Item) {
		return inven.get(Item);
	}
}
