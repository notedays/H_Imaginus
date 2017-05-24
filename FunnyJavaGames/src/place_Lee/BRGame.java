package place_Lee;

import java.util.*;

public class BRGame {

	Scanner sc = new Scanner(System.in);
	Random random = new Random();
	int playerNum;
	int nowNum = 1;
	int selectNum;
	int count;

	public static void main(String[] args) {
		new BRGame();
	}

	public BRGame() {
		System.out.println("베스킨라빈스 게임을 시작합니다. 플레이어 수를 입력하세요.");
		playerNum = sc.nextInt();

		System.out.println("플레이어 이름을 입력하세요.첫번째 플레이어만 숫자를 정할수 있습니다.");
		String[] name = new String[playerNum];
		for (int i = 0; i < playerNum; i++) {
			System.out.println("플레이어 이름 입력 : ");
			name[i] = sc.next();
		}

		while (true) {
			System.out.println("진행 할 숫자수를 1~3까지 입력하세요.");
			selectNum = sc.nextInt();
			if (selectNum > 3) {
				System.out.println("3의 범위 안에서 입력하세요");
				continue;
			} else {
				count = 0;
				System.out.print(name[0] + "(나)의 선택 :");
				for (int i = nowNum; i < nowNum + selectNum; i++) {
					System.out.print(i + " ");
				}
				nowNum = nowNum + selectNum;
				if (nowNum > 31) { // 왜 31이상인지 모르겠음
					System.out.println("\n31!!!" + name[count] + "(이)가 걸렸습니다.");
					System.exit(0);
				}
				System.out.println();

				do {
					count++;

					int r = random.nextInt(3) + 1;
					int n = nowNum + r;
					System.out.print(name[count] + " 의 선택 :");

					for (int i = nowNum; i < n; i++) {
						System.out.print(i + " ");
					}
					nowNum = nowNum + r;
					if (nowNum > 31) {
						System.out.println("\n31!!!" + name[count] + "(이)가 걸렸습니다.");
						System.exit(0);
					}
					System.out.println();
				} while (!playerCount());

			}
		}
	}

	public boolean playerCount() {
		if (count == (playerNum - 1))
			return true;
		else
			return false;
	}

	public boolean ok() {
		if (nowNum >= 31)
			return true;
		else
			return false;

	}

}
