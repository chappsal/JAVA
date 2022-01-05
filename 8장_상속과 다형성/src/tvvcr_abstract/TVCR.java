/*
 * 문제점 : power(){}완성된 메서드이면 자식 클래스에서 power()를 재정의하지 않아도 오류 발생 안 함
 * 		   그런데 부모 입장에서는 반드시 power()를 재정의해서 사용하기를 원함
 * 
 * 해결 : power()를 미완성된 추상 메서드로 만들어 반드시 자식 클래스에서 재정의하도록 함
 * 		자식 클래스에서 재정의 안 하면 오류 발생 - 오류 해결 방법 1: 재정의
 * 											 2: 자식 클래스를 추상 클래스로 만듦
 * 	
 * [abstract class 클래스명 = 추상 클래스]
 * 1. 여러 메서드 중 1개라도 미완성된 추상 메서드가 포함되어 있으면 이 클래스도 미완성이므로 abstract class가 됨
 * 2. 객체 생성 불가 : 미완성 클래스이므로
 * 3. 그러나 부모 역할 가능
 * 		ex 1) method(Electronics e) { // Electronics의 자식 객체(TV, VCR, TVCR)
 * 										 -> 자동으로 Electronics로 형변환되어 받아들임 
 * 			  }
 * 		ex 2) Electronics e = new TV();
 * 			  Electronics e = new VCR();
 * 			  Electronics e = new TVCR();
 * 
 */

package tvvcr_abstract;

abstract class Electronics { //부모:전자제품-자식의 공통된 속성과 기능 
	boolean power; //전원: on off
	
	//기본생성자
	
	//void power() {} //완성된 메서드
	abstract void power(); //미완성된 메서드 (추상 메서드) : 반드시 자식 클래스에서 재정의해야 함
}


class TV extends Electronics { //부모
	//boolean power; //전원: on off
	int channel; //채널
	
	
	//기본생성자 TV(){super();}
	
	@Override
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



class VCR extends Electronics {
	//boolean power; //전원
	
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
	
	//추가
	void capture() {
		System.out.println("화면 캡쳐");
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
	
	
	/*
	void channelUP() {
		channel++;
	}
	
	void channerDown() {
		channel--;
	}
	*/
	
	
	//외부에 노출된 버튼
	void play() { vcr.play(); }
	void stop() { vcr.stop(); } 
	void rew() 	{ vcr.rew();  }
	void ff() 	{ vcr.ff();   } 
	
	
	
	public String soString() {
		return "TVCR [ vcr =" + vcr + ", power=" + power + ", channel=" + channel + "]";
	}

	
}

//TVCR [vcr=VCR [power=false], power=true, channel=0]



