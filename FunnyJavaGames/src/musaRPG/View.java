package musaRPG;

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


	public final static String[] actionNames = { "전투 하기", "정보 보기", "아이템 상점", "스킬 배우기" };

	public int selectAction(Character character) {
		System.out.println("\n플레이어 [ " + character.getName() + " ] ");
		for (int i = 1; i <= actionNames.length; i++) {
			System.out.println(i + ". " + actionNames[i - 1]);
		}
		System.out.println((actionNames.length + 1) + ". 게임 종료");
		return inputNo(actionNames.length + 1);
	}

	public int selectBattle(Enemy enemy) {
		System.out.println("\n적 ["+ enemy.getName() + "] 등장!!!");
		String[] battleNames = { "일반 공격", "기술 사용", "피하기", "도망가기" };
		for (int i = 1; i <= battleNames.length; i++) {
			System.out.println(i + ". " + battleNames[i - 1]);
		}
		return inputNo(battleNames.length);
	}

	private int inputNo(int limitNo) {
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
	
	public boolean die(Character character){
		if(character.getCode() == 1){
			System.out.println(character.getName()+"는 조선제일검이 되지 못하고 치명적인 피해를 입고 쓰러졌습니다.");
		}else{
			System.out.println(character.getName()+"는  치명적인 피해를 입고 쓰러졌습니다.");
		}
		System.out.println("=== 게임 오버 ===");
		System.out.println("다시 하시겠습니까? [ Yes(1) / No(2) ] : ");
		return inputNo(2) == 1;
	}

}
