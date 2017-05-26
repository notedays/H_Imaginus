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
			choice = sc.nextInt();
			break;
		} while (choice != 4);

		switch (choice) {
		case 1: { // 새로 시작하기
			System.out.println("새로 시작할 이용자 이름을 입력하시오...");
			String userName = sc.next();
			User player = new User(userName);
			System.out.println(userName + " 계정이 생성되었습니다...");
			System.out.println("계급: " + UserCollection.Silver.getName());
			System.out.println("자금: " + UserCollection.Silver.getMoney());
			System.out.println("빵 반죽 갯수: " + UserCollection.Silver.getPowder());
			System.out.println("빵 갯수: " + UserCollection.Silver.getNumberOfBread());
			System.out.println("붕어빵 틀 갯수: " + UserCollection.Silver.getBreadCase());
			player.name = UserCollection.Silver.getName();
			player.money = UserCollection.Silver.getMoney();
			player.powder = UserCollection.Silver.getPowder();
			player.numberOfBread = UserCollection.Silver.getNumberOfBread();
			player.breadCase = UserCollection.Silver.getBreadCase();
			
			System.out.println();
			while(true){
			System.out.println("1. 붕어빵 만들기...");
			System.out.println("2. 붕어빵 팔기...");
			System.out.println("3. 이전 화면으로...");
			int menuChoice;
			menuChoice = sc.nextInt();
			switch (menuChoice) {
			case 1:{
				MakeBread makeBreads = new MakeBread();
				makeBreads.makeBread(player);
				System.out.println("총 붕어빵의 갯수는 "+ player.getNumberOfBread());
				break;
			}	
			case 2:{
				
				break;
			}
			default:
				System.out.println("이전화면으로 돌아갑니다...");
				break;
			}
			}
			
		}
		case 2: { // 이어서 하기
			break;
		}
		case 3: { // 불러 오기
			System.exit(1);
			break;
		}
		}

	}
}

