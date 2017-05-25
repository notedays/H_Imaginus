package threadStudy;

public class ToiletUser extends Thread{
	
	ToiletThread toilet;
	String name;
	
	public ToiletUser(ToiletThread toilet, String name) {
		this.toilet = toilet;
		this.name = name;
	}
	
	@Override
	public void run() {
		while(true){
			try {
				synchronized (toilet) {
					toilet.userName = name;
					System.out.println(toilet.userName+" 화장실 입장...!!");
					System.out.println(toilet.userName+" 화장실 퇴장...!!\n");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
