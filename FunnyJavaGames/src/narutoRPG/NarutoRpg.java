package narutoRPG;

import java.io.File;
import java.util.Scanner;

public class NarutoRpg {
	public static void main(String[] args) {
		new NarutoRpg();
	}
	// # 버전 변수
	static float version = 0.1f;
	
	Scanner sc = new Scanner(System.in);
	
	// # 캐릭터
	Character character;
	
	// # Action 행동 제어 클래스 -- 싱글 톤 적용
	Action action = Action.getInstance();
	
	public NarutoRpg() {
		System.out.println("===== Naruto RPG ver."+version+" =====");
		
		// # 배경 음악 재생
		new Thread(){
			public void run() {
				SoundPlayer.playBGM(new File("resources/naruto_energy.mp3"));
			};
		}.start();
	
		// # 캐릭터 선택
		selectCharacter();
		
		// # 게임 스타트
		gameStart();
	}
	
	private void selectCharacter(){
		Character[] characterArray = Character.values();
		for (int i = 1; i <= characterArray.length; i++) {
			System.out.println(i+". "+characterArray[i-1].getName());
		}
		System.out.print("플레이할 캐릭터를 고르세요 : ");
		int charIdx = -1;
		do {
			charIdx = sc.nextInt()-1;
		} while (charIdx < 0 || charIdx >= characterArray.length );
		character = characterArray[charIdx];
		System.out.println(character.getName() +" 를 선택하셨습니다.\n");
	}
	
	private void gameStart(){
		
		String[] actionNames = {"전투 하기","정보 보기","아이템 상점","스킬 배우기"};
		int actionNo = -1;
		do{
			System.out.println("플레이어 [ "+character.getName()+" ] ");
			for (int i = 1; i <= actionNames.length; i++) {
				System.out.println(i+". "+actionNames[i-1]);
			}
			System.out.println( (actionNames.length+1) + ". 게임 종료");
			System.out.print("무엇을 하시겠습니까? : ");
			actionNo = sc.nextInt();
			
			// # 액션 실행
			action(actionNo);
		}while(actionNo < actionNames.length+1);
	}
	
	private void action(int actionNo){
		switch (actionNo) {
		case Action.BATTLE : // # 전투하기
			action.battle();
			break;
		}
	}
}
