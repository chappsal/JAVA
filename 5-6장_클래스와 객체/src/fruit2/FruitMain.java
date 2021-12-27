package fruit2;

import java.util.Scanner;

//같은 패키지 안에 있으면 자동 import됨
//import fruit.*;


public class FruitMain {

	public static void main(String[] args) {
		Buyer b = new Buyer(); // 기본값 0으로 채워진 생성자 생성
		
		//멤버변수에 [직접 접근]하여 값을 변경
		//b.money = 30000; // 돈 30000원 //오류 발생> private이므로 접근 불가(접근가능한 메서드 통해 간접접근)
		b.numOfApple = 20; // 사과 20개를 가진 구매자로 변경
		
		System.out.println("-----[직접 접근]구매자의 현황 -1 -------");
		//b.showBuy();
		//System.out.println(b.money);
		System.out.println(b.numOfApple);
		
		
		
		//멤버변수에 [간접 접근]하여 값을 변경 - 메서드 이용
		b.setMoney(50000); // 돈 50000원
		b.setNumOfApple(30); // 사과 30개를 가진 구매자로 변경
		
		System.out.println("-----[간접 접근]구매자의 현황 -2 -------");
		//b.showBuy();
		System.out.println(b.getMoney()); 
		System.out.println(b.getNumOfApple()); 
		
		
		System.out.println("----------------[구매자와 판매자]--------------------------------------");
		Scanner sc = new Scanner(System.in);
		String tmp = null;
		
		//구매자 2 생성
		Buyer b2 = new Buyer(20000, 10); //20000원, 사과 10개를 가진 구매자 생성
		
		
		//2-1.판매자 1 생성
		Seller s1 = new Seller("판매점1", 1300, 100, 1000); //사과개수,원금,가격
		//2-2.판매자 2 생성
		Seller s2 = new Seller("판매점2", 1700, 50, 2000);
		
		

		while(b2.getMoney() != 0) { 
			System.out.println("(1) 판매점 1");
			System.out.println("(2) 판매점 2");
			System.out.print("선택하세요(구매 종료하려면 stop 입력)>");
			
			tmp	= sc.next(); // 1, 2, 3, 1.23 / stop, Stop, a, b 입력 가능성
		
			if(tmp.equalsIgnoreCase("stop")) {
				System.out.println("구매자가 구매를 중단합니다.");
				break;
			} 
			
			int menu = 0; //지역변수는 직접 초기화 해줘야 함
			
			try {
				menu = Integer.parseInt(tmp);  //0, 1, 2, 3, / a, b, ㅁ, 1.23 (정수로 바꿀 수 없음 -> 예외발생 -> 프로그램 멈춤)
			} catch (NumberFormatException e) {
				//e.printStackTrace();
				System.out.println("메뉴를 잘못 입력하셨습니다.");
				continue;
			}
			
			//0, 1, 2, 3
			if(!(1 <= menu && menu <= 2)) {
				System.out.println("메뉴를 잘못 입력하셨습니다.");
				continue;
			}
			
			// 1,2
			if(menu == 1) { //switch(menu){case 1
				System.out.println("===" + s1.NAME + "에 입장하셨습니다. ===");
				b2.askApplePrice(s1);
				b2.askNumOfApple(s1);
			
				if(b2.getMoney() >= s1.getAPPLE_PRICE() ) { 
					System.out.println("=======================================");
					System.out.println("구매자의 현재 잔액은 " + b2.getMoney() + "원 입니다.");
					System.out.println(s1.NAME + "의 사과 1개 가격은 " + s1.getAPPLE_PRICE() +"원 입니다.");
					System.out.println("=======================================");
	
					int buyCount = 0; //판매자 1에서 구매한 사과 개수 
					
					//구매
					while(b2.getMoney() != 0) {
						if(b2.getMoney() <s1.getAPPLE_PRICE()) {
							System.out.println("현재 잔액이 부족하여 더 이상 사과를 구매할 수 없습니다.");
							break;
						}
						System.out.print("구매할 사과 수 입력(구매 종료:stop,그만)>");
						//구매할 사과 수 입력받기
						tmp = sc.next();
						int buy;
	
						if( tmp.equalsIgnoreCase("stop") || tmp.equals("그만") ) {
							System.out.println("===" + s1.NAME + "에서 퇴장합니다. ===");
							break;
						} 
						
						try {
							buy = Integer.parseInt(tmp); 
						} catch (Exception e) { // a ㅁ 제외
							System.out.println("다시 입력해주세요.");
							continue;
						}
						
						if(buy < 0) { //음수 제외
							System.out.println("다시 입력해주세요.");
							continue;
						}
						//구매자의 현재잔액 >= 판매자의 사과가격*구매자의 사과 구매 수
						if(b2.getMoney() >= s1.getAPPLE_PRICE()*buy) {
							b2.buy(s1, s1.getAPPLE_PRICE()*buy);
							buyCount += buy; // 판매자1에서 구매한 사과 개수 누적
							System.out.println("사과 " + buy + "개를 구매하여 총 " + buyCount + "개가 되었습니다.");
							
							if(b2.getMoney() < s1.getAPPLE_PRICE()) {
								System.out.println("현재 잔액이 부족하여 " + s1.NAME + "에서는 더 이상 사과를 구매할 수 없습니다." );
								System.out.println();
								break;
							}else {
								System.out.println("잔액 " + b2.getMoney() + "원이 남았습니다.\n"+
								b2.getMoney()/s1.getAPPLE_PRICE()+"개를 더 구매할 수 있습니다");
								System.out.println();
								continue;
							}
						} else { //구매자의 현재잔액 <  판매자의 사과가격*구매자의 사과 구매 수
							System.out.println("잔액이 부족합니다.");
							System.out.println("최대 " + b2.getMoney()/s1.getAPPLE_PRICE()+"개 구매할 수 있습니다.");
							System.out.println("---------------------------------------------------------");
							
						}
						
						/*
						if (0 < buy && buy <= s1.numOfApple) { 
							b2.buy(s1, (buy*s1.getAPPLE_PRICE()) );
							b2.showBuy(); 
						}
						*/
					
					}//while
					
					//break;
					
				} else {
					System.out.println("구매자의 잔액이 부족하여 사과를 구매할 수 없습니다.");
				}
				
			
				
			
			} else { // menu ==2   //{case 2
				System.out.println("===" + s2.NAME + "에 입장하셨습니다. ===");
				b2.askApplePrice(s2);
				b2.askNumOfApple(s1);
				
				if(b2.getMoney() >= s1.getAPPLE_PRICE() ) {
					System.out.println("=======================================");
					System.out.println("구매자의 현재 잔액은 " + b2.getMoney() + "원 입니다.");
					System.out.println(s2.NAME + "의 사과 1개 가격은" + s2.getAPPLE_PRICE() +"원 입니다.");
					System.out.println("=======================================");
	
					int buyCount = 0;
					
					//구매
					while(b2.getMoney() != 0) {
						if(b2.getMoney() <s2.getAPPLE_PRICE()) {
							System.out.println("현재 잔액이 부족하여 더 이상 사과를 구매할 수 없습니다.");
							break;
						}
						System.out.print("구매할 사과 수 입력(구매 종료:stop,그만)>");
						//구매할 사과 수 입력받기
						tmp = sc.next();
						int buy;
						
						if( tmp.equalsIgnoreCase("stop") || tmp.equals("그만") ) {
							System.out.println("===" + s2.NAME + "에서 퇴장합니다. ===");
							break;
						} 
						
						try {
							buy = Integer.parseInt(tmp); 
						} catch (NumberFormatException e) {
							System.out.println("다시 입력해주세요.");
							continue;
						}
						
						if(buy < 0) { //음수 제외
							System.out.println("다시 입력해주세요.");
							continue;
						}
						
						//구매자의 현재잔액 >= 판매자의 사과가격*구매자의 사과 구매 수
						if(b2.getMoney() >= s1.getAPPLE_PRICE()*buy) {
							b2.buy(s1, s1.getAPPLE_PRICE()*buy);
							buyCount += buy; // 판매자1에서 구매한 사과 개수 누적
							System.out.println("사과 " + buy + "개를 구매하여 총 " + buyCount + "개가 되었습니다.");
							
							if(b2.getMoney() < s1.getAPPLE_PRICE()) {
								System.out.println("현재 잔액이 부족하여 " + s1.NAME + "에서는 더 이상 사과를 구매할 수 없습니다." );
								System.out.println();
								break;
							}else {
								System.out.println("잔액 " + b2.getMoney() + "원이 남았습니다.\n"+
								b2.getMoney()/s1.getAPPLE_PRICE()+"개를 더 구매할 수 있습니다");
								System.out.println();
								continue;
							}
						} else { //구매자의 현재잔액 <  판매자의 사과가격*구매자의 사과 구매 수
							System.out.println("잔액이 부족합니다.");
							System.out.println("최대 " + b2.getMoney()/s1.getAPPLE_PRICE()+"개 구매할 수 있습니다.");
							System.out.println("---------------------------------------------------------");
						}
						
						/*
						if (0 < buy && buy <= s1.numOfApple) { 
							b2.buy(s2, (buy*s2.getAPPLE_PRICE()) );
							b2.showBuy(); 
						}
						*/
					
					}//while
					
					//break;
					
				} else {
					System.out.println("구매자의 잔액이 부족하여 사과를 구매할 수 없습니다.");
				}
			}
			
			
			
			
			
		
		}//while
		
		System.out.println("=============================================");
		System.out.println("------------[구매자  현황]------------------------");
		b2.showBuy();
		
		System.out.println("------------["+ s1.NAME +" 현황]------------------------");
		s1.showSale();
		System.out.println("------------["+ s2.NAME +" 현황]------------------------");
		s2.showSale();
	
	
	
	}//main
	
}
