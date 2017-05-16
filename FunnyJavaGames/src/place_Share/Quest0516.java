package place_Share;


/* # 오늘의 과제 ( 5월 16일 ) 
 * 테마 : 거지 갑부 만들기 게임
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

public class Quest0516 {
	
}

class Person {
	String name;
	int grade;
	int money;
}