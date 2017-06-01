package SalesManagement;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SalesImpl implements SalesInterface {
	Scanner sc = new Scanner(System.in);
	List<ProductVO> Plist = new ArrayList<>();
	List<ProductVO> Slist = new ArrayList<>();
	List<SaleVO> SaleList = new ArrayList<>();
	Map<String, ProductVO> Smap = new HashMap<>();

	Calendar cal = Calendar.getInstance();

	@Override
	public void showInterface1() {

		System.out.print("1.제품관리 2.판매관리 3.종료");
		int a = sc.nextInt();
		switch (a) {
		case 1:
			showInterface2();
			break;
		case 2:
			showInterface3();
			break;
		case 3:
			System.out.println("작업을 종료합니다.");
			System.exit(0);
			break;
		default: {
			System.out.println("다시 입력하세요");
			showInterface1();
		}
		}
	}

	@Override
	public void showInterface2() {

		System.out.print("1.제품등록 .2재고수정 3.제품리스트 4.제품코드검색 5.이전메뉴");
		int a = sc.nextInt();
		switch (a) {
		case 1:
			insertProduct();
			break;
		case 2:
			insertQuantity();
			break;
		case 3:
			listProduct();
			showInterface2();
			break;
		case 4:
			searchProduct();
			break;
		case 5:
			showInterface1();
			break;
		default: {
			System.out.println("다시 입력하세요");
			showInterface2();
		}
		}

	}

	@Override
	public void showInterface3() {
		System.out.print("1.판매내역입력 2.판매현황리스트 3.판매현황검색 4.이전메뉴");
		int a = sc.nextInt();
		switch (a) {
		case 1:
			insertSale();
			break;
		case 2:
			listSale();
			showInterface3();
			break;
		case 3:
			searchSale();
			break;
		case 4:
			showInterface1();
			break;
		default:
			System.out.println("다시 입력하세요.");
			showInterface3();
		}

	}

	public ProductVO checkCode(int code) {
		ProductVO pvo = null;

		for (ProductVO a : Plist) {
			if (a.getCode() == code) {
				pvo = a;
				break;
			}
		}

		return pvo;

	}

	public ProductVO checkSaleCode(int code) {
		ProductVO svo = null;

		for (ProductVO a : Slist) {
			if (a.getCode() == code) {
				svo = a;
				break;
			}
		}

		return svo;

	}

	@Override
	public void insertProduct() {

		System.out.print("상품코드를 입력하세요");
		int code = sc.nextInt();

		if (checkCode(code) != null) {
			System.out.println("이미 등록된 상품코드입니다.");
			showInterface2();
		}

		System.out.print("상품 이름을 입력하세요");
		String a = sc.next();

		System.out.print("단가를 입력하세요");
		int b = sc.nextInt();

		System.out.print("수량을 입력하세요");
		int d = sc.nextInt();

		ProductVO pvo = new ProductVO(code, a, b, d);
		Plist.add(pvo);

		showInterface2();

	}

	@Override
	public void insertQuantity() {
		ProductVO pvo = null;

		listProduct();
		System.out.print("재고를 수정할 상품코드를 입력하세요");
		int a = sc.nextInt();
		if (checkCode(a) == null) {
			System.out.print("등록되지 않은 코드입니다.");
			showInterface2();
		} else
			pvo = checkCode(a);

		System.out.print("수량을 입력하세요");
		int b = sc.nextInt();
		pvo.setQuantity(b);

		System.out.print("재고가 수정되었습니다.  ");
		System.out.println(pvo);

		showInterface2();
	}

	@Override
	public void searchProduct() {
		System.out.print("검색할 상품코드를 입력하세요");
		int code = sc.nextInt();

		if (checkCode(code) == null) {
			System.out.println("상품이 존재하지 않습니다.");
			showInterface2();
		}
		ProductVO pvo = checkCode(code);
		System.out.println(pvo);
		showInterface2();
	}

	@Override
	public void listProduct() {
		if (Plist.isEmpty()) {
			System.out.println("등록된 제품이 존재하지 않습니다.");
		}

		Iterator<ProductVO> it = Plist.iterator();
		while (it.hasNext()) {
			ProductVO pvo = it.next();
			System.out.println(pvo);
		}
		return;

	}

	
	//판매량보다 재고가 작을 경우의 수 코딩
	//시간나면 입력오류 예외처리하기
	@Override
	public void insertSale() {
		ProductVO pvo;
		ProductVO svo;
		SaleVO salevo;

		System.out.print("판매한 상품코드를 입력하세요");
		int code = sc.nextInt();
		if (checkCode(code) == null) {
			System.out.println("등록되지 않은 상품입니다.");
			showInterface3();
		}
		pvo = checkCode(code);
		System.out.print("판매한 수량을 입력해 주세요");
		int a = sc.nextInt();
		System.out.print("구매자를 입력해 주세요");
		String buyer = sc.next();
		System.out.print("구매 날짜를 입력하세요");
		String date = sc.next();

/*		if (checkSaleCode(code) != null) {
			svo = checkSaleCode(code);
			pvo.setQuantity(pvo.getQuantity() - a);
			svo.setQuantity(svo.getQuantity() + a);

			salevo = new SaleVO(buyer, date, svo);
			SaleList.add(salevo);
			showInterface3();
		}*/
		
		svo = new ProductVO(pvo.getCode(), pvo.getPname(), pvo.getPrice(), a);
		Slist.add(svo);
		pvo.setQuantity(pvo.getQuantity() - a);

		salevo = new SaleVO(buyer, date, svo);
		SaleList.add(salevo);

		showInterface3();

	}

	@Override
	public void searchSale() {

		System.out.print("판매현황을 검색할 상품코드를 입력하세요");
		int a = sc.nextInt();
		if (checkSaleCode(a) == null) {
			System.out.println("판매내역이 존재하지 않습니다.");
		}
		ProductVO svo = checkSaleCode(a);
		System.out.print(svo + " ");
		a = +svo.getPrice() * svo.getQuantity();
		System.out.println("총 판매액 : " + a);
		showInterface3();

	}

	@Override
	public void listSale() {
		int a = 0;
		if (Slist.isEmpty()) {
			System.out.println("판매내역이 존재하지 않습니다.");
		}

		Iterator<SaleVO> it = SaleList.iterator();
		while (it.hasNext()) {
			SaleVO svo = it.next();
			System.out.print(svo + " ");
			a = +svo.getProductSale().getPrice() * svo.getProductSale().getQuantity();
			System.out.println("총 판매액 : " + a);
		}

		return;
	}

}
