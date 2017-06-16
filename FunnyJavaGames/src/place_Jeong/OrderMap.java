package place_Jeong;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class OrderMap {
	public static void main(String[] args) {
		new OrderMap();
	}
	
	Map<String,Integer> map = new HashMap<>();
	Scanner scan = new Scanner(System.in);
	
	public OrderMap() {
		prepareMap();
		
		int itemCount = showMapList();
		System.out.println("아이템의 수량은 "+itemCount+"개 입니다.");
	}
	
	private void prepareMap(){
		map.put("돌멩이", 11);
		map.put("나무 조각", 12);
		map.put("토끼 가죽", 5);
	}
	
	private int showMapList(){
		// # 맵의 키값이 담긴 Set을 불러온 후 스트링 배열에 담아준다.
		String[] keys = new String[map.values().size()];
		String[] entrys = map.entrySet().toArray(keys);
		
		for (int i = 1; i <= entrys.length; i++) {
			System.out.println(i+". "+entrys[i-1]);
		}
		System.out.print("사용할 재료를 고르세요 : ");
		return map.get(entrys[scan.nextInt()-1]);
	}
	
}
