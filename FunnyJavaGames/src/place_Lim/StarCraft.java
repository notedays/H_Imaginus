package place_Lim;

//이동, 멈춤, 메시지 보내라
//Marin//Siege Tank//DropShip

abstract class Unit { // 추상클래스선언
	int x, y;
	abstract void move(int x, int y);
	abstract void stop();
	abstract void message();
}

class Marin extends Unit {
	@Override
	void move(int x, int y){
		System.out.println("마린이 이동할 좌표는"+x+y+"입니다");
	}
	void stop() {
		System.out.println("마린이 멈춥니다");
	}
	void message(){
		System.out.println("마린이다 내가");
	}
}

class SiegeTank extends Unit{
	@Override
	void move(int x, int y){
		System.out.println("시즈탱크가 이동할 좌표는"+x+y+"입니다.");
	}
	void stop(){
		System.out.println("시즈탱크 멈춥니다");
	}
	void message(){
		System.out.println("내가 시즈탱크");
	}
}

public class StarCraft{
	public static void main(String[] args) {
		Unit[] ss = new Unit[2];
		ss[0] = new Marin();
		ss[1] = new SiegeTank();
		for(int i=0; i<ss.length; i++){
			ss[i].move(5,5);
		}
	}
}