package place_Share;

/* # 순발력 테스트 게임 : 당신의 손가락은 얼마나 빠르고 정확합니까?
 * - 최초 플레이 인원 수를 입력 받는다.
 * - 인원 수 만큼 Player 클래스 생성한다. (이때 Player 클래스는 String name, int point) 로 구성됨.
 * - 3초 2초 1초 카운트 다운이 되고 카운트가 0되는 타이밍에 아무 키나 입력을 한다. 해당 키 입력 시간이 얼마나 정확한 초에 근접했는지가 획득 포인트
 * - (단, 1000을 1초로 잡음.   예) 0.3초에 클릭했다면 차이인 300이 포인트로 얻어짐) ) 
 * - 플레이어별로 차례대로 돌아가며 총 5번의 기회가 주어지고 가장 높은 포인트를 얻은 플레이어의 승리
 * 
 * - 이중 배열 ( 플레이어 수, 게임 횟수 5회 ) 를 활용하여 게임이 실행되도록 코딩하면 더욱 Very Good!
 * - 값을 입력 받을 때 System.currentTimeMillis()를 이용하여 입력받은 시간을 체크하고 TimerUtil의 timeNow와 비교할 것!
 * 
 * ** 초의 카운트는 아래의 TimerUtil util 의 util.timerStart() 메소드를 통해서 할 것!
 */
public class SpeedGame {
	// # 타이머 클래스
	TimerUtil util = new TimerUtil();
	
	// # 최대 게임 수 5회
	static final int MAX_GAME_COUNT = 5;
	
	public static void main(String[] args) {
		new SpeedGame();
	}
	
	public SpeedGame() {
		util.timerStart();
	}
	
}

class SpeedPlayer{
	String name;
	int point;
}

//# 3초 카운트 해주며 마지막 1초 카운트의 시간 값을 저장하는 클래스
class TimerUtil{
	long timeNow;
	
	void timerStart(){
		new Runnable() {
			@Override
			public void run() {
				timeNow = System.currentTimeMillis();
				int countLimit = 3;
				
				while(true){
					long timeAfter = System.currentTimeMillis();
					if((timeAfter - timeNow) / 1000 >= 1){
						timeNow = timeAfter;
						System.out.println(countLimit+" 초!!!");
						countLimit--;
						
						// # 카운트가 1초일때 바로 타이머 종료
						if(countLimit < 1) {
							break;
						}
					}
				}
			}
		}.run();
	}
}

