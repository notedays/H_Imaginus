package musaRPG;

import java.util.ArrayList;
import java.util.List;

public enum Enemy {
	
	CRAZY_DOG(1,"미친 개","미쳐버린 개", 5,5, 5,5, new ArrayList<Skill>());
	
	private final int code;
	private final String name;
	private final String title;
	
	private int hp;
	private int maxHp;
	private int mp;
	private int maxMp;
	
	private final List<Skill> skillList;
	
	private Enemy(int code, String name, String title, int hp, int maxHp, int mp, int maxMp,
			List<Skill> skillList) {
		this.code = code;
		this.name = name;
		this.title = title;
		this.hp = hp;
		this.maxHp = maxHp;
		this.mp = mp;
		this.maxMp = maxMp;
		this.skillList = skillList;
	}
	
	// # Getter / Setter ============================================================
	
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

	public int getMp() {
		return mp;
	}

	public void setMp(int mp) {
		this.mp = mp;
	}

	public int getMaxMp() {
		return maxMp;
	}

	public void setMaxMp(int maxMp) {
		this.maxMp = maxMp;
	}

	public int getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public String getTitle() {
		return title;
	}

	public List<Skill> getSkillList() {
		return skillList;
	}
}
