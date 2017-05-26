package narutoRPG;

import java.util.HashMap;
import java.util.Map;

public enum Enemy {
	
	SHINOBI(1,"시노비","기본 닌자", 5,5, 5,5, new HashMap<String,Integer>());
	
	private final int no;
	private final String name;
	private final String title;

	private int hp;
	private int maxHp;
	private int chakura;
	private int maxChakura;
	
	private final Map<String,Integer> skillMap;

	private Enemy(int no, String name, String title, int hp, int maxHp, int chakura, int maxChakura,
			Map<String, Integer> skillMap) {
		this.no = no;
		this.name = name;
		this.title = title;
		this.hp = hp;
		this.maxHp = maxHp;
		this.chakura = chakura;
		this.maxChakura = maxChakura;
		this.skillMap = skillMap;
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

	public int getChakura() {
		return chakura;
	}

	public void setChakura(int chakura) {
		this.chakura = chakura;
	}

	public int getMaxChakura() {
		return maxChakura;
	}

	public void setMaxChakura(int maxChakura) {
		this.maxChakura = maxChakura;
	}

	public int getNo() {
		return no;
	}

	public String getName() {
		return name;
	}

	public String getTitle() {
		return title;
	}

	public Map<String, Integer> getSkillMap() {
		return skillMap;
	}
	
	
	
}
