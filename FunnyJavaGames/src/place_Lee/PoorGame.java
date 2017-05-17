package place_Lee;

import java.io.*;
import java.util.*;
/* # 오늘의 과제 ( 5월 16일 ) 
 * 테마 : 거지 갑부 만들기 게임
 * - 게임을 시작하면 우선 거지의 이름을 정해준다. Input!
 * - 위에서 입력받은 이름을 가진 Person클래스를 만들어준다. 
 * - Person 클래스에 필요한 전역변수 String name(이름), int grade(등급), int money(소유자산)     --- 나머진 자유롭게 추가 가능
 * - Person 클래스를 상속받는 Poor, Civil, Nobless, King 클래스를 만들며 
 * 이때 각각의 grade는 1,2,3,4 순으로 지정한다.
 * - 플레이어는 Poor class 이며 플레이어가 단계를 높이기 위해선 
 * 나머지 Civil, Nobless, King 클래스 들과 가위바위보를 해서 이겨야 한다.
 * - 플레이어를 제외한 클래스들은 랜덤으로 가위바위보를 낸다.
 * - 이때 각각의 등급에 따른 grade 값은 가위바위보의 생명력이 된다. 
 * 예를 들어 (Poor)는 한번 지면 끝  King 은 4 목숨 이다.
 * 
 * - 플레이어는 꺾은 대상의 계급을 뺏어오고 뺏은 계급의 다음 계급에 도전 할 수 있게 되며, 
 * 도전에 실패 했을 경우 Poor에서 실패하면 게임오버
 * - 그 외의 등급에서 실패하면 등급 하락이다.
 */

public class PoorGame {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("그지의 이름을 지어주세요");
		String name = br.readLine();
		Person person = new Poor(name);
		person.showStat();
		boolean a = (person.grade == 0);
		do {
			System.out.println("무엇을 내겠습니까? 1.가위 2.바위 3.보");
			int myNum = Integer.parseInt(br.readLine());
			Cal cal = new Cal();
			cal.battle(myNum);
			cal.battleResult();
		} while (a);
	}
}

class Person {
	String name;
	int grade;
	int hp;
	int enemyHp;

	public Person() {
	}

	Person(String name) {
		this.name = name;
	}

	public void showStat() {
		System.out.printf("이름:%s 계급:%s, 체력:%s\n", name, grade, hp);
		System.out.println("적의 체력은 " + enemyHp);
	}
}

class Poor extends Person {
	Poor(String name) {
		super(name);
		grade = 1;
		hp = 1;
		enemyHp = 2;
	}

}

class Civil extends Person {
	Civil(String name) {
		super(name);
		int grade = 2;
		int hp = 2;
		enemyHp = 3;
	}

}

class Nobless extends Person {
	Nobless(String name) {
		super(name);
		int grade = 3;
		int hp = 3;
		enemyHp = 4;
	}

}

class King extends Person {
	King(String name) {
		super(name);
		int grade = 4;
		int hp = 4;
	}

}

// 1가위 2바위 3보
// 1가위 2바위 3보
class Cal extends Person {
	Person person = new Person();

	public void battle(int myNum) {
		Random r = new Random();

		int eneNum = r.nextInt(3);

		switch (myNum - (eneNum + 1)) {
		case 0:
			System.out.println("비겼습니다.");
			break;
		case 1:
		case -2:
			System.out.println("이겼습니다.");
			person.enemyHp -= 1;
			break;
		case -1:
		case 2:
			System.out.println("졌습니다.");
			person.hp -= 1;
			break;

		}
	}

	public void battleResult() {

		if (person.hp <= 0) {
			if (person.grade == 1)
				System.out.println("죽었습니다.");
			else {
				switch (person.grade) {
				case 2: {
					person.grade = 1;
					person.hp = 1;
				}
				case 3: {
					person.grade = 2;
					person.hp = 2;
				}
				case 4: {
					person.grade = 3;
					person.hp = 3;
				}
				}
			}
		} else {
			if (person.enemyHp <= 0) {
				switch (person.grade) {
				case 1: {
					System.out.println("시민으로 승급했습니다.");
					person.grade = 2;
					person.hp = 2;
					person.enemyHp = 3;
					break;
				}
				case 2: {
					System.out.println("귀족으로 승급했습니다.");
					person.grade = 3;
					person.hp = 3;
					person.enemyHp = 4;
					break;
				}
				case 3: {
					System.out.println("축하합니다. 왕이 되었습니다.");
					System.exit(0);
					break;
				}
				}
			} else {
				person.enemyHp -= 1;
			}

		}
		person.showStat();

	}

}