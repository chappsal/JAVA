package template;

public class CarMain {

	public static void main(String[] args) {
		System.out.println("========== 사람이 운전하는 자동차 ==========");
		MenualCar mcar = new MenualCar();
		mcar.run();
		
		
		System.out.println();
		System.out.println("========== 자동 주행하는 자동차 ==========");
		AICar aicar = new AICar();
		aicar.run();
		
		
		
		
	}//main

}
