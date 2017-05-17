package place_Lim;

import java.util.Random;
import java.util.Scanner;

/* # 오늘의 과제 ( 5월 16일 ) 
 * 테마 : 거지 갑부 만들기 게임
 * - 게임을 시작하면 우선 거지의 이름을 정해준다. Input!
 * - 위에서 입력받은 이름을 가진 Person클래스를 만들어준다. 
 * - Person 클래스에 필요한 전역변수 String name(이름), int grade(등급), int money(소유자산)     --- 나머진 자유롭게 추가 가능
 * - Person 클래스를 상속받는 Poor, Civil, Nobless, King 클래스를 만들며 이때 각각의 grade는 1,2,3,4 순으로 지정한다.
 * - 플레이어는 Poor class 이며 플레이어가 단계를 높이기 위해선 나머지 Civil, Nobless, King 클래스 들과 가위바위보를 해서 이겨야 한다.
 * - 플레이어를 제외한 클래스들은 랜덤으로 가위바위보를 낸다.
 * - 이때 각각의 등급에 따른 grade 값은 가위바위보의 생명력이 된다. 예를 들어 (Poor)는 한번 지면 끝  King 은 4 목숨 이다.
 * 
 * - 플레이어는 꺾은 대상의 계급을 뺏어오고 뺏은 계급의 다음 계급에 도전 할 수 있게 되며, 도전에 실패 했을 경우 Poor에서 실패하면 게임오버
 * - 그 외의 등급에서 실패하면 등급 하락이다.
 */
public class Quest0516 {
	public static void main(String[] args) {

		int choice;
		Person abc = new Person("임주현", 2008111196);
		System.out.println("***king battle game***");
		do {
			System.out.println("항목을 선택해 주세요 :");
			System.out.println("1. 전투하기");
			System.out.println("2. 종료하기");
			Scanner ss = new Scanner(System.in);
			choice = ss.nextInt();
			if (choice == 1) {
				abc.battle();
			} else {
				System.out.println("게임을 종료합니다");
				System.exit(0);
			}
		} while (choice != 2);
	}
}

class Person {
	String name;
	String[] gradeType = { "Poor", "Civil", "Nobless", "King" };
	int id;
	int grade = 1;
	int money = 500;
	int hp = 1;
	int weapon; // 내가 내는 가위바위보
	int weapon1; // 상대방이 내는 가위바위보

	public Person(String name, int id) {
		this.name = name;
		this.id = id;
	}

	void battle() { // 전투를 한다.
		System.out.println("battle starts!!");
		Random rando = new Random();
		weapon1 = rando.nextInt(3);
		switch (grade) {
		case 1:
			Scanner sc = new Scanner(System.in);
			System.out.println("가위, 바위, 보 중 무엇을 내겠습니까? :");
			String choice = sc.next();
			if (choice == "가위") {
				weapon = 0;
			} else if (choice == "바위") {
				weapon = 1;
			} else {
				weapon = 2;
			}
			if (weapon < weapon1) {
				System.out.println("상대방에게 패배했습니다.");
				if (grade == 1) {
					System.out.println("거지 캐릭터가 사망했습니다");
				} else {
					grade -= 1;
					money -= 5000;
				}
			} else if (weapon == weapon1) {
				System.out.println("다시한번 가위바위보를 합니다");
				System.out.println();
				battle();
			} else {
				grade += 1;
				money += 5000;
				hp += 1;
				System.out.println("상대방에게 이겼습니다.");
				System.out.println("계급이 한단계 상승합니다");
				System.out.println("현재 HP는 " + hp + "입니다");
				System.out.println("현재 Money는 " + money + "입니다");
				System.out.println("현재 계급은 " + gradeType[grade - 1] + "입니다");
			}
			break;
		case 2:
			Scanner sc2 = new Scanner(System.in);
			System.out.println("가위, 바위, 보 중 무엇을 내겠습니까? :");
			String choice2 = sc2.next();
			if (choice2 == "가위") {
				weapon = 0;
			} else if (choice2 == "바위") {
				weapon = 1;
			} else {
				weapon = 2;
			}
			if (weapon < weapon1) {
				System.out.println("상대방에게 패배했습니다.");
				if (grade == 1) {
					System.out.println("거지 캐릭터가 사망했습니다");
				} else {
					grade -= 1;
					money -= 5000;
				}
			} else if (weapon == weapon1) {
				System.out.println("다시한번 가위바위보를 합니다");
				battle();
			} else {
				grade += 1;
				money += 5000;
				hp += 1;
				System.out.println("상대방에게 이겼습니다.");
				System.out.println("계급이 한단계 상승합니다");
				System.out.println("현재 HP는 " + hp + "입니다");
				System.out.println("현재 Money는 " + money + "입니다");
				System.out.println("현재 계급은 " + gradeType[grade - 1] + "입니다");
				System.out.println();
			}
			break;
		case 3:
			Scanner sc3 = new Scanner(System.in);
			System.out.println("가위, 바위, 보 중 무엇을 내겠습니까? :");
			String choice3 = sc3.next();
			if (choice3 == "가위") {
				weapon = 0;
			} else if (choice3 == "바위") {
				weapon = 1;
			} else {
				weapon = 2;
			}
			if (weapon < weapon1) {
				System.out.println("상대방에게 패배했습니다.");
				if (grade == 1) {
					System.out.println("거지 캐릭터가 사망했습니다");
				} else {
					grade -= 1;
					money -= 5000;
				}
			} else if (weapon == weapon1) {
				System.out.println("다시한번 가위바위보를 합니다");
				battle();
			} else {
				grade += 1;
				money += 5000;
				hp += 1;
				System.out.println("상대방에게 이겼습니다.");
				System.out.println("계급이 한단계 상승합니다");
				System.out.println("현재 HP는 " + hp + "입니다");
				System.out.println("현재 Money는 " + money + "입니다");
				System.out.println("현재 계급은 " + gradeType[grade - 1] + "입니다");
				if(grade >3){
					grade -=1;
				}
			}
			break;
		default :
			break;
		}
	} // person 클래스 종료

	
	class Poor extends Person {
		public Poor(String name, int id) {
			super(name, id);
			this.grade = 1;
			this.hp = grade;
			this.money = 500;
		}
	}

	class Civil extends Person {
		public Civil(String name, int id) {
			super(name, id);
			this.grade = 2;
			this.hp = grade;
			this.money = 10000;
		}
	}

	class Nobless extends Person {
		public Nobless(String name, int id) {
			super(name, id);
			this.grade = 3;
			this.hp = grade;
			this.money = 1000000;
		}
	}

	class King extends Person {
		public King(String name, int id) {
			super(name, id);
			this.grade = 4;
			this.hp = grade;
			this.money = 100000000;
		}
	}
}
