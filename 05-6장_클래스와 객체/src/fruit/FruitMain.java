package fruit;

//같은 패키지 안에 있으면 자동 import됨
//import fruit.*;


public class FruitMain {

	public static void main(String[] args) {
		Buyer b = new Buyer(); // 기본값 0으로 채워진 생성자 생성
		
		//멤버변수에 [직접 접근]하여 값을 변경
		b.money = 30000; // 돈 30000원
		b.numOfApple = 20; // 사과 20개를 가진 구매자로 변경
		
		System.out.println("-----[직접 접근]구매자의 현황 -1 -------");
		//b.showBuy();
		System.out.println(b.money);
		System.out.println(b.numOfApple);
		
		
		
		//멤버변수에 [간접 접근]하여 값을 변경 - 메서드 이용
		b.setMoney(50000); // 돈 50000원
		b.setNumOfApple(30); // 사과 30개를 가진 구매자로 변경
		
		System.out.println("-----[간접 접근]구매자의 현황 -2 -------");
		//b.showBuy();
		System.out.println(b.getMoney()); 
		System.out.println(b.getNumOfApple()); 
		
		
		
		//1-1.구매자 1 생성
		Buyer b1 = new Buyer(10000); //10000원 가진 구매자 생성
		
		//1-2.구매자 2 생성
		Buyer b2 = new Buyer(20000, 10); //20000원, 사과 10개를 가진 구매자 생성
		
		//2-1.판매자 1 생성
		Seller s1 = new Seller(100, 0, 1000);
		//2-2.판매자 2 생성
		Seller s2 = new Seller(50, 0, 2000);
		
		//3-1.구매자 1이 [판매자 1]한테 사과 5000원어치 구매
		b1.buy(s1, 5000); // s1은 주소를 받음 seller가 class이기 때문에, 5000은 int이기 때문에 값을 받음
		//3-2.구매자 1이 [판매자 2]한테 사과 4000원어치 구매
		b1.buy(s2, 4000); // s1은 주소를 받음 seller가 class이기 때문에, 5000은 int이기 때문에 값을 받음
		
		//4.구매자 1의 현황
		//System.out.println(b1.money);
		//System.out.println(b1.numOfApple);  //번거롭기 때문에 메서드로 출력
		
		System.out.println("----구매자 1의 현황-------");
		b1.showBuy();
		
		System.out.println();
		System.out.println("----판매자 1의 현황-------");
		s1.showSale();
		
		System.out.println("----판매자 2의 현황-------");
		s2.showSale();

	
	
	
	
	
	
	}
	
}
