package musaRPG1;

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
		System.out.println("\n적 ["+ enemy.getName() + "] 등장!!!");
		String[] battleNames = { "일반 공격", "기술 사용", "피하기", "도망가기" };
		for (int i = 1; i <= battleNames.length; i++) {
			System.out.println(i + ". " + battleNames[i - 1]);
		}
		return inputNo(battleNames.length);
	}
	
	public int selectSkill(Character character, Enemy enemy){	// 공격 시 스킬 선택 항목
		System.out.println("사용할 스킬 목록");
		int size = character.getSkillList().size();
		for(int i = 1; i <= size; i++){
			System.out.print(i+". "+character.getSkillList().get(i-1)+"\t");
			System.out.println();
		}
		return inputNo(size);
	}
	
	public int inputNo(int limitNo) {
		System.out.print("무엇을 하시겠습니까? : ");
		int no = -1;
		do {
			try {
				no = sc.nextInt();
			} catch (Exception e) {
				System.out.println("잘못된 번호를 입력하였습니다.");
			}
		} while (no < 1 || no > limitNo);
		return no;
	}
	
	public int skillList(){
		String [] skillNames = { "스킬 익히기" , "스킬 삭제" , "돌아가기"};
		for (int i = 1; i <= skillNames.length; i++) {
			System.out.println(i + ". " + skillNames[i - 1]);
		}
		return inputNo(skillNames.length);		
	}
	
	public int manageList(){
		String [] namageLists = { "병사 충원", "성벽 보수", "병사 배치", "돌아가기"};
		for (int i = 1; i <= namageLists.length; i++) {
			System.out.println(i + ". " + namageLists[i - 1]);
		}
		return inputNo(namageLists.length);	
	}
	
	public int companionList(){
		String [] companionLists = {"궁병 충원", "보병 충원", "기병 충원", "돌아가기"};
		for (int i = 1; i<= companionLists.length; i++) {
			System.out.println(i + ". " + companionLists[i-1]);
		}
		return inputNo(companionLists.length);
	}
	
}
