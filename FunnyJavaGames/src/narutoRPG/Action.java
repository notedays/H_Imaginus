package narutoRPG;

// # 나루토 게임의 행동 관련 된 작업을 할 클래스
public class Action {
	
	// # 행동 코드
	public static final int BATTLE = 1;
	public static final int SHOW_INFO = 2;
	public static final int ITEM_MARKET = 3;
	public static final int SKILL_LEARN = 4;
	
	// # 싱글 톤
	private static Action action = new Action();
	private Action() {}
	
	public static Action getInstance(){
		return action;
	};
	
	// # 캐릭터 설정하기
	Character character;
	public void initialize(Character character){
		this.character = character;
	}
	
	public void battle(){
		
	}
}
