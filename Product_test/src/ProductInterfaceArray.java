interface ProductInterface {
	int TV=1, COMPUTER=2, AUDIO=3;
	
	static void buyerEnter() {};
	default void defaultMethod() {};
	
	void menu();
}

abstract class Product {
	
	final String makeCountry="korea";	
	int price;
	int bonusPoint;
	
	
	Product(int price) {
		super();
		this.price = price;
		bonusPoint = (int)(price/10.0);
	}

	abstract void show();
}

class TV extends Product {
	
	final String company = "samsung";

	TV() {
		super(200);
	}

	@Override
	void show() {
		System.out.println("TV 가격: " + price + "TV 제조국가: " + makeCountry + "TV 보너스포인트: " + bonusPoint);
		
	}

	@Override
	public String toString() {
		return "TV";
	}
	
	
}


class Computer extends Product {
	
	final String brand = "LG";

	Computer() {
		super(200);
		bonusPoint = (int)(200/5.0);
	}

	@Override
	void show() {
		System.out.println("Computer 가격: " + price + "Computer 브랜드: " + brand + "Computer 보너스포인트: " + bonusPoint);
				
	}

	@Override
	public String toString() {
		return "Computer";
	}
	
}


class Audio extends Product {

	Audio() {
		super(300);
	}

	@Override
	void show() {
		System.out.println("Audio 가격: " + price + "Audio 보너스포인트: " + bonusPoint);
		
	}

	@Override
	public String toString() {
		return "Audio";
	}
	
	
}

class Buyer {
	
	int money;
	int bonusPoint=0;
	
	Buyer(int money) {
		super();
		this.money = money;
	}


	void buy (Product p) {
		
	}
	
	void askInfo() {
		
	}
	
	
	
}

public class ProductInterfaceArray implements ProductInterface {

	public static void main(String[] args) {
	
		
	
	}

	@Override
	public void menu() {
		System.out.println("메뉴판");
		
	}
}