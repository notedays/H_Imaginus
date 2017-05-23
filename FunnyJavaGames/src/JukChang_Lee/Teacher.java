package JukChang_Lee;
import java.util.*;
public class Teacher implements Danger {

	private int hp=10;
	private int speed;
	
	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	@Override
	public boolean danger(int speed) {
		if(speed > 50)
			return true;
		else
			return false;
					
	}

}
