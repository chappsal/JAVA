package gamelevel;

public abstract class PlayerLevel { //부모 클래스
	//미완성된 추상 메서드
	public abstract void run();
	public abstract void jump();
	public abstract void turn();

	public abstract void showLevelMessage();
	
	//★템플릿 메서드 : 실행순서, 즉 시나리오
	final public void go(int count){ // 접근제한자 위치 다름. final 강조하기위해
		run();
		
		for(int i=1; i<=count; i++) {
			jump();
		}
		
		turn();
	}
	
	
	
}
