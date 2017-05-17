package place_Jeong;

import java.util.Scanner;

/* # 오늘의 과제 ( 5월 16일 ) 
 * 테마 : 거지 왕 만들기 게임
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

public class KingMaker {
	public static void main(String[] args) {
		new KingMaker();
	}
	
	Scanner scan = new Scanner(System.in);
	String[] grades = {"거지","시민","귀족","왕"};
	String[] rockPaperScissors = {"가위","바위","보"};
	Person player;
	
	
	public KingMaker() {
		System.out.print("플레이어 이름 : ");
		String name = scan.next();
		player = new Poor(name);
		System.out.println("\n왕 만들기 게임을 시작합니다...");
		play();
	}
	
	void play(){
		while(true){
			System.out.println("\n*~~~ 현재 "+player.name+" 님의 계급은 "+grades[player.grade - 1]+" 입니다. ~~~*");
			if(player.grade < 4){
				System.out.println("다음 계급인 "+grades[player.grade]+"을 만났습니다!!!");
				Person oponent = getGrade(grades[player.grade], player.grade+1);
				battle(oponent);
			}else{
				System.out.println("어려운 역경을 모두 이겨내고 드디어 왕이 되었습니다!! 축하드립니다!!!");
			}
		}
	}
	
	void battle(Person oponent){
		do{	
			// @ 3초 카운트
			System.out.print("\n카운트 시작 !!   ");
			for (int i = 3; i > 0; i--) {
				System.out.print(i+"..");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println();
			
			// # 적이 낸 가위 or 바위 or 보 랜덤
			int oponentIdx = (int) (Math.random() * 3);
			
			// # 플레이어가 낸 가위 or 바위 or 보
			System.out.print("무엇을 내시겠습니까? [가위/바위/보] : ");
			String playerRPS = scan.next();
			int playerIdx = -1;
			for (int i = 0; i < rockPaperScissors.length; i++) {
				if( rockPaperScissors[i].equals(playerRPS) ) playerIdx = i;
			}
			
			System.out.println("상대 : "+rockPaperScissors[oponentIdx] +" / "+player.name+" : "+rockPaperScissors[playerIdx]);
			if(oponentIdx == playerIdx){
				// # 같은 것을 냈을 경우 그냥 반복
				System.out.println("상대와 "+player.name+" 이 서로 같은 것을 내서 비겼습니다.\n다시 가위바위보를 시작합니다.");
				continue;
			}else{
				// # 다른 것을 냈을 경우
				boolean isPlayerWin = false;
				if(oponentIdx < playerIdx && !(oponentIdx == 0 && playerIdx == 2)){
					isPlayerWin = true;
				}else if(oponentIdx > playerIdx && (oponentIdx == 2 && playerIdx == 0)){
					isPlayerWin = true;
				}
				
				boolean isAlive;
				if( isPlayerWin ){
					System.out.println(player.name+" 님이 승리했습니다.");
					isAlive = oponent.lose();

					if(!isAlive) {
						System.out.println("다음 계급으로 업그레이드 합니다");
						upgrade();
						break;
					}
				}else{
					System.out.println("상대가 승리했습니다.");
					isAlive = player.lose();
					
					if(!isAlive) {
						System.out.println("계급이 하락합니다.");
						downgrade();
						break;
					}
				}
			}
		}while(true);
	}
	
	Person getGrade(String name, int grade){
		Person person;
		switch (grade) {
		case 1:  
			person = new Poor(name); break;
		case 2: // 시민 
			person = new Civil(name); break;
		case 3: // 귀족
			person = new Nobless(name); break;
		case 4: // 귀족 -> 왕
			person = new King(name); break;
		default : 
			person = new Person(name,0);
		}
		return person;
	}
	
	void upgrade(){
		player = getGrade(player.name, player.grade + 1);
	}
	
	void downgrade(){
		player = getGrade(player.name, player.grade -1);
		if(player.grade == 0){
			System.out.println(player.name+"은 결국 신분 세탁을 하지 못하고... 영원히 농노의 삶을 살게 되었습니다.... \n게임 오버");
			System.exit(1);
		}
	}
}

class Person {
	String name;
	int grade;
	int fame;
	
	public Person(String name, int grade) {
		if(name == null) name = "상대";
		this.name = name;
		this.grade = grade;
		this.fame = grade;
	}
	
	boolean lose(){
		fame--;
		if( fame < 1 ){
			System.out.println(name+" 의 명성이 다 떨어졌습니다.");
			return false;
		}else{
			System.out.println(name+" 의 남은 명성은  "+fame+" 입니다");
			return true;
		}
	}
}

// # 거지 클래스 - 계급은 1
class Poor extends Person{
	
	public Poor(String name) {
		super(name,1);
	}
}
// # 시민 클래스 - 계급은 2
class Civil extends Person{
	
	public Civil(String name) {
		super(name,2);
	}
}
// # 귀족 클래스 - 계급은 3
class Nobless extends Person{
	
	public Nobless(String name) {
		super(name,3);
	}
}
// # 왕 클래스 - 계급은 4
class King extends Person{
	
	public King(String name) {
		super(name,4);
	}
}
