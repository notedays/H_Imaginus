package tycoon;

import java.util.Scanner;

public class Action {

	Scanner sc = new Scanner(System.in);
	Thread threads = new Thread();

	void make(User player) { // 붕어빵 만들기
		if (player.getPowder() > 5) {
			player.setNumberOfBread(player.getNumberOfBread() + 1);
			System.out.println("붕어빵을 만드는데 " + "5초의 시간이 필요합니다.");
			TimerUtil a = new TimerUtil();
			a.timerStart();

			System.out.println("붕어빵 1개가 만들어 졌습니다.");
			System.out.println("붕어빵 반죽이 5개 소모되었습니다.");
			player.setPowder(player.getPowder() - 5);
			System.out.println("남은 반죽은 " + player.getPowder() + "입니다.");
		} else {
			System.out.println("돈이 없어서 붕어빵을 만들지 못했습니다. ");
		}
	}

	void sell(User player) { // 붕어빵 팔기
		if (player.getNumberOfBread() > 0) {
			System.out.println("붕어빵 판매가 가능합니다...");
			System.out.println("몇개를 팔겠습니까?...");
			int number = sc.nextInt();
			if (player.getNumberOfBread() > number) {
				System.out.println("판매할 붕어빵 갯수가 충분합니다...");
				player.setNumberOfBread(player.getNumberOfBread() - number);
				player.setMoney(player.getMoney() + number * 500);
			} else {
				System.out.println("판매할 붕어빵 갯수가 충분하지 않습니다...");
			}
		} else {
			System.out.println("판매 할 붕어빵이 없습니다.");
		}
	}

}

class TimerUtil {
	long timeNow;

	void timerStart() {
		new Runnable() {
			@Override
			public void run() {
				timeNow = System.currentTimeMillis();
				int countLimit = 4;
				while (true) {
					long timeAfter = System.currentTimeMillis();
					if ((timeAfter - timeNow) / 1000 >= 1) {
						timeNow = timeAfter;
						System.out.println(countLimit + " 초!!!");
						countLimit--;

						// # 카운트가 1초일때 바로 타이머 종료
						if (countLimit < 1) {
							break;
						}
					}
				}
			}
		}.run();
	}
}

class MakeBread {
	void makeBread(User player) {
		Thread[] threads = new Thread[player.breadCase];
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread() {
				@Override
				public void run() {
					synchronized (this.getClass()) {
						try {
							player.setNumberOfBread(player.getNumberOfBread() + 1);
							System.out.println("붕어빵 틀에서 붕어빵을 만듭니다. ");
							Thread.sleep(5000);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			};
			threads[i].start();
		}
	}
}
