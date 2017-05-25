package place_Lee;

import java.util.*;

public class BRGame {

	Scanner sc = new Scanner(System.in);
	Random random = new Random();
	int playerNum;
	int nowNum = 1;
	int selectNum;
	int count;
	String[] name;

	public static void main(String[] args) {
		new BRGame();
	}

	public BRGame() {
		System.out.println("컴퓨터와 베스킨라빈스 게임을 시작합니다. 플레이어 수를 입력하세요.");
		playerNum = sc.nextInt();

		System.out.println("플레이어 이름을 입력하세요.");
		name = new String[playerNum];
		for (int i = 0; i < playerNum; i++) {
			System.out.println("플레이어 이름 입력 : ");
			name[i] = sc.next();
		}

		while (true) { // 플레이어
			System.out.println("카운트 할 숫자수를 1~3 중에 입력하세요.");
			selectNum = sc.nextInt();
			if (selectNum > 3 || selectNum < 1) {
				System.out.println("범위 안에서 입력하세요");
				continue;
			}
			count = 0;
			result();

			System.out.println();

			do { // 컴퓨터
				count++;

				selectNum = random.nextInt(3) + 1;
				int n = nowNum + selectNum;
				result();

				System.out.println();
			} while (!playerCount());

		}
	}

	public boolean playerCount() {
		if (count == (playerNum - 1))
			return true;
		else
			return false;
	}

	public void result() {

		System.out.print(name[count] + " 의 선택 :");
		for (int i = nowNum; i < nowNum + selectNum; i++) {
			System.out.print(i + " ");
		}
		nowNum = nowNum + selectNum;
		if (nowNum > 31) {
			System.out.println("\n31!!!" + name[count] + "(이)가 걸렸습니다.");
			System.exit(0);
		}

	}

}