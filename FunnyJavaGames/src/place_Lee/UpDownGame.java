package place_Lee;

import java.util.*;

public class UpDownGame {
	Random r = new Random();
	Scanner scan = new Scanner(System.in);
	int gameNum, inputNum, topNum = 50, botNum = 1;

	public static void main(String[] args) {
		new UpDownGame();
	}

	public UpDownGame() {
		gameNum = (r.nextInt(50) + 1);
		System.out.println("숫자를 고르시오 1~50");

		while (true) {
			inputNum = scan.nextInt();
			if (ok())
				System.out.println("정답!!!축하합니다!!!");
			else if (UpDown()) {
				botNum = inputNum + 1;
				System.out.printf("UP!!!. %d부터 %d 까지 선택해 주세요.", botNum, topNum);
			} else {
				topNum = inputNum - 1;
				System.out.printf("DOWN!!!. %d부터 %d 까지 선택해 주세요.", botNum, topNum);
			}
		}
	}

	public boolean ok() {
		if (gameNum == inputNum)
			return true;
		else
			return false;
	}

	public boolean UpDown() {
		if (gameNum > inputNum)
			return true;
		else
			return false;
	}
}
