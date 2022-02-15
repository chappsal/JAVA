package productsaleinterface_refund2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
 * 인터페이스 : 클라이언트 프로그램에 '어떤 메서드를 제공하는지' 미리 알려주는 명세 또는 약속
 */

/*
 * [추상클래스와 인터페이스의 공통점]
 * 
 * 1. 자식에서 반드시 재정의해야 할 미완성된 추상 메서드가 존재. 안 하면 오류
 * 2. 객체 생성 불가
 * 3. 그러나 부모 역할 가능
 * 	-추상클래스의 예
 * 		ex 1) void method(Electronics e) { // Electronics의 자식 객체(TV, VCR, TVCR)
 * 										 -> 자동으로 Electronics로 형변환되어 받아들임 
 * 			  }
 * 		ex 2) Electronics e = new TV();
 * 			  Electronics e = new VCR();
 * 			  Electronics e = new TVCR();
 * 	-인터페이스의 예
 * 		ex 1) void method(P p) { // PI : P 인터페이스를 구현한 PI객체
 * 										=> 자동으로 P로 형변환되어 받아들임
 * 			  }
 * 		ex 2) P p = new PI(); // PI : P 인터페이스를 구현한 클래스
 * 
 * [추상클래스만의 특징]
 * 
 * 1. 여러 메서드 중 단 1개라도 미완성된 추상 메서드가 있으면 추상 클래스가 됨 
 * 
 * 
 * [인터페이스만의 특징]
 * 
 * 1. 모든 멤버변수가 '상수'
 *    public static final int A = 1; //(모든 멤변에 public static final이 자동으로 붙어있음, 생략 가능)
 *    접근방법 : 인터페이스명.멤버변수명   ex) P.A
 *    
 * 2. 모든 메서드가 추상 메서드 : 구현하는 자식 클래스에서 반드시 재정의 
 * 	  void a();  // public abstract 생략 가능(default 메서드 제외)
 * 
 * 	  *예외-1 : static 메서드() - 자체로 완성된 메서드로서 바로 메모리에 올라감 => 클래스 생성과 무관하게 사용 가능
 * 							   => 구현한 자식 클래스에서 재정의 X
 * 							   ex) static void 이름표시() {"스마트폰"}
 * 								   100개의 구현한 자식 클래스에서 재정의하지 않고 '인터페이스 이름으로 접근'하여 사용하면 됨
 * 
 * 	  *예외-2 : default 메서드(){} - 자체로 완성된 메서드
 * 							   => 구현한 자식 클래스에서 필요하면 재정의하여 사용하면 됨
 * 							   ex 1) default void 접는 기능(){}
 * 							   		 100개의 구현한 자식 클래스 중 필요한 클래스만 재정의하면 됨
 * 
 * 							   ex 2) default void 전화를 받는 기능() {"사람이 전화를 받는다"}
 * 							   		 100개의 구현한 자식 클래스 중 99개는 이 기능을 그대로 사용하지만 
 * 									 1개 클래스는 자기 클래스에 맞게 재정의하면 됨
 * 									 ex) default void 전화를 받는 기능() {"AI가 전화를 받는다."}
 * 
 *	  *예외-3 : private 메서드 ('JDK 1.9 = JAVA9' 부터 사용 가능)
 *			  - 인터페이스 내부에서만 기능을 제공하기 위해 구현하는 메서드
 *			  => 구현한 자식 클래스에서 사용하거나 재정의 불가 
 * 
 */

interface ProductInterface {
	int TV=1, COMPUTER=2, AUDIO=3, REFUND=4; //상수 앞 public static fianl 생략됨
	
	//인터페이스에는 추상메서드만 있으나 예외로 static메서드
	static void buyerEnter() { //공유용
		System.out.println("구매자가 전자마트에 입장하셨습니다.");
	}
	
	//완성된 default메서드
	default void defaultMethod() {} //필요하면 재정의
	
	//그외 메서드는 모두 추상 메서드
	void menu(); //public abstract 생략
	
	//재정의-1 (예)
	Object menu2();
	
}




abstract class Product { //제품-부모 : 자식의 공통된 특성 //추상메서드 가졌기에 abstract 붙여줌
	
	//부모의 필드 : 자식의 공통된 속성
	final String makeCountry = "korea"; //제조 국가  //final : 명시적 초기화  // JS에서는 final 대신 const 
	int price; //제품 가격
	int bonusPoint; //포인트
	
	//기본생성자 Product(){super();} 컴파일러가 자동 생성
	
	//생성자
	Product(int price) { //가격이 있는 제품 생성
		super();
		this.price = price; //200
		bonusPoint = (int)(price/10.0); //가격의 20% // 200.0/10/0 = 20.0 실수가 되기 때문에 int로 형 변환
	}
	
	//각 필드의 값을 출력 (자식마다 출력값 달라짐) => 자식이 재정의
	abstract void show(); //추상메서드 : 자식이 반드시 재정의

	
}


class TV extends Product {
	
	//부모에게 상속받은 필드(3) + 추가 필드
	final String makeCompany = "SamSung";
	
	
	TV() { //price값을 super에게 넘겨줘야함 : 현재 Product 클래스에 매개변수가 없는 기본 생성자가 없기 때문에 => 그냥 매개변수 없애고 super()에 고정값 넣음
		super(200); // 상속받아 보너스 포인트 20이 내려옴
		bonusPoint = (int) (price/5.0); //보너스 포인트 10으로 변경됨 200.0/5.0 = 10/0 = 10

	}

	@Override
	void show() {
		System.out.println("TV 제조국 : " + makeCountry + "TV 제조사 : " + makeCompany + ", TV 가격 : " + price + ", TV 보너스 포인트 : " + bonusPoint);
	}
	

	@Override
	public String toString() {
		return  "TV";
	}
	
	
}



class Computer extends Product {

	//부모에게 상속받은 필드(3) + 추가 필드
	final String brand = "LG 그램";
	
	Computer() {
		super(100);

	}

	@Override
	void show() {
		System.out.println("Computer 제조국 : " + makeCountry + "Computer 제조사 : " + brand + ", Computer 가격 : " + price + ", Computer 보너스 포인트 : " + bonusPoint);
		
	}
	

	@Override
	public String toString() {
		return  "Computer";
	}
	
	
}



class Audio extends Product {
	
	//부모에게 상속받은 필드(3) + 추가 필드 없음
	Audio() {
		super(50);
	}

	@Override
	void show() {
		System.out.println("Audio 제조국 : " + makeCountry + ", Audio 가격 : " + price + ", Audio 보너스 포인트 : " + bonusPoint);
		
	}
	
	@Override
	public String toString() {
		return  "Audio";
	}
	
	
}

/*--------------------------------------------------------------------------------------------------*/

//구매자
class Buyer {
	
	//1. 멤버변수(=필드) : 속성
	int money;//돈
	int bonusPoint=0;//보너스포인트
	
	
	//구매자 제품 목록
	//[방법 1] 배열 : 반드시 같은 타입만 저장, 크기 고정되므로 최대 크기로 선언, 추가 삭제시 코드 직접 작성해야 하는 번거로움
	//Product[] item = new Product[10]; //최대 10개까지 제품 구매 가능 [null, null...] 기본값으로 채워진 배열 객체 생성됨
	
	//[방법 2]
	ArrayList<Product> item= new ArrayList<Product>(); // new ArrayList<>(); 의 <> 생략 가능 : 앞에서부터 읽고 유추함
	//ArrayList<Product> item= new ArrayList<>(); // <> 생략 가능 : 앞에서부터 읽고 유추함
	
	
	//2. 생성자 : 돈을 가진 구매자
	Buyer(int money) {//1000만원
		super();
		this.money = money;
	}
	
	
	//3. 메서드 : 기능
	//제품에 대해 물어본다
	void askInfo(Product p) { //어떤 제품인지 모르기 때문에 부모타입으로 받음. tv, computer, audio 중 하나를 Product 타입으로 자동 형 변환 
		//System.out.println("제품에 대한 정보 부탁드립니다.");
		System.out.println(p.toString() + "제품에 대한 정보 부탁드립니다."); //p는 주소. Product의 부모 Object의 toString => 해쉬코드 출력됨 // p = p.toString
		//↑ TV, Computer, Audio 출력되도록 toString() 재정의함
		p.show(); //재정의된 메서드 호출
		System.out.println();
	}
	
	//제품을 구매한다
	int productCnt = 0; //멤버변수 : 구매자가 구매한 제품 수 & 배열의 index 역할
	
	void buy(Product p) {
		if(this.money < p.price) { //this 생략가능 / 주소로 접근
			System.out.println("잔액이 부족하여 " + p + " 제품을 구매할 수 없습니다.");
			return; //해당 메서드=buy() 종료. //System.exit(0); : 프로그램 종료, 사용x
		}
		
		this.money -= p.price; //구매자의 돈은 제품의 가격만큼 감소
		this.bonusPoint += p.bonusPoint; //구매자의 보너스 포인트 증가
		
		//제품목록(배열)에 제품을 추가 후 => productCnt 1증가
		//item[productCnt++] = p;
		item.add(p);
		System.out.println( p + "를 구매하셨습니다.");
		System.out.println();
	}
	
	
	//제품 환불
	void refund(Product p) {
		if(!(item.contains(p))) {System.out.println("구매하지 않으셨습니다."); return;}
		
		item.remove(p);
		money += p.price;
		bonusPoint -= p.bonusPoint;
		
		System.out.println( p + "가 환불되었습니다.");
		System.out.println("환불금액 : " + p.price + ", 잔액 : " + money);
	
		/*
		if(item.remove(p)) { //제품을 목록에서 찾아 있으면 제거 후  true, 없으면 return
			money += p.price;
			bonusPoint -= p.bonusPoint;
			System.out.println( p + "가 환불되었습니다.");
			System.out.println("환불금액 : " + p.price + ", 잔액 : " + money + ", 보너스 포인트 : " + bonusPoint);
		} else System.out.println("여기서 구입한 물건이 아닙니다.");
		*/
	
	}
	
	
	
	//구매한 정보 요약
	void summery(){		
		/* [구매한 제품목록과 총금액 출력]
		 * 구입하신 제품은 TV, Computer이고
		 * 구입하신 제품의 총 금액은 500만원입니다.
		 * 
		 * TV 2대, Computer 1대이므로 총 3대입니다.
		 */
		
		int sum = 0;//구매한 제품 가격 합계
		String itemlist = "";//구매한 제품목록들 (예)""+"TV"+", "+"Computer"
		
		
		int cntTV=0, cntComputer=0, cntAudio=0;//각 제품을 몇 대 구입했는지 카운팅 변수
		
		int totalCnt=0;
		//반복문을 이용해서 구입한 제품의 '총 가격'과 '목록'을 만들어
		for(Product p : item) {
			if(p == null) break; //구입한게 없으면 나감
			if(p instanceof TV) {
				cntTV++; totalCnt++;
			} else if(p instanceof Computer) {
				cntComputer++; totalCnt++;		
			} else if(p instanceof Audio) {
				cntAudio++; totalCnt++;
			}
			sum += p.price;
		}
		
		if(totalCnt == 0) {
			System.out.println("구매자는 제품을 구매하지 않았습니다.");
			return;
		}
		
		//출력
		String productList = "";
		String productCntList = "";
		if(cntTV > 0) {
			productList += "TV, ";
			//productCntList += "TV " + Integer.toString(cntTV) + "대, ";
			productCntList += "TV " + cntTV + "대, ";
		}
		if(cntComputer > 0) {
			productList += "Computer, ";
			//productCntList += "Computer " + Integer.toString(cntComputer) + "대, ";
			productCntList += "Computer " + cntComputer + "대, ";
		}
		if(cntAudio > 0) {
			productList += "Audio, ";
			//productCntList += "Audio " +  Integer.toString(cntAudio) + "대, ";
			productCntList += "Audio " + cntAudio + "대, ";
		}
		productList = productList.substring(0, productList.length()-2);
		productCntList = productCntList.substring(0, productCntList.length()-2);
				
		System.out.println("구입하신 제품은 [" + productList + "]이고");
		System.out.println("구입하신 제품의 총 금액은 " + sum +"만원입니다.\n");
		System.out.println(productCntList + " 이므로 총 " + (cntTV + cntComputer + cntAudio) + "대 입니다.");
		System.out.println(productCntList + " 이므로 총 " + totalCnt + "대 입니다.");
		
	}	
}	
		

/*
 * 1개의 파일에 여러 클래스가 있다면 public 붙일 수 있는 클래스는 단 하나
 * main() 실행용 클래스=파일명
 */
public class ProductInterfaceArrayList implements ProductInterface{
	//필드
	
	//기본생성자 public ProductInterfaceArray(){super();}
	
	/*
	 * [재정의 조건]
	 * 1. 반드시 부모의 "리턴타입입 메서드(매개변수)" 같아야 한다.
	 * 	단, JDK1.5~수정된 사항 : ex) 부모의 리턴타입(Object)을 자식클래스의 타입(ProductInterfaceArray)으로 변경 가능
	 * 2. 접근제한자는 부모와 같거나 더 넓은 범위로
	 * 3. static 있는 메서드 -> static 없는 메서드 (X)
	 * 	  static 없는 메서드 -> static 있는 메서드 (X)
	 * 4. 예외는 조상 클래스의 메서드보다 많이 선언할 수 없다
	 */
	
	/*
	  메서드 : static 메서드(=buyerEnter())는 공유용으로 인터페이스 이름으로 접근
			default 메서드(=defaultMethod())는 상속받아 필요하면 재정의
	
	*/
	
	//재정의-1 (예)
	/*
	@Override
	public ProductInterfaceArray menu2() { //static 붙이면 오류
		ProductInterfaceArray obj = null;
		return obj;
	}
	*/
	
	@Override
	public void menu() { //static 붙이면 오류
		System.out.println();
		System.out.println("------------------- 가전 제품 목록 --------------------");
		System.out.println("1. TV	2. Computer	3. Audio	4. 환불");
		System.out.println("--------------------------------------------------");
		
		
	}
	
	
	
	//메서드
	public static void main(String[] args) {
		//1000만원 가진 구매자 생성		
		Buyer b= new Buyer(1000);

		//구매자가 전자마트에 입장
		ProductInterface.buyerEnter();
		
		//TV, Computer, Audio 객체 생성
		TV tv = new TV();
		Computer com = new Computer();
		Audio audio = new Audio();
		
		//menu() 호출
		ProductInterfaceArrayList pi = new ProductInterfaceArrayList();
		
		
		
		//재정의-1 (예)
		//ProductInterfaceArray pi2 = (ProductInterfaceArray)pi.menu2();
		//ProductInterfaceArray pi2 = pi.menu2(); //강제 형 변환하는 번거로움이 사라져 편리함
		
		System.out.println();
		Scanner sc = new Scanner(System.in);
		

		while(b.money != 0) { //돈 없으면 못 삼
			
			pi.menu();
			
			System.out.println("구매하고 싶은 가전제품 번호 입력. 종료는 stop>");
			// 정수 1~3 o / 1미만 3초과 수 , 실수, 문자 / stop
			String tmp = sc.next();
			
			if(tmp.equalsIgnoreCase("stop")) break;
			
			int num=0;
			try {
				num = Integer.parseInt(tmp); //parseInt 보면 throws~ => try catch
			} catch (NumberFormatException e) { //실수 문자 걸러내기
				System.out.println("잘못된 값을 입력하였습니다.");
				System.out.println(e.getMessage()); //예외메세지 출력 
				continue;
			}
			
			//if문 혹은  default로 처리 : if문은 바로 위로 올라가지만 default는 아래까지 실행 후 위로 올라감
			if(!(1<=num && num<=4)) {
				System.out.println("잘못된 번호입니다. 다시 입력하세요.");
				continue;
			}
			
			
			switch(num) {
			case ProductInterface.TV : b.askInfo(tv); b.buy(tv); break;
			case ProductInterface.COMPUTER : b.askInfo(com); b.buy(com); break;
			case ProductInterface.AUDIO : b.askInfo(audio); b.buy(audio); break;
			case ProductInterface.REFUND : 

				System.out.println("환불할 제품의 번호를 입력해주세요.");
				tmp = sc.next();
				
				try {
					num = Integer.parseInt(tmp);
					
					if(num==1) b.refund(tv);
					if(num==2) b.refund(com);
					if(num==3) b.refund(audio);
					
				} catch (NumberFormatException e) {
					System.out.println("다시 입력해주세요.");
				}
				
				/*
				switch(tmp.toLowerCase()) {
				case "tv" : b.refund(tv); break;
				case "computer" : b.refund(com); break;
				case "audio" : b.refund(audio); break;
				default : System.out.println("저희 매장에 있는 물건이 아닙니다.");
				}
				*/
				
			//default : System.out.println("다시 입력해주세요."); continue;
			}
			
		}

		System.out.println("\n------------------- 가전제품 판매 종료 -------------------");
		b.summery();
	}



	@Override
	public Object menu2() {
		return null;
	}

}





