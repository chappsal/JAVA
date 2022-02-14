package tvvcr;

class TV { //부모
	boolean power; //전원: on off
	int channel; //채널
	
	
	//기본생성자 TV(){super();}
	
	void power() {
		power = !power;
		//if(power==true) System.out.println("TV 전원 ON"); // 아래 문장과 같음
		if(power) System.out.println("TV 전원 ON");
		else System.out.println("TV 전원 OFF");
	}

	void channelUP() {
		channel++;
	}
	
	void channerDown() {
		channel--;
	}
	
	@Override
	public String toString() {
		return "TV [channel=" + channel + ", power=" + power + "]";
	}
}

class VCR {
	boolean power; //전원
	
	//기본생성자
	
	void power() {
		power = !power;
		if(power)System.out.println("VCR 전원 ON");
		else System.out.println("VCR 전원 OFF");
	}

	//실질적인 기능
	void play() {System.out.println("재생");}
	void stop() {System.out.println("멈춤");}
	void rew() {System.out.println("되감기");}
	void ff() {System.out.println("빨리감기");}
	
	@Override
	public String toString() {
		return "VCR [power=" + power + "]";
	}
}



/*
 * 여러 개의 클래스를 하나의 파일에 설계할 때
 * public은 하나의 클래스에만 붙일 수 있다. 
 * 
 * public 붙은 클래스 = 파일 이름
 * main 있는 클래스 = 파일 이름 (1순위)
 */


public class TVCR extends TV { //TV : 부모 1개 (java는 단일 부모), VCR : 포함관계 - 부품
	/*
	 * TV(부모)의 멤버(멤버변수, 메서드)만 상속
	 * ※ 생성자, 초기화 블록, private 멤버는 상속되지 않음
	 */

	
	private VCR vcr;
	
	public TVCR() {
		super(); //TV생성자 호출
		vcr = new VCR();
	}

	@Override
	void power() {
		power = !power;
		vcr.power = !vcr.power;
		if(power)System.out.println("TVCR 전원 ON");
		else System.out.println("TVCR 전원 OFF");
	}

	//외부에 노출된 버튼
	void play() { vcr.play(); }
	void stop() { vcr.stop(); } 
	void rew() 	{ vcr.rew();  }
	void ff() 	{ vcr.ff();   } 
	
	
	
	public String soString() {
		return "TVCR [ vcr =" + vcr + ", power=" + power + ", channel=" + channel + "]";
	}

	
}







