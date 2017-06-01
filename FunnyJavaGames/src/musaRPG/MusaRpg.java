package musaRPG;

import java.io.File;
import java.util.Scanner;

public class MusaRpg {
	public static void main(String[] args) {
		new MusaRpg();
	}
	// # 버전 변수
	static float version = 0.1f;
	
	// # View
	View view = new View();
	
	// # 캐릭터
	Character character;
	
	public MusaRpg() {
		System.out.println("===== Musa RPG ver."+version+" =====");
		
		// # 캐릭터 선택
		character = view.selectCharacter();
		
		String[] musics = {"muhyul_bgm.mp3","iljimae_bgm.mp3"}; 
		// # 배경 음악 재생
		new Thread(){
			public void run() {
				SoundPlayer.playBGM(new File("resources/"+musics[character.getCode()-1]));
			};
		}.start();

		// # 행동 선택
		int actionNo = -1;
		do{
			actionNo = view.selectAction(character);
			try {
				action(actionNo);
			} catch (Exception e) {
				
			}
		}while(actionNo <= view.actionNames.length );
		
		// # 프로그램 종료
		System.out.println("게임을 종료합니다.");
		System.exit(1);
	}
	
	// # 기본 행동
	private void action(int actionNo) throws Exception{
		switch (actionNo) {
		case ActionCode.BATTLE : // # 전투하기
			Enemy enemy = generateEnemy();
			int no = view.selectBattle(enemy);
			battle(no, enemy);
			break;
		}
	}
	
	// # 전투 관련 행동
	public void battle(int no, Enemy enemy) throws Exception{
		switch (no) {
		case ActionCode.NORMAL_ATTACK:{
			int enemyHp = enemy.getDamaged(character.getAttack());
			int characterHp = character.getDamaged(enemy.getAttack());
			
			if( characterHp == 0 ){
				if( view.die(character) ){
					throw new Exception();
				}
			}else if( enemyHp == 0 ){
				Item item = enemy.dropItem();
				character.battleWin(enemy.getExp(), item);
			}else{
			}
		}
		case ActionCode.SKILL:{
			break;
		}
		case ActionCode.DEFENSE:{
			break;
		}
		case ActionCode.AVOID:{
			break;
		}
		}
	}
	
	private Enemy generateEnemy(){
		return new Enemy(character.getLevel());
	}
}
