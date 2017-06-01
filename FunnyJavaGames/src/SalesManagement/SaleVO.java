package SalesManagement;

public class SaleVO {

	private String sname; // 고객명

	private String created; // 판매일

	private ProductVO ProductSale; // 판매내역


	
	
	public SaleVO(String sname, String created, ProductVO productSale) {
		super();
		this.sname = sname;
		this.created = created;
		ProductSale = productSale;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public ProductVO getProductSale() {
		return ProductSale;
	}

	public void setProductSale(ProductVO productSale) {
		ProductSale = productSale;
	}

	@Override
	public String toString() {
		return "구매자:"+sname+" 구매날짜:"+created+ProductSale;
	}

}
