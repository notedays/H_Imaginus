package musaRPG1;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class View {
	Scanner sc = new Scanner(System.in);

	public Character selectCharacter() {
		Character[] characterArray = Character.values();
		for (int i = 1; i <= characterArray.length; i++) {
			System.out.println(i + ". " + characterArray[i - 1].getName());
		}
		System.out.print("플레이할 캐릭터를 고르세요 : ");
		int charIdx = -1;
		do {
			charIdx = sc.nextInt() - 1;
		} while (charIdx < 0 || charIdx >= characterArray.length);
		return characterArray[charIdx];
	}

	public final static String[] actionNames = { "전투 하기", "정보 보기", "아이템 상점", "스킬 배우기", "공성전 관리" };

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
		String[] battleNames = { "일반 공격", "기술 사용", "도망가기", "피하기" };
		for (int i = 1; i <= battleNames.length; i++) {
			System.out.println(i + ". " + battleNames[i - 1]);
		}
		return inputNo(battleNames.length);
	}

	public int selectSkill(Character character, Enemy enemy) { // 공격 시 스킬 선택 항목
		System.out.println("사용할 스킬 목록");
		int size = character.getSkillList().size();
		for (int i = 1; i <= size; i++) {
			System.out.print(i + ". " + character.getSkillList().get(i - 1) + "\t");
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

	public int learnSkill() {
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
		return inputNo(skillList.length);
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

	public int numberCompanion(int no) {
		System.out.print("얼마나 생산하시겠습니까?");
		int number = sc.nextInt();
		return number;
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
	}

	public void showMyCastle(Character character) {
		System.out.println("===보유성 현황===");
		for (int i = 1; i <= character.castles.size(); i++) {
			System.out.println(i + ". " + character.castles.get(i - 1).getName());
		}
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

			} catch ( Exception e) {
				System.out.print("숫자를 입력해 주세요");
			}

			if (number <= castle.getMaxCount() && number >= 0) {
				return number;
			} else {
				System.out.println("범위내 숫자를 입력해 주세요");
			}
		}
	}
	
	public int numberFood(Character chracter){
		System.out.println("군량미 1석 : 500원");
		int maxBuy = (int)(chracter.getMoney() / 50);
		return returnNumber(maxBuy);
	}
	
	public int returnNumber(int maxNumber){
		while (true) {
			int number = 0;
			try {
				System.out.print( maxNumber + "개 까지 가능"+"\n");
				System.out.print("값을 입력하세요 :");
				number = sc.nextInt();
			} catch (Exception e) {
				System.out.println("정수값을 입력해 주세요");
				continue;
			}
			if (number <= maxNumber) {
				return number;
			} else {
				System.out.println("범위내 숫자를 입력해 주세요");
			}
		}
	}
	
	
	
	
	
}
