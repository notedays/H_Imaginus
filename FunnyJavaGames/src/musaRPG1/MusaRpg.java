package musaRPG1;

import java.io.File;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ShutdownChannelGroupException;
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

		// # 시작 동료 유닛 빈 값 형성
		Companion archor = new Companion(Companion.ARCHOR, character.getLevel());
		Companion soldier = new Companion(Companion.SOLDIER, character.getLevel());
		Companion seiger = new Companion(Companion.SIEGER, character.getLevel());
		character.companionList.add(archor);
		character.companionList.add(soldier);
		character.companionList.add(seiger);
		character.companionList.get(0).addAmount(1);
		character.companionList.get(1).addAmount(1);
		character.companionList.get(2).addAmount(1);

		String[] musics = { "muhyul_bgm.mp3", "iljimae_bgm.mp3" };
		// # 배경 음악 재생
		new Thread() {
			public void run() {
				SoundPlayer.playBGM(new File("resources/" + musics[character.getCode() - 1]));
			};
		}.start();

		// # 초기 성 설정
		character.castles.add(Castles.JOENJU_SUNG);

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

		case ActionModel.BATTLE:
			Enemy enemy = action.generateEnemy();
			do {
				int battleNo = view.selectBattle(character, enemy);
				battleAction(battleNo, enemy);
			} while (enemy.getHp() != 0);

			break;
		case ActionModel.SHOW_INFO:

			break;
		case ActionModel.ITEM_MARKET:

			break;

		case ActionModel.SKILL_LEARN:
			int choiceSkill = view.selectSkill();
			learnSkill(choiceSkill);
			break;

		case ActionModel.MANAGE_RESOURCE:
			int manageNo = view.selectManage();
			manageResource(manageNo);
		}
	}

	// 컨트롤러 메소드
	private void learnSkill(int choiceSkill) {
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
	}

	private void battleAction(int battleNo, Enemy enemy) {

		switch (battleNo) {
		case ActionModel.NORMAL_ATTACK:
			action.normalAttack(enemy);
			break;
		case ActionModel.SKILL_ATTACK:
			int skillNo = view.selectSkill(character, enemy);
			action.useSkill(skillNo, enemy);
			break;

		case ActionModel.RUN_ATTACK:
			if (action.run(enemy) == true) {
				enemy.setHp(0);
			}
			break;

		case ActionModel.EVATION_ATTACK:
			if (action.evation(enemy) == true) {
				enemy.setHp(0);
			}
			break;
		}
	}

	public void manageResource(int manageNo) {
		switch (manageNo) {
		case ActionModel.GATHER:
			int companionChoice = view.gatherCompanion(character);
			int numberCompanion = view.numberCompanion(companionChoice);
			if (action.gatherCompanion(companionChoice, numberCompanion) == true) {
				System.out.println("병사 모집 성공");
			} else {
				System.out.println("병사 모집 실패");
			}
			break;

		case ActionModel.MAKE_FOOD:
			int numFood = view.numberFood(character);
			break;

		case ActionModel.DEPLOYMENT:
			try {
				if (character.castles.get(0) == null) {
				}
				int chooseCastle = view.chooseCastle(character);
				int deployChoice = view.deployCompanion(character);

				Castles myCastle = character.castles.get(chooseCastle - 1);
				int numberDeploy = view.numberDeploy(character, myCastle);

				action.makeDeploy(myCastle, deployChoice, numberDeploy);

			} catch (Exception e) {
				System.out.println("배치 할 성이 없습니다");
			}
			break;

		case ActionModel.CASTLE_ATTACK: {
			int choice = view.selectCastle();
			Castles[] castleChoice = Castles.values();
			Castles castle = castleChoice[choice - 1];

			if (character.castles.contains(castle)) {
				System.out.println("이미 보유한 성입니다");
			} else {
				//	군량미가 0보다 큰 경우 공성 가능 
				if (character.getFood() > 0) {
					// 적 성의피가 0이 되거나 내 군량미가 0 보다 작아지는 경우 와일문 종료
					while (castle.getCastleHp() > 0 && character.getFood() > 0) {
						int attackChoice = view.selectCastleBattle();
						action.castleAttack(castle, attackChoice);
					}
				}else{
					System.out.println("군량미 부족으로 전투 불가");
				}
			}
			break;
		}

		case ActionModel.SHOW_MY_COMPANY: {
			view.showMyCompanion(character);
			break;
		}

		case ActionModel.SHOW_MY_CASTLE: {
			view.showMyCastle(character);
		}

		}
	}

}
