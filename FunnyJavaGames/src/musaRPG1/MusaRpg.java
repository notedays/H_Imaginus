package musaRPG1;

import java.io.File;
import java.util.List;
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

		// # 시작성 부여(임시)
		character.castles.add(Castles.MASAN_SUNG);
		
		character.companionArchor.add(new Companion(1, 1, 20));
		character.companionSoldier.add(new Companion(2, 1, 30));

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
					action.normalAttack(enemy);
					break;
				case ActionModel.SKILL_ATTACK:
					int skillNo = view.selectSkill(character, enemy);
					action.useSkill(skillNo, enemy);
					break;

				case ActionModel.RUN_ATTACK:
					if (action.run(enemy) == true)
						return;
					break;

				case ActionModel.EVATION_ATTACK:
					if (action.evation(enemy) == true)
						return;
					break;
				}
			} // attack문 종료
			break;

		case ActionModel.SHOW_INFO:

			break;
		case ActionModel.ITEM_MARKET:

			break;

		case ActionModel.SKILL_LEARN:
			int choiceSkill = view.selectSkill();
			switch (choiceSkill) {
			case ActionModel.LEARN_SKILL:
				int learnSkill = view.learnSkill();
				action.learnSkills(learnSkill);
				break;

			case ActionModel.DELETE_SKILL:
				int deleteSkill = view.deleteSkill(character);
				action.deleteSkill(deleteSkill);
				break;
			}
			break;

		case ActionModel.MANAGE_RESOURCE:
			int manageNo = view.selectManage();

			switch (manageNo) {
			case ActionModel.GATHER:
				int selectNumber = view.selectCompanion(); // 병사 추가 메뉴
				int gatherNumber = view.numberCompanion(character, selectNumber);
				action.gatherPutMyCompanion(action.gather(selectNumber, gatherNumber));
				break;

			case ActionModel.ENFORCEMENT:

				break;

			case ActionModel.DEPLOYMENT:

				break;

			case ActionModel.CASTLE_ATTACK: {
				int choice = view.selectCastle();
				Castles[] castleChoice = Castles.values();
				Castles castle = castleChoice[choice - 1];
				action.generateCastleCompanion(castle);

				while(castle.getCastleHp() != 0){
				int battleChoice = view.selectCastleBattle();
					switch (battleChoice) {
					case ActionModel.ARCHOR_ATTACK:
						action.archorCastleAttack(castle);
						System.out.println(castle.getName()+"의 남은 Hp "+castle.getCastleHp());
						break;
						
					case ActionModel.SOLDIER_ATTACK:
						action.soldierCastleAttack(castle);
						System.out.println(castle.getName()+"의 남은 Hp "+castle.getCastleHp());
						break;
						
					case ActionModel.SIEGER_ATTACK:
						action.siegerCastleAttack(castle);
						break;
					}
				}break;
			}

			case ActionModel.SHOW_COMPANY: {
				view.showCompany(character);
			}
			}
		}
	}
}
