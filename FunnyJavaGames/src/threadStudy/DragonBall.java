package threadStudy;

public class DragonBall extends Thread{
	public static void main(String[] args) {
		new DragonBall();
	}
	
	int energy;
	boolean isAttacking;
	
	public DragonBall() {
		start();
		System.out.print("에너지 : ");
		while(true){
			try {
				if(!isAttacking){
					energy++;
					Thread.sleep(200);
					System.out.print(energy+" ");
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void run() {
		while(true){
			synchronized (this.getClass()) {
				if(energy >= 10){
					isAttacking = true;
					energy=0;
					String text = "에네르기 파";
					for (int i = 0; i < text.length(); i++) {
						try {
							Thread.sleep(1500);
							if( i==0) System.out.println();
							if (i!=4) System.out.print(text.charAt(i)+".....");
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					for (int i = 0; i < 200; i++) {
						System.out.print("))");
						try {
							Thread.sleep(15);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					
					isAttacking = false;
				}
			}
		}
	}
}
