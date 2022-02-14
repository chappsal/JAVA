package inheritance;

public class CustomerMain {

	public static void main(String[] args) {
		Customer c = new Customer(); //매개변수 없는 생성자
		//System.out.println(c.toString());
		System.out.println(c); //위 아래 출력 값 같음
		
		c.setCustomerID(1);
		c.setCustomerName("정상훈");
		
		System.out.println(c.showCustomerInfo());
		
		System.out.println("==================================");
		
		VIPCustomer v = new VIPCustomer(); //매개변수 없는 생성자 호출
		System.out.println(v); 
		
		v.setCustomerID(2);
		v.setCustomerName("사공율");
		v.setAgentID(3456);
		
		v.showCustomerInfo();
		
		System.out.println("==================================");
		
		Customer c2 = new Customer(3, "배수철");
		int productPrice = 10000;
		int c2Price = c2.calPrice(productPrice);
		System.out.println(c2.customerName + "님이 " + c2Price + "원을 지불하셨습니다.");
		System.out.println(c2.showCustomerInfo());
		
		System.out.println("==================================");
		
		VIPCustomer v2 = new VIPCustomer(4, "고승범", 1234);
		productPrice = 10000;
		int v2Price = v2.calPrice(productPrice);
		System.out.println(v2.customerName + "님이 " + v2Price + "원을 지불하셨습니다.");
		System.out.println(v2.showCustomerInfo());
		
		System.out.println("==================================");
		
		Customer g = new GoldCustomer(5, "김동준");
		productPrice = 10000;
		int gPrice = g.calPrice(productPrice);
		System.out.println(g.customerName + "님이 " + gPrice + "원을 지불하셨습니다.");
		System.out.println(g.showCustomerInfo());
		
		System.out.println("==================================");		
		
		
		
		
		
	}

}
