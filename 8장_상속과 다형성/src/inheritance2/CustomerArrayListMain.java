package inheritance2;

import java.util.ArrayList;

public class CustomerArrayListMain {

	public static void main(String[] args) {
		//Customer 객체와 Customer 자식 객체만 저장 가능
		ArrayList<Customer> customerList = new ArrayList<>();
		
		customerList.add(new Customer(1, "박병건"));
		customerList.add(new GoldCustomer(2, "장수호"));
		customerList.add(new VIPCustomer(3, "박영현", 1234));

		System.out.println("==================== 고객 정보 출력 ======================");
	
		for(Customer c : customerList) {
			System.out.println(c.showCustomerInfo());
		}
		
		System.out.println();
		System.out.println("==================== 지불 가격과 보너스 포인트 출력 ======================");
			
		int productPrice = 10000;
		System.out.println("[제품가격 " + productPrice + "원]");
		System.out.println();
		
		for(Customer c : customerList) {
			int cost = c.calPrice(productPrice); //지불가격
			System.out.println(c.customerName + "님이 지불한 가격은 " + cost + "원, 현재 보너스 포인트는 " + c.bonusPoint + "점 입니다.");
			
		}
		
		System.out.println();
		System.out.println("==================== 고객의 세일 비율 ======================");
		
		for(Customer c : customerList) {
			/* customerList가 참조하는 객체를 가져와 Customer타입으로 자동 형 변환하여 받아들임
			 * -> Customer 클래스에 정의된 메서드만 호출 가능
			 *
			 * 
			 */
			c.showSaleRatio();
					
		}//for
		

		
	}//main

}