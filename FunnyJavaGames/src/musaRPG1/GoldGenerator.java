package musaRPG1;

public class GoldGenerator implements Runnable {

	private int code;
	private int gold;
	private int duration;
	private int maxDuration;
	private String name;
	private String[] names = { "최하급 금광", "하급 금광", "중급 금광", "중상급 금광", "최상급 금광" };

	public GoldGenerator(int code) {
		this.code = code;
		this.gold = (int) (100 + code * 0.3);
		this.duration = 100;
		this.maxDuration = 100;
		this.name = names[code - 1];
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			gold += 10;
			System.out.println("골드를 10원 생산합니다");
		}
	}

	// getter, setter
	public int getCode() {
		return code;
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

	public String[] getNames() {
		return names;
	}

	public void setNames(String[] names) {
		this.names = names;
	}

}
