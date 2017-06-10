package musaRPG1;

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

		System.out.println("===== Musa RPG ver." + version + " =====");

		// # 캐릭터 선택
		character = view.selectCharacter();
		action.initialize(character);
		
		// # 시작 마을 
		System.out.println(action.castle.getExplanation()+"에서 여정을 시작합니다.");

		String[] musics = { "muhyul_bgm.mp3", "iljimae_bgm.mp3" };
		// # 배경 음악 재생
		new Thread() {
			public void run() {
				SoundPlayer.playBGM(new File("resources/" + musics[character.getCode() - 1]));
			};
		}.start();

		// # 행동 선택
		int actionNo = -1;
		do {
			actionNo = view.selectAction(character);
			action(actionNo);
		} while (actionNo <= view.actionNames.length);

		// # 프로그램 종료
		System.out.println("게임을 종료합니다.");
		System.exit(1);
	}

	private void action(int actionNo) {
		switch (actionNo) {
		case ActionModel.BATTLE: // # 전투하기
			Enemy enemy = action.generateEnemy();
			while (enemy.getHp() != 0) {
				int battleNo = view.selectBattle(character, enemy);
				switch (battleNo) {
				case ActionModel.NORMAL_ATTACK:
		//			action.battle(1, enemy, 0);
					break;
				case 2:
					int skillNo = view.selectSkill(character, enemy);
			//		action.battle(2, enemy, skillNo);
					break;
					
				case 3:
					break;
					
				case 4:
					break;
				}
			}
			break;

		case ActionModel.SHOW_INFO:

			break;
		case ActionModel.ITEM_MARKET:

			break;
		case ActionModel.SKILL_LEARN:

			int no = view.skillList();
			action.learnSkill(no);
			break;
			
		case ActionModel.MANAGE_RESOURCE:
			int manageNo = view.manageList();
			switch (manageNo) {
			case ActionModel.GATHER:
//				action.manage(manageNo);
				
				break;
				
			case ActionModel.ENFORCEMENT:
				
				break;
				
			case ActionModel.DEPLOYMENT:
				
				break;
			}
		}
	}
}
