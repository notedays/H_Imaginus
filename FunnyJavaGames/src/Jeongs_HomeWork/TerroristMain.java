package Jeongs_HomeWork;

public class TerroristMain {

	Bomb bomb;
	Building building;

	public TerroristMain() {
		int buildingCount = Building.nameList.size();
		for (int i = 0; i < buildingCount; i++) {
			bomb = new Bomb(i);
			building = new Building(i);

			do {
				System.out.println(bomb.getName()+"으로 "+building.getName()+" 터뜨리는 중...");
				building.setDuration(building.getDuration() - bomb.getPower());
			} while ( building.getDuration() > 0 );
		}
	}

	public static void main(String[] args) {
		new TerroristMain();
	}
}
