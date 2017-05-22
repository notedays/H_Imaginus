package place_Share.BeansPractice;

public class HunterImpl implements Hunter{

	private String name;
	private int speechLevel;
	private int huntCount;
	
	public HunterImpl(String name, int speechLevel) {
		this.name = name;
		this.speechLevel = speechLevel;
	}
	
	@Override
	public boolean hunt(Woman woman) {
		huntCount++;
		if(speechLevel * huntCount > woman.getAttractive() / 10){
			return true;
		}
		return false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSpeechLevel() {
		return speechLevel;
	}

	public void setSpeechLevel(int speechLevel) {
		this.speechLevel = speechLevel;
	}

	public int getHuntCount() {
		return huntCount;
	}

	public void setHuntCount(int huntCount) {
		this.huntCount = huntCount;
	}
	
	
	
}
