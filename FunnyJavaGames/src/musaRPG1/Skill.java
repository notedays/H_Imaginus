package musaRPG1;

public enum Skill {
	// # charCode ( 0: 공통, 1: 무휼, 2: 일지매 )
	
	//기본 무사(000)
	KNIFE_THROW(000 ,0,"단검 던지기","무사들의 기본 기술로 단검을 던져 적을 공격한다.", 0, 6, 2),
	ONE_SLASH(001 ,0,"일단 베기","무사들의 기본 기술인 일단 베기.", 0, 7, 3),
	TWO_SLASH(002 ,0,"이단 베기","무사들의 기본 기술인 이단 베기.", 0, 8, 4),
	TRIPLE_SLASH(003 ,0,"삼단 베기","무사들의 기본 기술인 삼단 베기.", 0, 9, 5),
	
	//화염 계열
	//무휼 : 불꽃 무사(100)
	FIRE_ONE_SLASH(100, 1,"일단 불씨 베기","무휼이 어릴때 배운 불꽃 베기", 1, 10, 3),
	FIRE_TWO_SLASH(101, 1,"이단 불씨 베기","일단 불꽃 베기의 상위 기술", 2, 15, 4),
	FIRE_TRIPLE_SLASH(102, 1,"삼단 불씨 베기","이단 불꽃 베기의 상위 기술", 4, 20, 5),
	FIRE_BLAST(103, 1, "불씨 블래스트", "불의 무사 궁극기", 5, 30, 8),
	
	//무휼 : 화염 무사(200)
	FLAME_ONE_SLASH(200, 1,"일단 화염 베기","무휼이 어릴때 배운 화염 한단 베기", 11, 25, 6),
	FLAME_TWO_SLASH(201, 1,"이단 화염 베기","일단 화염 베기의 상위 기술", 12, 30, 7),
	FLAME_TRIPLE_SLASH(202, 1,"삼단 화염 베기","이단 화염 베기의 상위 기술", 13, 35, 8),
	FLAME_BLAST(203 , 1, "화염 블래스트", "화염 무사 궁극기", 15, 45, 10),
	
	//무휼 : 용암 무사(300) 
	LAVA_ONE_SLASH(300, 1,"일단 용암 베기","무휼이 어릴때 배운 용암 한단 베기", 1, 40, 9),
	LAVA_TWO_SLASH(301, 1,"이단 용암 베기","일단 용암 베기의 상위 기술", 1, 45, 10),
	LAVA_TRIPLE_SLASH(302, 1,"삼단 용암 베기","이단 용암 베기의 상위 기술", 1, 50, 11),
	LAVA_BLAST(303, 1, "용암 블래스트", "용암 무사 궁극기", 1, 60, 12),
	
	//얼음 계열
	//무휼 : 냉기 무사(400)
	CHILL_ONE_SLASH(400, 1,"일단 냉기 베기","차가운 냉기를 품은 일단일도", 1, 10, 3),
	CHILL_TWO_SLASH(401, 1,"이단 냉기 베기","일단 냉기 베기의 상위 기술", 2, 15, 4),
	CHILL_TRIPLE_SLASH(402, 1,"삼단 냉기 베기","이단 냉기 베기의 상위 기술", 4, 20, 5),
	CHILL_BLAST(403, 1, "냉기 블래스트", "냉기 무사 궁극기", 5, 30, 8),
	
	//무휼 : 얼음 무사(500)
	ICE_ONE_SLASH(500, 1,"일단 얼음 베기","차가운 얼음을 품은 일단일도", 11, 25, 6),
	ICE_TWO_SLASH(501, 1,"이단 얼음 베기","일단 얼음 베기의 상위 기술", 12, 30, 7),
	ICE_TRIPLE_SLASH(502, 1,"삼단 얼음 베기","이단 얼음 베기의 상위 기술", 13, 35, 8),
	ICE_BLAST(503, 1, "얼음 블래스트", "얼음 무사 궁극기", 15, 45, 10),
	
	//무휼 : 빙하 무사(600)
	GLACIER_ONE_SLASH(600, 1,"일단 빙하 베기","차가운 빙하를 품은 일단일도", 21, 40, 9),
	GLACIER_TWO_SLASH(601, 1,"이단 빙하 베기","일단 빙하 베기의 상위 기술", 22, 45, 10),
	GLACIER_TRIPLE_SLASH(602, 1,"삼단 빙하 베기","이단 빙하 베기의 상위 기술", 23, 50, 11),
	GLACIER_BLAST(603, 1, "빙하 블래스트", "빙하 무사 궁극기", 25, 60, 12);
	
	private final int code;
	private final int charCode;
	private final String name;
	private final String explanation;
	private final int levelLimit;
	public int damage;
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

	
	//	get, set 메소드 
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
	
	
	
	public void setDamage(int damage) {
		this.damage = damage;
	}


	public int getDamage() {
		return damage;
	}

	public int getConsumeChakura() {
		return consumeChakura;
	}
}
