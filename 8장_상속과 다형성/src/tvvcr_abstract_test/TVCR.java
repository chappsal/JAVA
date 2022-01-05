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

package tvvcr_abstract_test;

class Electronics{//부모:전자제품-자식의 공통된 속성과 기능
	
}


class TV extends Electronics{//부모
	
}


class VCR extends Electronics{
	
}


public class TVCR extends TV{//TV:부모1개-반드시, VCR:포함관계-부품
	
	
}


