package threadStudy;

public class ToiletThread {
	public static void main(String[] args) {
		new ToiletThread();
	}
	
	public String userName;
	
	public ToiletThread() {
		new ToiletUser(this,"설현").start();
		new ToiletUser(this,"봉구").start();
		new ToiletUser(this,"수지").start();
	}
}
