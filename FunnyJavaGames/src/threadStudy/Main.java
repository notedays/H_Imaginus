package threadStudy;

public class Main {
	public static void main(String[] args) {
		new Main();
	}
	
	int money = 500;
	
	public Main() {
		Thread[] threads = new Thread[3];
		String[] names = {"일동","이동","삼동"};
		for (int i = 0; i < threads.length; i++) {
			String name = names[i];
			threads[i] = new Thread(){

				@Override
				public void run() {
					while(true){
						synchronized (this.getClass()) {
							money = money -1;
							System.out.println(name+"이의 현재 금액 : "+ money);
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							if(money < 1){
								break;
							}
						}
					}
				}
			};
//			threads[i].start();
		}
	}
	
	
}
