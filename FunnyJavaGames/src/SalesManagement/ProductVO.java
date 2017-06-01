package SalesManagement;

public class ProductVO {

	private String pname; // 상품명
	
	private int price, quantity,code; // 단가, 수량
	
	
	
	
	public ProductVO() {

	}
	
	public ProductVO(int code, String pname, int price, int quantity) {
		this.code = code;
		this.pname = pname;
		this.price = price;
		this.quantity = quantity;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}

	@Override
	public String toString() {
		String s = String.format(" 상품코드:%d 상품명:%s 단가:%d 수량:%d",
				code,pname,price,quantity);
		return s;
		
	}
}
