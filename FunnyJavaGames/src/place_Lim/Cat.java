package place_Lim;

import java.util.Scanner;
/*
 *  # 고양이 키우기
 *     @ 액션 커맨드 ( 키로 입력받아서 실행 ) 
 *     1. 밥 주기 - 밥을 주면 호감도 +2
 *     2. 놀아주기 - 호감도 +1, 행동력 -2;
 *     3. 산책하기 - 호감도(15) 이상 부터 가능. 호감도 +3, 행동력 -3
 *     4. 부르기 - 호감도 (5) 이상부터 가능. 호감도 +1, 행동력 -1
 *     
 *     @ 행동력이 0이 되면 게임 오버
 *     @ 행동력이 부족하면 해당 행동을 실행 X
 *     @ 호감도가 30이 되면 해피엔딩. 
*/

public class Cat {
	int attraction = 0; // 호감도
	int movement = 10; // 행동력
	int age; // 나이
	int hungry = 80; // 배고픔정도
	String name; // 고양이 이름
	String[] food = { "사료", "과일" };

	public Cat(int age, String name) { // 생성자
		this.age = age;
		this.name = name;
	}

	void feed() { // 고양이 밥주기
		int choice = 0; // 초기 선택 값
		System.out.println(name+"에게 밥을 줍니다");
		do {
			System.out.println("아래의 목록중 선택하시오: ");
			System.out.println("1. 사료를 줍니다.");
			System.out.println("2. 과일을 줍니다.");
			System.out.println("0. 돌아갑니다.");
			Scanner sc = new Scanner(System.in);
			choice = sc.nextInt();
			if (choice == 1) { // 사료를 먹은 경우
				if (hungry == 100) {
					System.out.println("이미 배가 부릅니다");
				} else {
					System.out.println(name + "고양이가" + food[0] + "을 먹습니다");
					attraction += 2;
					System.out.println(name + "고양이에 대한 호감도가 2만큼 상승해" + "호감도가" + attraction + "이 되었습니다");
					System.out.println();
				}
			} else if (choice == 2) { // 과일을 먹은 경우
				if (hungry == 100) {
					System.out.println("이미 배가 부릅니다");
				} else {
					System.out.println(name + "고양이가" + food[0] + "을 먹습니다");
					attraction += 2;
					System.out.println(name + "고양이에 대한 호감도가 2만큼 상승해" + "호감도가" + attraction + "이 되었습니다");
					System.out.println();
				}
			} else {
				break;
			}
		} while (choice != 0);
	}

	// 2. 놀아주기 - 호감도 +1, 행동력 -2;
	void play() { // 고양이랑 놀아주기
		if (movement > 1) {
			attraction += 1;
			movement -= 2;
			System.out.println("고양이와 놀아줍니다");
			System.out.println("행동력이 2감소해서 " + movement + "가 되었습니다");
			System.out.println("고양이와 놀아 호감도가 증가해서 " + attraction + "이 되었습니다");
			System.out.println();
		} else {
			System.out.println("행동력이 부족합니다, 잠을 재우세요");
		}
	}

	// 호감도(15) 이상 부터 가능. 호감도 +3, 행동력 -3
	// 3. 산책하기
	void run() {// 고양이랑 산책하기
		if (movement > 1) {
			if (attraction >= 15) {
				System.out.println("고양이와 산책을 합니다");
				attraction += 3;
				movement -= 3;
				System.out.println("호감도 증가"+attraction+"이 됨");
			} else {
				System.out.println("호감도 15이상부터 가능합니다");
			}
		}else{
			System.out.println("행동력이 부족합니다. 잠을 재우세요");
		}
	}
	// 4. 부르기
	void call() { // 고양이 부르기
		System.out.println("안녕 내 이름은 "+name+"이라고 해.");
		System.out.println("너에 대한 내 애정도는 "+attraction+"이야.");
		System.out.println("나는 "+movement+"만큼 움직일 수 있어.");
		System.out.println();
	}
	// 5. 잠재우기
	void sleep() {
		System.out.println("고양이가 잠을 자서 행동력이 3증가합니다");
		movement += 3;
		System.out.println("현재 행동력은 "+movement+"입니다");
		System.out.println();
	}
	public static void main(String[] args) {
		Cat cat = new Cat(3, "cute_cat");
		do {
			System.out.println("고양이 키우기. ver0.1");
			System.out.println("아래 항목을 선택해 주세요 :");
			System.out.println("1.밥주기");
			System.out.println("2.놀아주기");
			System.out.println("3.산책하기");
			System.out.println("4.부르기");
			System.out.println("5.잠재우기");
			System.out.println("0.프로그램 종료");
			int choice;
			Scanner sc = new Scanner(System.in);
			choice = sc.nextInt(); // 메인 초기값 입력 받음
			switch (choice) {
			case 1: {
				cat.feed();
				break;
			}
			case 2: {
				cat.play();
				break;
			}
			case 3: {
				cat.run();
				break;
			}
			case 4: {
				cat.call();
				break;
			}
			case 5:{
				cat.sleep();
				break;
			}
			default: {
				System.out.println("고양이 키우기 프로그램 종료");
				System.exit(0);
				break;
			}
			}
		} while (true);
	}
}