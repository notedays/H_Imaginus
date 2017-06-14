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
	public static final int GATHER = 1; // 병사 모집
	public static final int ENFORCEMENT = 2; // 성벽 유지보수 및 강화
	public static final int DEPLOYMENT = 3; // 성내 병력 배치
	public static final int CASTLE_ATTACK = 4; // 성 공격
	public static final int SHOW_COMPANY = 5; // 병사 현황

	// # 성 공격
	public static final int ARCHOR_ATTACK = 1;
	public static final int SOLDIER_ATTACK = 2;
	public static final int SIEGER_ATTACK = 3;

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

	public void generateCastleCompanion(Castles castle) {
		for (int i = 1; i <= Companion.names.length; i++) {
			castle.cattleCompanionList.add(new Companion(i, castle.getLevel(), 10));
		}
	}

	public void archorCastleAttack(Castles castle) {
		castle.damageCastle(character.totalArchorDamage);
	}

	public void soldierCastleAttack(Castles castle) {
		castle.damageCastle(character.totalSoldierDamage); // 적성 체력 감소
		
		List<Companion> soldierList = character.companionSoldier;
		
		int i = 0;
		int soldierHp = soldierList.get(i).damageHp(castle.getAttack());
		if(soldierHp <= 0){
			i += 1;
		}
	}

	public void siegerCastleAttack(Castles castle) {
		castle.damageCastle(character.totalSiegerDamage);
	}

	public Enemy generateEnemy() {
		return new Enemy(character.getLevel());
	}

	public Skill learnSkills(int no) {
		Skill[] skillList = Skill.values();
		character.learnSkill(skillList[no - 1]);
		return skillList[no - 1];
	}

	public void deleteSkill(int no) {
		if (no == 0) {
			return;
		} else {
			System.out.println(character.skillList.get(no - 1).getName() + "기술이 삭제 되었습니다");
			character.skillList.remove(no - 1);
		}
	}

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

	public boolean evation(Enemy enemy) {
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
		}
		return false;
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

	public Companion gather(int code, int number) {
		if (number * Companion.demandMoneys[code - 1] <= character.getMoney()) {
			return new Companion(code, character.getLevel(), number);
		} else {
			System.out.println("소지금이 부족합니다.");
			return null;
		}
	}

	public void gatherPutMyCompanion(Companion companion) {
		if (companion.getCode() == Companion.궁사 && companion != null) {
			character.companionArchor.add(companion);
			character.useMoney(companion.getDemandMoney() * companion.getNumberOfUnit());
			character.totalArchorDamage += companion.getAttack() * companion.getNumberOfUnit();

			System.out.println(companion.getName() + " " + companion.getNumberOfUnit() + "명이 추가되었습니다");

		} else if (companion.getCode() == Companion.보병 && companion != null) {
			character.companionSoldier.add(companion);
			character.useMoney(companion.getDemandMoney() * companion.getNumberOfUnit());
			System.out.println(companion.getName() + " " + companion.getNumberOfUnit() + "명이 추가되었습니다");

		} else if (companion.getCode() == Companion.공성차 && companion != null) {
			character.companionSieger.add(companion);
			character.useMoney(companion.getDemandMoney() * companion.getNumberOfUnit());
			System.out.println(companion.getName() + " " + companion.getNumberOfUnit() + "명이 추가되었습니다");

		} else if (companion == null) {
			return;
		}
	}

}// actionModel문 종료
