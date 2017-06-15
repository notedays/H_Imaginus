package musaRPG1;

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

	public final static String[] actionNames = { "전투 하기", "정보 보기", "아이템 상점", "스킬 배우기", "병참 관리" };

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
		String[] namageLists = { "병사 충원", "성벽 보수", "병사 배치", "성 공격", "병참 현황", "돌아가기" };
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
		String[] castleBattle = { "궁수 공격", "보병 공격", "공성추 공격", "돌아가기" };
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
}
