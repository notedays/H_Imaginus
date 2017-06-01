/*판매현황프로그램


속성만 정의된 클래스

SaleVO 클래스

판매정보를 갖는 클래스
 고객명, 판매일, 판매수량
 을 속성값으로 갖는다
 (private 선언)

 // 판매정보
 private String sname; // 고객명
 private String created; // 판매일
 private int quantity; // 판매수량


// 상품정보
 ProductVO 클래스
 상품명, 단가, 수량
 을 속성값으로 갖는다

(private 선언)
 private String code; // 코드
 private String pname; // 상품명 
 private int price, quantity; // 단가, 수량

인터페이스를 구현
 메소드를 정의함

   insertProduct(); 상품등록
   insertQuantity(); 상품수량등록
   searchProduct(); 상품코드검색
   listProduct(); 상품 전체 리스트

  insertSale();  판매
  searchSale(); 상품명으로 판매 현황 조회
  listSale();   전체 판매 리스트

인터페이스를 상속해서 사용할 클래스정의
PanmaiImpl 클래스에서 인터페이스를 상속해서 메소드 구현

ArrayList, HashMap, Iterator, List, Map, Scanner 로 구현



PanmaiMain 실행클래스

판매메소드 와 상품 메소드 구현
 각각의 메뉴구성

  상품등록 

  1. 상품등록
  2. 수량등록
  3. 상품리스트
  4. 상품코드검색
  5. 복귀

  상품판매
  1. 상품판매
  2. 판매현황리스트
  3. 판매현황검색
  4. 복귀
각 메소드들은 위의 메뉴를 갖는다.


메인 메소드에서 메인메뉴로 각 메소드 호출하여 
 1. 상품등록
 2. 상품판매
 3. 종료


메뉴를 실행하여 상품과 판매에 대한 판매현황 프로그램을 완성한다.






*/