package musaRPG;

import java.io.File;
import java.util.Scanner;

public class MusaRpg {
	public static void main(String[] args) {
		new MusaRpg();
	}
	// # 버전 변수
	static float version = 0.1f;
	
	// # View
	View view = new View();
	
	// # 캐릭터
	Character character;
	
	// # Action 행동 제어 클래스 -- 싱글 톤 적용
	ActionModel action = ActionModel.getInstance();
	
	public MusaRpg() {
		System.out.println("===== Musa RPG ver."+version+" =====");
		
		// # 캐릭터 선택
		character = view.selectCharacter();
		action.initialize(character);
		
		String[] musics = {"muhyul_bgm.mp3","iljimae_bgm.mp3"}; 
		// # 배경 음악 재생
		new Thread(){
			public void run() {
				SoundPlayer.playBGM(new File("resources/"+musics[character.getCode()-1]));
			};
		}.start();

		// # 행동 선택
		int actionNo = -1;
		do{
			actionNo = view.selectAction(character);
			action(actionNo);
		}while(actionNo <= view.actionNames.length );
		
		// # 프로그램 종료
		System.out.println("게임을 종료합니다.");
		System.exit(1);
	}
	
	private void action(int actionNo){
		switch (actionNo) {
		case ActionModel.BATTLE : // # 전투하기
			Enemy enemy = action.generateEnemy();
			int no = view.selectBattle(character, enemy);
			action.battle(no, enemy);
			break;
		}
	}
}
