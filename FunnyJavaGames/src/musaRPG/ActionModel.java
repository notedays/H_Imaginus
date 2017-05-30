package musaRPG;

// # 나루토 게임의 행동 관련 된 작업을 할 클래스
public class ActionModel {
	
	// # 행동 코드
	public static final int BATTLE = 1;
	public static final int SHOW_INFO = 2;
	public static final int ITEM_MARKET = 3;
	public static final int SKILL_LEARN = 4;
	
	// # 전투 코드
	public static final int NORMAL_ATTACK = 1;
	public static final int SKILL = 2;
	public static final int DEFENSE = 3;
	public static final int AVOID = 4;
	
	// # 싱글 톤
	private static ActionModel action = new ActionModel();
	private ActionModel() {}
	
	public static ActionModel getInstance(){
		return action;
	};
	
	// # 캐릭터 설정하기
	Character character;
	public void initialize(Character character){
		this.character = character;
	}
	
	public Enemy generateEnemy(){
		Enemy[] enemyArray = Enemy.values();
		return character.getLevel() <= enemyArray.length ? enemyArray[character.getLevel()-1] : enemyArray[enemyArray.length-1];
	}
	
	public void battle(int no, Enemy enemy){
		switch (no) {
		case NORMAL_ATTACK:{
			break;
		}
		case SKILL:{
			break;
		}
		case DEFENSE:{
			break;
		}
		case AVOID:{
			break;
		}
		}
	}
}
