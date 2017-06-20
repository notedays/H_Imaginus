package musaRPG1;

public class FoodGenerator extends Thread{
		private int code;
		private int food;
		private int maxFood;
		private int duration;
		private int maxDuration;
		private int time;
		private int price;
		private String name;
		
		static public String[] names = { "최하급 농장", "하급 농장", "중급 농장", "중상급 농장", "최상급 농장" };
		static public int[] prices = { 1000, 10000, 100000, 500000, 700000};
		
		public FoodGenerator(int code) {
			this.code = code;
			this.food = 0;
			this.maxFood = 3000000;
			this.duration = 100;
			this.maxDuration = 100;
			this.name = names[code - 1];
			this.time = code * 3000;
			this.price = prices[code-1];
		}

		public void run() {
			while (true) {
				try {
					food += code;
					Thread.sleep(1000 / code + 100);
					if (food >= maxFood) {
						System.out.println("농장 작물이 꽉참");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} 
		}
		
		
		//	추가 메소드
		public void gatherFood(Character character) {
			character.getFood(food);
			this.food = 0;
			System.out.println("음식을 수확했습니다");
		}
		
		//	getter, setter
		
		
		public int getCode() {
			return code;
		}

		public void setCode(int code) {
			this.code = code;
		}

		public int getFood() {
			return food;
		}

		public void setFood(int food) {
			this.food = food;
		}

		public int getMaxFood() {
			return maxFood;
		}

		public void setMaxFood(int maxFood) {
			this.maxFood = maxFood;
		}

		public int getDuration() {
			return duration;
		}

		public void setDuration(int duration) {
			this.duration = duration;
		}

		public int getMaxDuration() {
			return maxDuration;
		}

		public void setMaxDuration(int maxDuration) {
			this.maxDuration = maxDuration;
		}

		public int getTime() {
			return time;
		}

		public void setTime(int time) {
			this.time = time;
		}

		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}

}
