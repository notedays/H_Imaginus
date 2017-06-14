package musaRPG1;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

// # 무사 게임의 행동 관련 된 작업을 할 클래스
public class ActionModel {

	// # 행동 코드
	public static final int BATTLE = 1;
	public static final int SHOW_INFO = 2;
	public static final int ITEM_MARKET = 3;
	public static final int SKILL_LEARN = 4;
	public static final int MANAGE_RESOURCE = 5;

	// # 전투 코드
	public static final int NORMAL_ATTACK = 1;
	public static final int SKILL_ATTACK = 2;
	public static final int RUN_ATTACK = 3;
	public static final int EVATION_ATTACK = 4;

	// # 자원관리(성 관리)
	public static final int GATHER = 1;	// 병사 모집
	public static final int ENFORCEMENT = 2; // 성벽 유지보수 및 강화
	public static final int DEPLOYMENT = 3; // 성내 병력 배치
	public static final int CASTLE_ATTACK = 4; // 성 공격
	

	// # 스킬 코드(SKILL_LEARN)
	public static final int LEARN_SKILL = 1;
	public static final int DELETE_SKILL = 2;

	View view = new View();

	// # 싱글 톤
	private static ActionModel action = new ActionModel();

	private ActionModel() {
	}

	public static ActionModel getInstance() {
		return action;
	};

	// # 캐릭터 설정하기
	Character character;

	public void initialize(Character character) {
		this.character = character;
		character.skillList.add(Skill.KNIFE_THROW); // 기초 스킬 설정
	}

	public void generateCastleCompanion(Castles castle){
		for(int i = 1; i <= Companion.names.length ; i++){
			castle.cattleCompanionList.add(new Companion(i, castle.getLevel()));
		}
	}
	
	public void castleAttack(Castles castle, int battleChoice){
		//궁수 공격
		System.out.println(castle.cattleCompanionList.get(0).getHp());
		castle.cattleCompanionList.get(0).setHp(character.companion.get(0).getAttack());
		System.out.println(castle.cattleCompanionList.get(0).getHp());
		//보병 공격
		//공성추 공격
	}
	
	public Enemy generateEnemy() {
		return new Enemy(character.getLevel());
	}
	
	public void learnSkill(int no) {
		switch (no) {
		case LEARN_SKILL: {
			Skill[] skillList = Skill.values();
			System.out.println("배울 수 있는 스킬 목록.");
			for (int i = 1; i <= skillList.length; i++) {
				System.out.print(i + ". " + skillList[i - 1].getName() + "  ");
				System.out.print(" 요구 레벨: " + skillList[i - 1].getLevelLimit());
				System.out.print(" 피해량: " + skillList[i - 1].getDamage());
				System.out.print(" 마나소모: " + skillList[i - 1].getConsumeChakura());
				System.out.print(" " + skillList[i - 1].getExplanation());
				System.out.println();
			}
			System.out.print("어떤 스킬을 배우겠습니까?");
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();
			character.learnSkill(skillList[choice - 1]);
			break;
		}

		case DELETE_SKILL: {

			break;
		}
		}
	}// learnSkill문 종료

	public void normalAttack(Enemy enemy) {
		int enemyHp = enemy.getDamaged(character.getAttack());
		int characterHp = character.getDamaged(enemy.getAttack());
		System.out.println("전투 시작");
		System.out.println(enemy.getName() + "의 HP는 " + enemyHp + "입니다");
		System.out.println(character.getName() + "의 HP는 " + characterHp + "입니다");
		if (characterHp == 0)
			character.die();
		if (enemyHp == 0) {
			Item item = enemy.dropItem();
			character.battleWin(enemy.getExp(), item);
			character.setUserMoney(character.getUserMoney() + enemy.getMoney());
			System.out.println(enemy.getMoney() + "원 획득");
		}
	}// normalAttack종료

	public void useSkill(int no, Enemy enemy) {
		Skill targetSkill = character.getSkillList().get(no - 1);
		if (character.getMp() >= targetSkill.getConsumeChakura()) {
			System.out.println(character.getSkillList().get(no - 1) + "!!!");
			int enemyHp = enemy.getDamaged(character.getSkillList().get(no - 1).getDamage());
			System.out.println(enemy.getName() + "의 HP는 " + enemyHp + "입니다");

			int characterHp = character.getDamaged(enemy.getAttack());
			int characterMp = character.getUsedMp(character.getSkillList().get(no - 1).getConsumeChakura());

			System.out.println(character.getName() + "의 HP는 " + characterHp + "입니다");
			System.out.println(character.getName() + "의 MP는 " + characterMp + "입니다");

			if (characterHp == 0)
				character.die();
			if (enemyHp == 0) {
				Item item = enemy.dropItem();
				character.battleWin(enemy.getExp(), item);
				character.setUserMoney(character.getUserMoney() + enemy.getMoney());
				System.out.println(enemy.getMoney() + "원 획득");
			}
		} else {
			System.out.println("MP가 부족합니다");
		}

	}// useSkill문 종료

	public boolean evation(Enemy enemy){
		if (Math.random() < 0.3f) {
			System.out.println("회피 성공!!");
			return true;
		} else {
			character.setHp(character.getHp() - enemy.getAttack());
			System.out.println("회피 실패!!");
			System.out.println(character.getName() + "의 HP는 " + character.getHp() + "입니다");
			if (character.getHp() == 0) {
				character.die();
			}
		}return false;
	}

	public boolean run(Enemy enemy) {
		if ((int) (character.getHp() / 100) >= 0.3) {
			System.out.println("전투에서 도피 합니다");
			return true;
		} else {
			System.out.println("체력이 부족합니다");
			return false;
		}
	}

	public Companion gather(int code, Character character) {
		return new Companion(code, character.getLevel());
	}

	public void gatherPut(Companion companion) {
		character.companion.add(companion);
	}

	
	
}// actionModel문 종료
