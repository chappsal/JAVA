package inheritance;

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
			 * 
			 * [자식의 추가된 메서드를 호출하는 방법]
			 * 컴파일러가 자식 객체를 부모 객체로 인식하므로 자식의 추가된 메서드 호출 불가.
			 * => 기존 어떤 자식 객체인지 if문으로 판별 (A instanceof B)
			 * => 해당 자식 객체로 형 변환
			 * => 자식에 추가된 메서드 호출 가능
			 * (★단, 가장 마지막 자식부터 판별)
			 * 
			 */
			
			
			//c가 참조하는 객체가 VIPCustomer인지 GoldCustomer인지 판별
			if(c instanceof VIPCustomer) {
				((VIPCustomer) c).showSaleRatio();;
			} else if(c instanceof GoldCustomer) {
				((GoldCustomer) c).showSaleRatio();
			} else c.showNOSaleRatio();
			
		}
		
		
		
		
		
		
		
		
		
	}

}