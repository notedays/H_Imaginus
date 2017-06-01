package itemTest;
public enum Character {

	Musa(1, 10, 10, new Inventory<Item>());
	
	int code;
	int hp;
	int mp;
	Inventory<Item> charInven;
	
	private Character(int code, int hp, int mp, Inventory<Item> inven){
		this.code = code;
		this.hp = hp;
		this.mp = mp;
		this.charInven = inven;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getMp() {
		return mp;
	}

	public void setMp(int mp) {
		this.mp = mp;
	}

	public Inventory<Item> getCharInven() {
		return charInven;
	}

	public void setCharInven(Inventory<Item> charInven) {
		this.charInven = charInven;
	}
}
