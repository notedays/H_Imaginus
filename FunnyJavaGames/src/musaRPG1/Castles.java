package musaRPG1;

public enum Castles {
	// 주요 성(100~199) 
	JOENJUSUNG(100, "전주성", "교통의 요지, 전주를 방어하는 성", 50, 100, 20, 1),
	DONGRAESUNG(101, "동래성", "해상교역의 중심, 부산을 방어하는 성", 50, 100, 20, 1),
	
	// 주요 마을 거점(200~299)
	MASAN(200, "동래성", "해상교역의 중심, 부산을 방어하는 성", 50, 100, 20, 1),
	DAGUE(201, "동래성", "해상교역의 중심, 부산을 방어하는 성", 50, 100, 20, 1);
	
	private int code;
	private String name;
	private String explanation;
	private int attack;
	private int defense;
	private int accomodate;	//병사 수용가능한 숫자
	private int value; 
	
	private Castles(int code, String name, String explanation, int attack, int defense, int accomodate, int value){
		this.code = code;
		this.name = name;
		this.explanation = explanation;
		this.attack = attack;
		this.defense = defense;
		this.accomodate = accomodate;
		this.value = value;
	}

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

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
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

	public int getAccomodate() {
		return accomodate;
	}

	public void setAccomodate(int accomodate) {
		this.accomodate = accomodate;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	
	
}
