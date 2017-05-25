package threadStudy;

/* # Thread 스레드 : 스레드는 하나의 작업 컨베이어 벨트 같은 느낌?
 * - 생성 방법 : 	1) extends Thread
 * 			  	2) implements Runnalbe
 * 				3) new Thread();
 * 
 * - 반드시 run 메소드를 override 한 후 start()를 통해 호출
 * - 동기화 / 비동기화 중요 :
 * 		- 동기화 : 순서를 지키도록
 * 		- 비동기화 : 순서 상관없이
 */
public class ThreadStudy extends Thread{
	public static void main(String[] args) {
		new ThreadStudy();
	}
	
	boolean isUsing;
	String userName;
	
	public ThreadStudy() {
		start();
		
		while(true){
			System.out.println("울랄라");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void run() {
		while(true){
			System.out.println("");
		}
	}
}
