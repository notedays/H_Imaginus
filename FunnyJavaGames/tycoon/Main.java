package tycoon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		new Main();
	}

	int choice;

	public Main() {
		Scanner sc = new Scanner(System.in);
		do {
			// 초기화면
			System.out.println("Welcome To Tycoon");
			System.out.println("1. 새로 시작하기...");
			System.out.println("2. 이어서 하기...");
			System.out.println("3. 불러 오기...");
			System.out.println("4. 종료 하기...");
			System.out.println();
			choice = sc.nextInt();

		switch (choice) {
		case 1: { // 새로 시작하기
			System.out.println("새로 시작할 이용자 이름을 입력하시오...");
			String userName = sc.next();
			User player = new User(userName);
			System.out.println(userName + " 계정이 생성되었습니다...");
			System.out.println("이름 : " + player.name);
			System.out.println("계급 : " + UserCollection.Silver.getName());
			System.out.println("자금 : " + UserCollection.Silver.getMoney());
			System.out.println("빵 반죽 갯수 : " + UserCollection.Silver.getPowder());
			System.out.println("빵 갯수 : " + UserCollection.Silver.getNumberOfBread());
			System.out.println("한번에 생산할 수 있는 붕어빵 갯수 : " + player.getBreadCase() + "개");
			System.out.println("붕어빵 만드는 속도: " + player.getMakeSpeed() + "초");

			player.userName = userName;
			player.name = UserCollection.Silver.getName();
			player.money = UserCollection.Silver.getMoney();
			player.powder = UserCollection.Silver.getPowder();
			player.numberOfBread = UserCollection.Silver.getNumberOfBread();

			System.out.println();

			// 캐릭터 생성 완료

			
			int menuChoice=0;
			while (menuChoice != 6) {
				System.out.println("1. 붕어빵 만들기...");
				System.out.println("2. 붕어빵 팔기...");
				System.out.println("3. 진급하기...");
				System.out.println("4. 상점이용하기...");
				System.out.println("5. 반죽만들기...");
				System.out.println("6. 이전 화면으로...");
				menuChoice = sc.nextInt();
				switch (menuChoice) {
				case 1: {
					Action make = new Action();
					make.make(player);
					break;
				}
				case 2: {
					Action action = new Action();
					action.sell(player);
					break;
				}
				case 3: {
					System.out.println("자본이 5000이상인 경우 Gold Class로 진급...");
					System.out.println("자본이 10000이상인 경우 Platinum Class로 진급...");
					System.out.println("자본이 15000이상인 경우 Vip Class로 진급...");
					System.out.println();
					Change change = new Change();
					change.change(player);

					System.out.println("등급 : " + player.getName());
					System.out.println("자본 : " + player.getMoney());
					System.out.println("빵 반죽 갯수 : " + player.getNumberOfBread());
					System.out.println("빵 갯수 : " + player.getNumberOfBread());
					System.out.println("붕어빵 틀 갯수 : " + player.getBreadCase());
					System.out.println();
					break;
				}

				case 4: {
					System.out.println("붕어빵 타이쿤 상점에 오신 것을 환영합니다...");
					System.out.println("판매 아이템 목록 ...");
					System.out.println("1. White 제빵틀(3000원) : 붕어빵 만드는 속도(4초), 붕어빵 틀(10개) ");
					System.out.println("2. Red 제빵틀(5000원) : 붕어빵 만드는 속도(3초), 붕어빵 틀(12개) ");
					System.out.println("3. Black 제빵틀(7000원) : 붕어빵 만드는 속도(2초), 붕어빵 틀(14개) ");
					System.out.println("4. Pink 제빵틀(10000원) : 붕어빵 만드는 속도(1초), 붕어빵 틀(16개) ");
					System.out.println("구매 할 아이템의 번호를 입력하시오[1 ~ 4]");
					System.out.println();
					int weaponChoice = sc.nextInt();
					Weapon weapon = new Weapon();

					switch (weaponChoice) {
					case 1: {
						if (player.getMoney() >= 3000) {
							weapon.weapon(weaponChoice);
							player.setBreadCase(BreadCase.White.getNumberOfCase());
							player.setMakeSpeed(BreadCase.White.getMakeSpeed());
							player.setMoney(player.getMoney()-3000);
							System.out.println("남은 자산은 "+player.getMoney()+"입니다...");
							System.out.println();
						} else {
							System.out.println("소지 금액이 부족합니다.");
						}
						break;
					}
					case 2: {
						if (player.getMoney() >= 5000) {
							weapon.weapon(weaponChoice);
							player.setBreadCase(BreadCase.Red.getNumberOfCase());
							player.setMakeSpeed(BreadCase.Red.getMakeSpeed());
							player.setMoney(player.getMoney()-5000);
							System.out.println("남은 자산은 "+player.getMoney()+"입니다...");
							System.out.println();
						} else {
							System.out.println("소지 금액이 부족합니다.");
						}
						break;
					}
					case 3: {
						if (player.getMoney() >= 7000) {
							weapon.weapon(weaponChoice);
							player.setBreadCase(BreadCase.Black.getNumberOfCase());
							player.setMakeSpeed(BreadCase.Black.getMakeSpeed());
							player.setMoney(player.getMoney()-7000);
							System.out.println("남은 자산은 "+player.getMoney()+"입니다...");
							System.out.println();
						} else {
							System.out.println("소지 금액이 부족합니다.");
						}
						break;
					}
					case 4: {
						if (player.getMoney() >= 10000) {
							weapon.weapon(weaponChoice);
							player.setBreadCase(BreadCase.Pink.getNumberOfCase());
							player.setMakeSpeed(BreadCase.Pink.getMakeSpeed());
							player.setMoney(player.getMoney()-10000);
							System.out.println("남은 자산은 "+player.getMoney()+"입니다...");
							System.out.println();
						} else {
							System.out.println("소지 금액이 부족합니다.");
						}
						break;
					}

					default: {
						return;
					}
					}
					break;
				}

				case 5: {
					System.out.println("반죽을 만듭니다.");
					System.out.println("반죽을 몇개 만들겠습니까?");
					int number = sc.nextInt();
					player.setPowder(player.getPowder() + number);
					System.out.println("반죽이 " + number + "개 추가되어서 " + player.getPowder() + "개 있습니다.");
					System.out.println();
					break;
				}

				case 6: {
					System.out.println();
					System.out.println("이전화면으로 돌아갑니다...");
					break;
				}
				}
			}//while문 종료 
		}
		case 2: { // 이어서 하기
			break;
		}
		case 3: { // 불러 오기
			System.exit(1);
			break;
		}
		}
		} while (choice != 4);
	}
}
