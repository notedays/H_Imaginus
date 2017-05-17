package place_Lim;

//Unit 추상클래스 활용해
//이동, 멈춤, 메시지 보내라
//Marin//Siege Tank//DropShip 

abstract class Unit{		//추상클래스 선언
	int x, y;
	abstract void move(int x, int y);
	abstract void stop();
	abstract void message();
}

class Marin extends Unit{
	String name = "Marin";
	@Override
	void move(int x, int y){
		System.out.println(name+"은"+x+","+y+"로 이동합니다.");
	}
	void stop(){
		System.out.println(name+"이 행동을 멈춥니다");
	}
	void message(){
		System.out.println("my name is "+name);
	}
}
public class StarCraftEx {
	public static void main(String[] args) {
		Unit[] a = new Unit[2];
		a[0] = new Marin();
		a[0].move(1, 2);
	}
}
