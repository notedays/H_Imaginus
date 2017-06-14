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
	
	int[] codes = {1, 2, 3};
	static String[] names = {"궁사", "보병", "기병"};
	String [] explanations = {"대 지상 상대로 강한 궁사", "대 궁사 상대로 강한 보병", "대 보병 상대로 강한 기병"};
	
	public Companion(int code, int level) {
		this.code = code;
		this.name = names[code-1];
		this.attack = +1;
		this.defense = code+1;
		this.hp = code*5;
		this.maxHp = code*50;
		this.explanation = explanations[code-1];
		this.numberOfUnit = level;
	}
	
	
	////getter, setter
	
	
	public int getCode() {
		return code;
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

	public int getNumberOfUnit() {
		return numberOfUnit;
	}

	public void setNumberOfUnit(int numberOfUnit) {
		this.numberOfUnit = numberOfUnit;
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
