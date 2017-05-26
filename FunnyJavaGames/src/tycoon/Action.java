package tycoon;

import java.util.Scanner;

public class Action {

	Scanner sc = new Scanner(System.in);
	Thread threads = new Thread();

	void make(User player) { // 붕어빵 만들기
		if (player.getPowder() > 5) {
			System.out.println("붕어빵을 만드는데 "+player.getMakeSpeed()+"초의 시간이 필요합니다.");
			System.out.println(player.getUserName()+"님은 한번에 "+player.getBreadCase()+"개 생산이 가능합니다.");
			System.out.println("붕어빵 1개당 반죽은 5개 소모 됩니다.");
			TimerUtil a = new TimerUtil();

			System.out.print("붕어빵 몇개를 만들겠습니까?");
			int numberOfMake = sc.nextInt();
			if(numberOfMake <= player.getBreadCase() && numberOfMake > 0){
				System.out.println("붕어빵 생산을 시작합니다.");
				for(int i=0; i< numberOfMake; i++){
					a.timerStart(player);
					System.out.println();
					System.out.println("붕어빵 "+ (i+1)+ "개가 만들어 졌습니다.");
					player.setNumberOfBread(player.getNumberOfBread() + 1);
					System.out.println("붕어빵 반죽이 5개 소모되었습니다.");
					player.setPowder(player.getPowder() - 5);
					if(player.getPowder()<5){
						System.out.println("반죽이 모자랍니다... 반죽을 더 구해오세요");
						break;
					}
					System.out.println();
				}
			}else{
				System.out.println("범위를 잘못 입력했습니다.");
				return;
			}
			System.out.println(player.getUserName()+"님의 "+"총 붕어빵 갯수는 "+player.getNumberOfBread()+"개 입니다.");
			System.out.println("남은 반죽은 " + player.getPowder() + "개 입니다.");
			System.out.println();
		} else {
			System.out.println("빵 반죽이 없어서 붕어빵을 만들지 못했습니다... ");
			System.out.println("빵 반죽을 더 만들어 주세요... ");
		}
	}

	void sell(User player) { // 붕어빵 팔기
		if (player.getNumberOfBread() > 0) {
			System.out.println("붕어빵 판매가 가능합니다...");
			System.out.print("몇개를 팔겠습니까?...");
			int number = sc.nextInt();
			if (player.getNumberOfBread() >= number) {
				System.out.println("판매할 붕어빵 갯수가 충분합니다...");
				System.out.println("붕어빵 판매를 시작합니다...");
				player.setNumberOfBread(player.getNumberOfBread() - number);
				System.out.println("붕어빵 "+number+"개를 팔았습니다...");
				System.out.println();
				player.setMoney(player.getMoney() + number * 500);
				System.out.println("붕어빵 판매 수입은 "+number*500+"입니다.");
				System.out.println("총 자산은 "+player.getMoney()+"입니다.");
				System.out.println();
			} else {
				System.out.println("판매할 붕어빵 갯수가 충분하지 않습니다...");
				System.out.println();
			}
		} else {
			System.out.println("판매 할 붕어빵이 없습니다.");
			System.out.println();
		}
	}

}

class TimerUtil {
	long timeNow;
	void timerStart(User player) {
		new Runnable() {
			@Override
			public void run() {
				timeNow = System.currentTimeMillis();
				int countLimit = player.getMakeSpeed();
				while (true) {
					long timeAfter = System.currentTimeMillis();
					if ((timeAfter - timeNow) / 1000 >= 1) {
						timeNow = timeAfter;
						System.out.print(countLimit + " 초 ~~~~~ㅋ\t");
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

/*
 * class MakeBread {
	void makeBread(User player) {
		Thread[] threads = new Thread[player.breadCase];
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread() {
				@Override
				public void run() {
					synchronized (this.getClass()) {
						try {
							player.setNumberOfBread(player.getNumberOfBread() + 1);
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
*/

class Change {
	public void change(User user) {
		int userMoney = user.getMoney();
		if (userMoney >= 5000 && userMoney <10000) {
			user.setMoney(UserCollection.Gold.getMoney());
			user.setName(UserCollection.Gold.getName());
			user.setNumberOfBread(UserCollection.Gold.getNumberOfBread());
			user.setPowder(UserCollection.Gold.getPowder());
			System.out.println("Gold 등급으로 승급하셨습니다...");
		} else if (userMoney >= 10000 && userMoney < 15000) {
			user.setMoney(UserCollection.Platinum.getMoney());
			user.setName(UserCollection.Platinum.getName());
			user.setNumberOfBread(UserCollection.Platinum.getNumberOfBread());
			user.setPowder(UserCollection.Platinum.getPowder());
			System.out.println("Platinum 등급으로 승급하셨습니다...");
		} else if (userMoney >= 15000) {
			user.setMoney(UserCollection.Vip.getMoney());
			user.setName(UserCollection.Vip.getName());
			user.setNumberOfBread(UserCollection.Vip.getNumberOfBread());
			user.setPowder(UserCollection.Vip.getPowder());
			System.out.println("Vip 등급으로 승급하셨습니다...");
		}
	}
}

/* 	White(1, "White 제빵틀", 10, 10),
	Red(2, "Red 제빵틀", 8, 12),
	Black(3, "Black 제빵틀", 6, 14),
	Pink(4, "Pink 제빵틀", 4, 16);
 */

class Weapon{
	public void weapon(int choice){
		switch(choice){
		case 1:{
			System.out.println("White 제빵틀을 구매합니다.");
			System.out.println("생산 능력치 Up ~~ Grade!!~~~");
			System.out.println("White 제빵틀 능력치...");
			System.out.println("한번에 만들 수 있는 갯수 : "+BreadCase.White.getNumberOfCase()+"개");
			System.out.println("빵 생산 스피드 : "+BreadCase.White.getMakeSpeed()+"초당 하나");
			break;
		}
		case 2:{
			System.out.println("Red 제빵틀을 구매합니다.");
			System.out.println("생산 능력치 Up ~~ Grade!!~~~");
			System.out.println("White 제빵틀 능력치...");
			System.out.println("한번에 만들 수 있는 갯수 : "+BreadCase.Red.getNumberOfCase()+"개");
			System.out.println("빵 생산 스피드 : "+BreadCase.Red.getMakeSpeed()+"초당 하나");
			break;
		}
		case 3:{
			System.out.println("Black 제빵틀을 구매합니다.");
			System.out.println("생산 능력치 Up ~~ Grade!!~~~");
			System.out.println("White 제빵틀 능력치...");
			System.out.println("한번에 만들 수 있는 갯수 : "+BreadCase.Black.getNumberOfCase()+"개");
			System.out.println("빵 생산 스피드 : "+BreadCase.Black.getMakeSpeed()+"초당 하나");
			break;
		}
		case 4:{
			System.out.println("Pink 제빵틀을 구매합니다.");
			System.out.println("생산 능력치 Up ~~ Grade!!~~~");
			System.out.println("White 제빵틀 능력치...");
			System.out.println("한번에 만들 수 있는 갯수 : "+BreadCase.Pink.getNumberOfCase()+"개");
			System.out.println("빵 생산 스피드 : "+BreadCase.Pink.getMakeSpeed()+"초당 하나");
			break;
		}
		}
	}
}