package template;

abstract public class Car { //부모
	
	//1. 자식의 공통된 속성,기능 - 미완성된 추상 메서드: 반드시 재정의할 목적
	public abstract void drive(); 
	public abstract void stop();
	public abstract void wiper();
	
	
	//2. 자식의 공통된 기능 - 완성된 메서드: 필요하면 자식에서 재정의하여 사용
	//MenualCar:그대로 사용, AICar:'자동 세차' 재정의
	public void washCar() {};
	
	
	//3.자식의 공통된 기능 - 완성된 메서드: 그대로 상속 받아 사용
	public void startCar() {
		System.out.println("시동을 켭니다.");
	}
	
	public void turnOff() {
		System.out.println("시동을 끕니다.");
	}

	
	//템플릿 메서드 : 메서드 실행 순서와 시나리오를 정의한 메서드. 설계시 사용
	//모든 순서가 같다면 템플릿 만들어서 사용
	//접근제한자 순서 주의 , final 강조위해 제일 앞에 사용
	final public void run() { // final 붙이는 이유 : 작동 순서는 어느 차나 동일. 실행순서, 즉 시나리오를 정의한 메서드를 재정의하면 안 됨
		startCar();
		
		drive();
		wiper();
		stop(); 
		
		turnOff();
		
		washCar(); //필요에 의해 재정의
				   //MenualCar(수동차): 실행되는 것 없음     AICar: 자동 세차
	}
	
	
}