package SalesManagement;

public class SalesMain {
	SalesInterface sales = new SalesImpl();

	public static void main(String[] args) {

		new SalesMain();
	}
	
	public SalesMain(){
		
		sales.showInterface1();
		
	}

}
