package place_Share;

import java.util.HashMap;
import java.util.Map;

public class InventoryTest<T extends ItemTest> {
	Map<T,Integer> weaponMap = new HashMap<>();
	private final int MAX_SPACE = 10;
	
	public boolean add(T item){
		if( weaponMap.size() == MAX_SPACE ) return false;
		System.out.println("size : "+weaponMap.size());
		int itemCount = weaponMap.get(item) != null ? weaponMap.get(item) : 0;
		if( itemCount > 0 ){
			weaponMap.put(item, itemCount +1);
		}else{
			weaponMap.put(item, 1);
		}
		return true;
	}
}
