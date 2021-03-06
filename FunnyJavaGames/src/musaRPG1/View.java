package musaRPG1;

import java.util.List;
import java.util.Scanner;

public class View {
	Scanner sc = new Scanner(System.in);

	public Character selectFirstCharacter() {
		Character[] characterArray = Character.values();
		// for (int i = 1; i <= characterArray.length; i++) {
		for (int i = 1; i <= 2; i++) {
			System.out.println(i + ". " + characterArray[i - 1].getName());
		}
		System.out.print("플레이할 캐릭터를 고르세요 : ");
		int charIdx = -1;
		do {
			charIdx = sc.nextInt() - 1;
		} while (charIdx < 0 || charIdx >= characterArray.length);
		return characterArray[charIdx];
	}

	public final static String[] actionNames = { "전투 하기", "캐릭터 정보 보기", "아이템 상점", "스킬 배우기", "공성전 관리", "성 관리", "전직" };

	public void showCharacter(Character character) {
		System.out.println(character.getName());
		System.out.println("내 레벨: " + character.getLevel());
		System.out.println("내 체력: " + character.getHp() + "/" + character.getMaxHp());
		System.out.println("내 마력: " + character.getMp() + "/" + character.getMaxMp());
		System.out.println("내 경험치: " + character.getExp() + "/" + character.getMaxExp());
		System.out.println("내 공격력: " + character.getAttack());
		System.out.println("내 소지금: " + character.getMoney());

	}

	public int selectAction(Character character) {
		System.out.println("\n플레이어 [ " + character.getName() + " ] ");
		for (int i = 1; i <= actionNames.length; i++) {
			System.out.println(i + ". " + actionNames[i - 1]);
		}
		System.out.println((actionNames.length + 1) + ". 게임 종료");
		return inputNo(actionNames.length + 1);
	}

	public int selectBattle(Character character, Enemy enemy) {
		System.out.println("\n적 [" + enemy.getName() + "] 등장!!!");
		String[] battleNames = { "일반 공격", "기술 사용", "도망가기", "피하기", "물약 사용" };
		for (int i = 1; i <= battleNames.length; i++) {
			System.out.println(i + ". " + battleNames[i - 1]);
		}
		return inputNo(battleNames.length);
	}

	public int selectSkill(Character character, Enemy enemy) { // 공격 시 스킬 선택 항목
		System.out.println("사용할 스킬 목록");
		int size = character.getSkillList().size();
		for (int i = 1; i <= size; i++) {
			System.out.print(i + ". " + character.getSkillList().get(i - 1).getName() + "\t");
			System.out.println();
		}
		return inputNo(size);
	}

	public int inputNo(int limitNo) {
		int no = -1;
		do {
			System.out.print("무엇을 하시겠습니까? : ");
			try {
				no = sc.nextInt();
			} catch (Exception e) {
				System.out.println("잘못된 번호를 입력하였습니다.");
			} finally {
				sc.nextLine();
			}
		} while (no < 1 || no > limitNo);
		return no;
	}

	public int inputNoRange(int startNo) {
		int no = -1;
		do {
			System.out.print("무엇을 하시겠습니까? : ");
			try {
				no = sc.nextInt();
			} catch (Exception e) {
				System.out.println("잘못된 번호를 입력하였습니다.");
			} finally {
				sc.nextLine();
			}
		} while (no < startNo || no >= startNo + 4); // false, false
		return no;
	}

	public int inputNumber(int limitNo) {
		int no = -1;
		do {
			System.out.print("원하는 숫자 입력하세요 : ");
			try {
				no = sc.nextInt();
			} catch (Exception e) {
				System.out.println("잘못된 숫자를 입력하였습니다.");
			} finally {
				sc.nextLine();
			}
		} while (no < 1 || no > limitNo);
		return no;
	}

	public int learnSkill(int code) {
		Skill[] skillList = Skill.values();
		int i;
		for (i = 0; i < skillList.length; i++) {
			if (skillList[i].getCode() == code) {
				for (int j = 0; j < 4; j++) {
					System.out.println((i + j) + ". " + skillList[i + j].getName());
				}
				return inputNoRange(i);
			}
		}
		return 0;
	}

	public int deleteSkill(Character character) {
		List<Skill> deleteSkillList = character.skillList;
		if (deleteSkillList.isEmpty() == true) {
			System.out.println("삭제할 기술이 없습니다");
			return 0;
		} else {
			for (int i = 1; i <= deleteSkillList.size(); i++) {
				System.out.println(i + ". " + deleteSkillList.get(i - 1).getName() + " 삭제");
			}
		}
		return inputNo(deleteSkillList.size());
	}

	public int selectSkill() {
		String[] skillNames = { "스킬 익히기", "스킬 삭제", "돌아가기" };
		for (int i = 1; i <= skillNames.length; i++) {
			System.out.println(i + ". " + skillNames[i - 1]);
		}
		return inputNo(skillNames.length);
	}

	public int selectManage() {
		String[] namageLists = { "병사 충원", "군량미 구매", "병사 배치", "성 공격", "병참 현황", "성 보유 현황", "돌아가기" };
		for (int i = 1; i <= namageLists.length; i++) {
			System.out.println(i + ". " + namageLists[i - 1]);
		}
		return inputNo(namageLists.length);
	}

	public int selectCompanion() {
		String[] companionLists = { "궁병 충원", "보병 충원", "공성추 충원", "돌아가기" };
		for (int i = 1; i <= companionLists.length; i++) {
			System.out.println(i + ". " + companionLists[i - 1]);
		}
		return inputNo(companionLists.length);
	}

	public int selectCastle() {
		Castles[] castles = Castles.values();
		for (int i = 1; i <= castles.length; i++) {
			System.out.println(i + ". " + castles[i - 1].getName() + " 공격");
		}
		return inputNo(castles.length);
	}

	public int selectCastleBattle() {
		String[] castleBattle = { "궁수 공격", "보병 공격", "공성추 공격" };
		for (int i = 1; i <= castleBattle.length; i++) {
			System.out.println(i + ". " + castleBattle[i - 1]);
		}
		return inputNo(castleBattle.length);
	}

	public int gatherCompanion(Character character) {
		System.out.println("소유 금액은 " + character.getMoney() + "입니다");
		for (int i = 1; i <= Companion.demandMoneys.length; i++) {
			System.out.println(i + ". " + Companion.names[i - 1] + " 생산시 " + Companion.demandMoneys[i - 1] + "원 필요");
		}
		return inputNo(Companion.demandMoneys.length);
	}

	public void showMyCompanion(Character character) {
		List<Companion> comList = character.companionList;
		System.out.println("=== 보유 병력 현황 ===");
		for (int i = 1; i <= comList.size(); i++) {
			System.out.print(i + ". " + comList.get(i - 1).getName() + " ");
			System.out.print(comList.get(i - 1).getVolume() + "명" + "\t");
			System.out.print("총 공격력: " + comList.get(i - 1).getAttack() + "\t");
			System.out.print("총 방어력: " + comList.get(i - 1).getDefense() + "\t");
			System.out.println();
		}
		System.out.println("=== 보유 자원 현황 ===");
		System.out.println(character.getFood() + "만큼 군량미 보유");

	}

	public int showMyCastle(Character character) {
		System.out.println("===보유성 현황===");
		for (int i = 1; i <= character.castles.size(); i++) {
			System.out.println(i + ". " + character.castles.get(i - 1).getName());
		}
		return inputNo(character.castles.size());
	}

	public int deployCompanion(Character character) {
		List<Companion> companionList = character.companionList;
		System.out.println("===배치 가능한 목록===");
		for (int i = 1; i <= companionList.size(); i++) {
			System.out.println(i + ". " + companionList.get(i - 1).getName() + " " + " 배치");
		}
		return inputNo(companionList.size());
	}

	public int chooseCastle(Character character) {
		List<Castles> castleList = character.castles;
		System.out.println("===배치 가능한 내성 목록===");

		for (int i = 1; i <= castleList.size(); i++) {
			System.out.print(i + ". " + castleList.get(i - 1).getName() + " 배치" + "\t");
			System.out.print("(" + castleList.get(i - 1).getMaxCount() + "명의 병사 수용 가능" + ")");
			System.out.println();
		}
		return inputNo(castleList.size());
	}

	public int numberDeploy(Character character, Castles castle) {
		while (true) {
			int number = 0;
			try {
				System.out.println(castle.getName() + "에서는 최대 " + castle.getMaxCount() + "명 까지 배치 가능합니다");
				showMyCompanion(character);
				System.out.print("몇 명 배치하시겠습니까?");
				number = sc.nextInt();

			} catch (Exception e) {
				System.out.print("숫자를 입력해 주세요");
			}

			if (number <= castle.getMaxCount() && number >= 0) {
				return number;
			} else {
				System.out.println("범위내 숫자를 입력해 주세요");
			}
		}
	}

	public int numberFood(Character chracter) {
		System.out.println("군량미 1석 : 50원");
		int maxBuy = (int) (chracter.getMoney() / 50);
		System.out.println(maxBuy + "개 까지 구입가능 합니다");
		return inputNumber(maxBuy);
	}

	public int numberCompanion(int no) {
		System.out.print("몇 명 생산하시겠습니까 ?");
		int num = sc.nextInt();
		return num;
	}

	public int castleNumberCompanion(Character character, int choice) {
		switch (choice) {
		case Companion.ARCHOR:
			Companion archor = character.companionList.get(Companion.ARCHOR - 1);
			System.out.println(archor.getName() + "\t" + archor.getAmount() + "명 배치 가능합니다");
			return inputNumber(archor.getAmount());
		case Companion.SOLDIER:
			Companion soldier = character.companionList.get(Companion.SOLDIER - 1);
			System.out.println(soldier.getName() + "\t" + soldier.getAmount() + "명 배치 가능합니다");
			return inputNumber(soldier.getAmount());

		case Companion.SIEGER:
			Companion sieger = character.companionList.get(Companion.SIEGER - 1);
			System.out.println(sieger.getName() + "\t" + sieger.getAmount() + "명 배치 가능합니다");
			return inputNumber(sieger.getAmount());
		}
		return 0;
	}

	public int showCastleManage() {
		String[] castleManage = { "기기 설치", "자원 회수" };
		for (int i = 1; i <= castleManage.length; i++) {
			System.out.println(i + ". " + castleManage[i - 1]);
		}
		return inputNo(castleManage.length);
	}

	public int showGenerator() {
		String[] generator = { "금광 설치", "농장 설치" };
		for (int i = 1; i <= generator.length; i++) {
			System.out.println(i + ". " + generator[i - 1]);
		}
		return inputNo(generator.length);
	}

	public int showCollector(int no) {
		if (no == ActionModel.COLLECT_RESOURCE) {
			String[] collect = { "자원 회수" };
			for (int i = 1; i <= collect.length; i++) {
				System.out.println(i + ". " + collect[i - 1]);
			}
			return inputNo(collect.length);
		}
		return 0;
	}

	public int showGoldGenerator() {
		String[] goldGenerator = GoldGenerator.names;
		for (int i = 1; i <= goldGenerator.length; i++) {
			System.out.println(i + ". " + goldGenerator[i - 1] + " 생산");
		}
		return inputNo(goldGenerator.length);
	}

	public int showFoodGenerator() {
		String[] foodGenerator = FoodGenerator.names;
		for (int i = 1; i <= foodGenerator.length; i++) {
			System.out.println(i + ". " + foodGenerator[i - 1] + " 생산");
		}
		return inputNo(foodGenerator.length);
	}

	public int showPortion() {
		String[] portionName = { "빨간 물약", "파란 물약" };
		for (int i = 1; i <= portionName.length; i++) {
			System.out.println(i + ". " + portionName[i - 1] + "을 사용합니다");
		}
		return inputNo(portionName.length);
	}

	public int showAttribute() {
		String[] className = { "불 계열", "얼음 계열" };
		for (int i = 1; i <= className.length; i++) {
			System.out.println(i + ". " + className[i - 1] + "을 선택합니다");
		}
		return inputNo(className.length);
	}

	public int showFireClass() {
			String[] className = { "불꽃 무사", "화염 무사", "용암 무사"};
			for (int i = 1; i <= className.length; i++) {
				System.out.println(i + ". " + className[i - 1] + "로 전직 합니다");
			}return inputNo(className.length);
	}

	public int showIceClass() {
			String[] className = { "냉기 무사", "얼음 무사", "빙하 무사"};
			for (int i = 1; i <= className.length; i++) {
				System.out.println(i + ". " + className[i - 1] + "로 전직 합니다");
			}return inputNo(className.length);
	}
	
	
	
}
