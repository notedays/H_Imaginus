package musaRPG1;

public class GoldGenerator extends Thread {

	private int code;
	private int gold;
	private int maxGold;
	private int duration;
	private int maxDuration;
	private int time;
	private String name;
	static public String[] names = { "최하급 금광", "하급 금광", "중급 금광", "중상급 금광", "최상급 금광" };

	public GoldGenerator(int code) {
		this.code = code;
		this.gold = 0;
		this.maxGold = 300000;
		this.duration = 100;
		this.maxDuration = 100;
		this.name = names[code - 1];
		this.time = code * 3000;
	}

	public void run() {
		while (true) {
			try {
				gold += code;
				Thread.sleep(10 / code + 100);
				if (gold >= maxGold) {
					System.out.println("골드 광산이 꽉참");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
	}

	public void gatherMoney(Character character) {
		character.getMoney(gold);
		this.gold = 0;
	}

	// getter, setter

	public int getCode() {
		return code;
	}

	public int getMaxGold() {
		return maxGold;
	}

	public void setMaxGold(int maxGold) {
		this.maxGold = maxGold;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getMaxDuration() {
		return maxDuration;
	}

	public void setMaxDuration(int maxDuration) {
		this.maxDuration = maxDuration;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

}
