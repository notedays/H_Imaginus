package musaRPG1;

public class Companion {
	private int code;
	private int attack;
	private int defense;
	private int hp;
	private int maxHp;
	private int volume;
	private int demandMoney;

	private String explanation;
	private String name;

	int[] codes = { 1, 2, 3 };

	static public final int ARCHOR = 1;
	static public final int SOLDIER = 2;
	static public final int SIEGER = 3;

	static String[] names = { "궁사", "보병", "공성차" };
	String[] explanations = { "대 지상 상대로 강한 궁사", "대 궁사 상대로 강한 보병", "공성에 능한 전차" };
	static int[] demandMoneys = { 500, 300, 1000 };

	public Companion(int code, int level) {
		this.code = code;
		this.attack = level * 5;
		this.defense = level * 5;
		this.hp = 1;
		this.maxHp = 1;
		this.volume = 0;
		this.demandMoney = demandMoneys[code - 1];
		this.explanation = explanations[code - 1];
		this.name = names[code - 1];
	}

	// 추가 메소드

	public void minusAmount(int inputVolume) {
		if (volume - inputVolume <= 0) {
			this.volume = 0;
			System.out.println("배치 후 "+this.name +"의 수는 0입니다");
			
		} else {
			this.volume -= inputVolume;
			System.out.println("병사가 " + inputVolume + "만큼 감소 했습니다");
			System.out.println("남은 병사의 수는 " + volume + " 입니다");
		}
	}

	public void addAmount(int volume) {
		this.volume = this.volume + volume;
	}

	public void getDamage(int damage) {
		if (volume - damage <= 0) {
			this.volume = 0;
			System.out.println(this.name + "병사가 전멸했습니다");
		} else {
			this.volume -= damage;
			System.out.println("병사가 " + damage + "만큼 데미지를 입었습니다");
			System.out.println("남은 병사의 수는 " + volume + " 입니다");
		}
	}

	public int getAmount() {
		return volume;
	}

	//// getter, setter
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getAttack() {
		return attack * this.volume;
	}

	public int getDefense() {
		return defense * this.volume;
	}

	public int getHp() {
		return hp * this.volume;
	}

	public int getMaxHp() {
		return maxHp * this.volume;
	}

	public int getVolume() {
		return volume;
	}

	public int getDemandMoney() {
		return demandMoney;
	}

	public String getExplanation() {
		return explanation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
