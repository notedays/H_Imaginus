package place_Share.BeansPractice;

public interface Hunter {
	static final int RUNNING_SPEED = 10;
	
	boolean hunt(Woman woman); // # 성공 여부를 알려주기 위해 boolean return
}
