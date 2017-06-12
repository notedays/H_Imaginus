package musaRPG1;

import java.util.HashMap;
import java.util.Map;

public class CompanionCollection<E extends Companion> {
		
		public Map<Companion, Integer> companionMap = new HashMap<Companion, Integer>();
		
		public void add(E Companion){
			companionMap.put(Companion, 1);
			System.out.println(companionMap);
			
	}
}
