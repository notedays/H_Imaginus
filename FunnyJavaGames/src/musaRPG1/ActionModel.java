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
	public static final int MANAGE_CASTLE = 6; // 성 관리
	public static final int TEST = 7; //

	// # 전투 코드
	public static final int NORMAL_ATTACK = 1;
	public static final int SKILL_ATTACK = 2;
	public static final int RUN_ATTACK = 3;
	public static final int EVATION_ATTACK = 4;
	public static final int USE_PORTION = 5;

	// # 공성전 메뉴
	public static final int GATHER = 1; // 병사 모집
	public static final int MAKE_FOOD = 2; // 군량미 확보
	public static final int DEPLOYMENT = 3; // 성내 병력 배치
	public static final int CASTLE_ATTACK = 4; // 성 공격
	public static final int SHOW_MY_COMPANY = 5; // 병사 현황
	public static final int SHOW_MY_CASTLE = 6; // 보유 성 현황

	// # 성 관리 메뉴
	public static final int INSTALL_MACHINE = 1; // 자원 생성기 메뉴
	public static final int COLLECT_RESOURCE = 2;

	// # INSTALL_MACHINE 관리 메뉴
	public static final int INSTALL_GOLD = 1;
	public static final int INSTALL_FARM = 2;

	// # 성 공격
	public static final int ARCHOR_ATTACK = 1;
	public static final int SOLDIER_ATTACK = 2;
	public static final int SIEGER_ATTACK = 3;

	// # 스킬 코드(SKILL_LEARN)
	public static final int LEARN_SKILL = 1;
	public static final int DELETE_SKILL = 2;

	// # 포션 사용 코드
	public static final int USE_HP_PORTION = 1;
	public static final int USE_MP_PORTION = 2;

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

		if (characterHp == 0) {
			character.die();
		}

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

	public boolean gatherCompanion(int sortCompany, int numberCompany) {
		// 궁사 충원
		if (sortCompany == Companion.ARCHOR) {
			// 내가 가진 돈이 궁사 총생산 비용보다 크다면
			int archorDemandMoney = numberCompany * Companion.demandMoneys[Companion.ARCHOR - 1];
			if (character.getMoney() >= archorDemandMoney && character.getMoney() >= 0) {

				character.companionList.get(sortCompany - 1).addAmount(numberCompany);
				character.setMoney(character.getMoney() - archorDemandMoney);
				return true;
			} else {
				System.out.println("금전이 부족합니다");
				return false;
			}

			// 보병 충원
		} else if (sortCompany == Companion.SOLDIER) {
			int soldierDemandMoney = numberCompany * Companion.demandMoneys[Companion.SOLDIER - 1];
			if (character.getMoney() >= soldierDemandMoney && character.getMoney() >= 0) {

				character.companionList.get(sortCompany - 1).addAmount(numberCompany);
				character.setMoney(character.getMoney() - soldierDemandMoney);
				return true;
			} else {
				System.out.println("비용이 부족합니다");
				return false;
			}

			// 공성추 충원
		} else if (sortCompany == Companion.SIEGER) {
			int seigerDemandMoney = numberCompany * Companion.demandMoneys[Companion.SIEGER - 1];
			if (character.getMoney() >= seigerDemandMoney && character.getMoney() >= 0) {
				Companion seiger = new Companion(sortCompany, character.getLevel());
				seiger.addAmount(numberCompany);

				character.companionList.get(sortCompany - 1).addAmount(numberCompany);
				character.setMoney(character.getMoney() - seigerDemandMoney);
				return true;
			} else {
				System.out.println("비용이 부족합니다");
				return false;
			}
		}
		return false;
	}

	public void castleAttack(Castles castle, int attackChoice) {
		Companion archorList = character.companionList.get(Companion.ARCHOR - 1);
		Companion soldierList = character.companionList.get(Companion.SOLDIER - 1);
		Companion siegerList = character.companionList.get(Companion.SIEGER - 1);

		if (archorList.getAmount() == 0 && soldierList.getAmount() == 0 && siegerList.getAmount() == 0) {
			System.out.println("병력을 생산하십시오");

		} else if (archorList.getAmount() != 0 && attackChoice == Companion.ARCHOR) { // 원거리
			int archorTotalAttack = character.companionList.get(Companion.ARCHOR - 1).getAttack();

			// 궁사 공격력 만큼 군량미 소모, 군량미 다쓸 시 전투중단
			if (character.usdFood(archorList.getAttack() + 30) == false) {
				return;
			}

			// 성 공격중 성 hp가 0이 될 경우 해당성 획득
			if (castle.getDamaged(archorTotalAttack) == true)
				character.obtainCastle(castle);

		} else if (soldierList.getAmount() != 0 && attackChoice == Companion.SOLDIER) { // 근거리
			int soldierTotalAttack = character.companionList.get(Companion.SOLDIER - 1).getAttack();

			// 궁사 공격력 만큼 군량미 소모, 군량미 다쓸 시 전투중단
			if (character.usdFood(soldierList.getAttack() + 30) == false) {
				return;
			}
			// 성 공격중 성 hp가 0이 될 경우 해당성 획득
			if (castle.getDamaged(soldierTotalAttack) == true)
				character.obtainCastle(castle);

			// 적 공격시 공격하는 성 공격력 만큼 보병 피해입음
			soldierList.getDamage(castle.getAttack());

		} else if (siegerList.getAmount() != 0 && attackChoice == Companion.SIEGER) { // 원거리
			int seigerTotalAttack = character.companionList.get(Companion.SIEGER - 1).getAttack();

			// 궁사 공격력 만큼 군량미 소모, 군량미 다쓸 시 전투중단
			if (character.usdFood(siegerList.getAttack() + 30) == false) {
				return;
			}
			// 성 공격중 성 hp가 0이 될 경우 해당성 획득
			if (castle.getDamaged(seigerTotalAttack + character.getLevel() * 2) == true)
				character.obtainCastle(castle);
		} else {
			System.out.println("병력을 생산하십시오");
		}
	}

	// 성내 병력 배치
	public void makeDeploy(Castles castle, int deployChoice, int number) {
		switch (deployChoice) {
		case Companion.ARCHOR:
			if (character.companionList.get(Companion.ARCHOR - 1).getAmount() >= number) {
				if (number <= castle.getMaxCount() - castle.getNowCount()) {
					// 성 공격력 수정
					castle.setAttack(
							castle.getAttack() + (character.companionList.get(Companion.ARCHOR).getAttack() * number));
					// 성 수용인원수 수정
					castle.addCount(number);
					System.out.println(
							"성 공격력 " + character.companionList.get(Companion.ARCHOR).getAttack() * number + "만큼 상승");
					// 내가 가진 병사 수 감소 시키기
					character.companionList.get(Companion.ARCHOR - 1).minusAmount(number);

				} else {
					System.out.println("성 인원 가득 참");
					return;
				}
			} else {
				System.out.println("내가 가진 병사의 숫자가 부족합니다");
			}
			break;

		case Companion.SOLDIER:
			if (character.companionList.get(Companion.SOLDIER - 1).getAmount() >= number) {
				if (number <= castle.getMaxCount() - castle.getNowCount()) {
					// 성 공격력 수정
					castle.setAttack(
							castle.getAttack() + (character.companionList.get(Companion.SOLDIER).getAttack() * number));
					// 성 수용 인원수 수정
					castle.addCount(number);
					System.out.println(
							"성 공격력 " + character.companionList.get(Companion.SOLDIER).getAttack() * number + "만큼 상승");
					// 내가 가진 병사 수 감소 시키기
					character.companionList.get(Companion.SOLDIER - 1).minusAmount(number);
				} else {
					System.out.println("성 인원 가득 참");
					return;
				}
			} else {
				System.out.println("내가 가진 병사의 숫자가 부족합니다");
			}
			break;

		case Companion.SIEGER:
			if (character.companionList.get(Companion.SIEGER - 1).getAmount() >= number) {
				if (number <= castle.getMaxCount() - castle.getNowCount()) {
					// 성 공격력 수정
					castle.setAttack(
							castle.getAttack() + (character.companionList.get(Companion.SIEGER).getAttack() * number));
					// 성 수용인원수 수정
					castle.addCount(number);
					System.out.println(
							"성 공격력 " + character.companionList.get(Companion.SIEGER).getAttack() * number + "만큼 상승");
					// 내가 가진 병사 수 감소 시키기
					character.companionList.get(Companion.SIEGER - 1).minusAmount(number);
				} else {
					System.out.println("성 인원 가득 참");
					return;
				}
			} else {
				System.out.println("내가 가진 병사의 숫자가 부족합니다");
			}
			break;
		}
	}// 성내 병력배치 끝

	public void makeFood(int no) {
		// 군량미 개당 50원
		if (character.useMoney(no * 50) == true) {
			int myFood = (character.getFood() + no);
			character.setFood(myFood);
		} else {
			return;
		}
	}

	public void generateGold(int no, int castleChoice) {
		int money = GoldGenerator.prices[no - 1];
		if(character.getMoney() >= money){
			List<GoldGenerator> goldGeneratorList = character.castles.get(castleChoice - 1).goldGeneratorList;
			GoldGenerator t = new GoldGenerator(no);
			goldGeneratorList.add(t);
			t.setDaemon(true);
			t.start();
			character.useMoney(money);
		}else{
			System.out.println("돈이 부족합니다");
		}
	}

	public void collectGold(int castleChoice) {
		List<GoldGenerator> goldGeneratorList = character.castles.get(castleChoice - 1).goldGeneratorList;
		for (int i = 0; i < goldGeneratorList.size(); i++) {
			goldGeneratorList.get(i).gatherMoney(character);
			System.out.println(character.getMoney() + "원 보유 중");
		}

		List<FoodGenerator> foodGeneratorList = character.castles.get(castleChoice - 1).foodGeneratorList;
		for (int i = 0; i < foodGeneratorList.size(); i++) {
			foodGeneratorList.get(i).gatherFood(character);
			System.out.println(character.getFood() + "석 보유 중");
		}
	}

	public void generateFood(int no, int castleChoice) {
		List<FoodGenerator> foodGeneratorList = character.castles.get(castleChoice - 1).foodGeneratorList;
		FoodGenerator t = new FoodGenerator(no);
		foodGeneratorList.add(t);
		t.setDaemon(true);
		t.start();
		int money = FoodGenerator.prices[no - 1];
		character.useMoney(money);
	}

	public void usePortion(int no) {
		switch (no) {
		case ActionModel.USE_HP_PORTION:
			int heal = (int) (character.getMaxHp() / 5);
			character.plusHp(heal);
			System.out.println(heal + "만큼 체력 회복");
			System.out.println("내 체력: " + character.getHp());

			character.useMoney(heal);
			break;

		case ActionModel.USE_MP_PORTION:
			int healMp = (int) (character.getMaxMp() / 5);
			character.plusMp(healMp);
			System.out.println(healMp + "만큼 마력 회복");
			System.out.println("내 마력: " + character.getMp());

			character.useMoney(healMp);
			break;
		}
	}

}// actionModel문 종료
