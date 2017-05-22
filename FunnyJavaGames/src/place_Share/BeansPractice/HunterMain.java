package place_Share.BeansPractice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;
// # Ctrl + Shift + O 하면 Import 다 해줌

import javax.swing.plaf.synth.SynthSpinnerUI;

public class HunterMain {
	public static void main(String[] args) {
		new HunterMain();
	}
	
	/* # 배열도 있는데 리스트( 또는 Vector )를 쓰는 이유
	 * - 배열은 길이가 제한적이지만, 이놈들은 가변적이다.
	 * - 배열은 미리 공간을 만들어 놓고 넣고 뺴는 구조 - 순서 변동 X
	 * - 리스트는 공간을 재조정하며 넣고 뺴는 구조 - 순서 자동 변동 (순차적으로)
	 */
	List<Woman> womanList = new ArrayList<Woman>();
	Vector<HunterImpl> resultList = new Vector<HunterImpl>();
	
	Scanner scan = new Scanner(System.in);
	
	public HunterMain() {
		System.out.println("1. 주팔      2. 환규");
		System.out.print("헌터를 고르세요 : ");
		int hunterNo = scan.nextInt();
		HunterImpl hunter = (hunterNo == 1) ? new LimJuPal() : new LeeHwanGyu();
		
		Woman target = prepareWoman();
		while(true){
			if( hunter.hunt(target) ){
				System.out.println(hunter.getName()+"님이 "+hunter.getHuntCount()+"번의 시도 끝에"+target.getName()+"의 헌팅에 성공했습니다.");
				resultList.add(hunter);
				break;
			}else{
				System.out.println("헌팅 실패!!! ㅜ.ㅜ");
			};
		}
		for (HunterImpl hunterResult : resultList) {
			System.out.println("Hunter's Info~~!");
			System.out.println("name : "+hunterResult.getName());
			System.out.println("speechLevel : "+hunterResult.getSpeechLevel());
		}
	}	
	
	Woman prepareWoman(){
		womanList.add(new Suzy());
		womanList.add(new IU());
		
		return womanList.get((int)Math.random());
	}
}
