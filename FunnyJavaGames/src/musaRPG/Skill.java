package musaRPG;

public enum Skill {
	// # charCode ( 0: 공통, 1: 무휼, 2: 일지매 )
	KNIFE_THROW(1,0,"단검 던지기","무사들의 기본 기술로 단검을 던져 적을 공격한다.",5,15,5);
	
	private final int code;
	private final int charCode;
	private final String name;
	private final String explanation;
	private final int levelLimit;
	private final int damage;
	private final int consumeChakura;
	
	private Skill(int code, int charCode, String name, String explanation, int levelLimit, int damage, int consumeChakura) {
		this.code = code;
		this.charCode = charCode;
		this.name = name;
		this.explanation = explanation;
		this.levelLimit = levelLimit;
		this.damage = damage;
		this.consumeChakura = consumeChakura;
	}

	public int getCode() {
		return code;
	}

	public int getCharCode() {
		return charCode;
	}

	public String getName() {
		return name;
	}

	public String getExplanation() {
		return explanation;
	}

	public int getLevelLimit() {
		return levelLimit;
	}

	public int getDamage() {
		return damage;
	}

	public int getConsumeChakura() {
		return consumeChakura;
	}
}
