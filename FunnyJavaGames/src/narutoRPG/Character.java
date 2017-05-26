package narutoRPG;

import java.util.HashMap;
import java.util.Map;

public enum Character {
	
	NARUTO(1,"나루토", 20,20, 10,10, new Inventory<Item>(),new HashMap<String,Integer>()),
	SASUKE(2,"사스케", 20,20, 10,10, new Inventory<Item>(),new HashMap<String,Integer>());
	
	private final int no;
	private final String name;
	private int hp;
	private int maxHp;
	private int chakura;
	private int maxChakura;
	
	private final Inventory<Item> inventory;
	private final Map<String,Integer> skillMap;
	
	private Character(int no, String name, int hp, int maxHp, int chakura, int maxChakura, Inventory<Item> inventory, Map<String, Integer> skillMap) {
		this.no = no;
		this.name = name;
		this.hp = hp;
		this.maxHp = maxHp;
		this.chakura = chakura;
		this.maxChakura = maxChakura;
		this.inventory = inventory;
		this.skillMap = skillMap;
	}

	public int getNo() {
		return no;
	}

	public String getName() {
		return name;
	}

	public Inventory<Item> getInventory() {
		return inventory;
	}

	public Map<String, Integer> getSkillMap() {
		return skillMap;
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
	
	
}
