package place_Lee;

/**
*  # 고양이 키우기
*     @ 액션 커맨드 ( 키로 입력받아서 실행 ) 
*     1. 밥 주기 - 밥을 주면 호감도 +2
*     2. 놀아주기 - 호감도 +1, 행동력 -2;
*     3. 산책하기 - 호감도(15) 이상 부터 가능. 호감도 +3, 행동력 -3
*     4. 부르기 - 호감도 (5) 이상부터 가능. 호감도 +1, 행동력 -1
*     5. 재우기 - 행동력 + 5
*     @ 행동력이 0이 되면 게임 오버
*     @ 행동력이 부족하면 해당 행동을 실행 X
*     @ 호감도가 30이 되면 해피엔딩. */

import java.util.*;

class Inform {

	String catName;
	int like = 0, power = 10;
	int command;
	Scanner sc = new Scanner(System.in);

	public void showCommand() {
		System.out.println("1. 밥 주기 : 호감도 + 1, 행동력 - 1");
		System.out.println("2. 놀아주기 : 호감도 + 2, 행동력 -2");
		System.out.println("3. 산책하기 : 호감도 + 3, 행동력 -3, 호감도 15이상");
		System.out.println("4. 부르기 : 호감도 + 2, 행동력 - 2, 호감도 5이상");
		System.out.println("5. 재우기 : 행동력 + 5");
	}

	public void showCurrentStat() {
		System.out.printf("나는 니가 %d 만큼 좋다옹, 나는 힘이 %d만큼 남았다옹.\n", like, power);
	}

	public void inputCommand() {
		this.command = sc.nextInt();

	}

	public void die() {
		System.out.println("나쁜 집사새끼...아엠 다이");
	}

	public void grown() {
		System.out.println("난 이제 다 컸다옹. 더 넓은 세상을 향해 간다옹. 빠잉");

	}

	public void catInterface() {
		showCurrentStat();
		showCommand();
	}

	public void work() {

		if (power > 0 && power < 30) {

			switch (command) {
			case 1: {
				this.like += 1;
				this.power -= 1;
				break;
			}

			case 2: {
				this.like += 2;
				this.power -= 2;
				break;
			}
			case 3: {
				if (like > 15) {
					this.like += 3;
					this.power -= 3;
				} else {
					System.out.println("호감도가 부족하다옹.");
				}
				break;
			}
			case 4: {
				if (like > 5) {
					this.like += 2;
					this.power -= 2;
				} else {
					System.out.println("호감도가 부족하다옹.");

				}
				break;
			}
			case 5: {
				this.power += 5;

				break;

			}

			}
		} else if (like >= 30)
			grown();

		else if (power <= 0)
			die();

	}

}

public class CatGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Inform cat = new Inform();

		boolean catpower = (cat.power > 0);

		do {
			cat.catInterface();
			cat.inputCommand();
			cat.work();
		} while (catpower);

	}

}
