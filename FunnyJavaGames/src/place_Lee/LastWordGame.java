package place_Lee;

import java.util.*;

/*	# 끝말 잇기 게임
 *  - 친구들과 함께 할 수 있도록 게임 시작 시 플레이 인원을 입력받고 해당 인원 수 만큼 Player 클래스 생성하기
 *  - Player 클래스에는 String name, int point 가 들어감.
 *  - LastWordGame 클래스 내에는 String lastWord, int gameCount 가 들어감.
 */

public class LastWordGame {
	String lastWord;
	int gameCount;

	Scanner scan = new Scanner(System.in);
	Player[] player;

	public static void main(String[] args) {
		LastWordGame lwg = new LastWordGame();
		lwg.set();

	}

	public void set() {
		System.out.println("게임 참가자는 몇명?");
		int member = scan.nextInt();
		player = new Player[member];
		for (int i = 0; i < member; i++) {
			System.out.println((i + 1) + "번째 참가자 이름은?");
			String name = scan.next();
			player[i] = new Player(name);
		}

	}
	
	public void play(){
		for(int i = 0; i<player.length;i++){
			System.out.println((i+1)+"번째 참가자 단어:");
			String word1 = scan.next();
			System.out.println(word1);
		}
	}

}

class Player {
	String name;
	int point;

	public Player(String name) {
		this.name = name;
	}
}