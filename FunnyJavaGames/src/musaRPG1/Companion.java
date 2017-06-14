package musaRPG1;

public class Companion {
	
	private int code;
	private String name;
	private int attack;
	private int defense;
	private int hp;
	private int maxHp;
	private String explanation;
	private int numberOfUnit;
	private int demandMoney;
	private int grade;
	int[] codes = {1, 2, 3};
	
	static public final int 궁사 = 1;
	static public final int 보병 = 2;
	static public final int 공성차 = 3;
	
	static String[] names = {"궁사", "보병","공성차"};
	String [] explanations = {"대 지상 상대로 강한 궁사", "대 궁사 상대로 강한 보병", "공성에 능한 전차"};
	static int [] demandMoneys = { 500, 300, 1000 };
	
	public Companion(int code, int level, int number) {
		this.code = code;
		this.name = names[code-1];
		this.attack = level*2+5;
		this.defense = level*2+5;
		this.hp = level*2+50;
		this.maxHp = level*2+50;
		this.explanation = explanations[code-1];
		this.numberOfUnit = number;
		this.demandMoney = demandMoneys[code-1];
		this.grade = level;
	}
	// 추가 메소드
	public int damageHp(int damage){
		if(hp >= damage){
			hp -= damage;
		}
		return hp;
	}
	
	////getter, setter
	
	
	public int getCode() {
		return code;
	}

	public int getDemandMoney() {
		return demandMoney;
	}

	public void setDemandMoney(int demandMoney) {
		this.demandMoney = demandMoney;
	}

	public int getNumberOfUnit() {
		return numberOfUnit;
	}

	public void setNumberOfUnit(int numberOfUnit) {
		this.numberOfUnit = numberOfUnit;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getMaxHp() {
		return maxHp;
	}

	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	public int[] getCodes() {
		return codes;
	}

	public void setCodes(int[] codes) {
		this.codes = codes;
	}

	public String[] getNames() {
		return names;
	}

	public void setNames(String[] names) {
		this.names = names;
	}

	public String[] getExplanations() {
		return explanations;
	}

	public void setExplanations(String[] explanations) {
		this.explanations = explanations;
	}


}
