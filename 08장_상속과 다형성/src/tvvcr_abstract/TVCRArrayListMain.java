package tvvcr_abstract;

import java.util.ArrayList;

public class TVCRArrayListMain {

	public static void main(String[] args) {
		/* 
		 * ArrayList는 <Electronics> 를 관리함
		 * : Electronics 객체(추상 클래스이므로 객체 생성 안 됨) 또는 Electronics 자식 객체만 관리
		 */
		ArrayList<Electronics> e = new ArrayList<Electronics>();
		
		//Electronics의 자식 객체를 추가
		e.add(new TV());
		e.add(new VCR());
		e.add(new TVCR());

		System.out.println();
		System.out.println("=================각 전자 제품의 정보 한꺼번에 출력======================");
		/*
		 * ArrayList클래스에서 toString()을 재정의함
		 * [TV객체주소, VCR객체주소, TVCR객체주소]
		 * -> [TV객체주소.toString(), VCR객체주소.toString(), TVCR객체주소.toString()]
		 */
		System.out.println(e.toString());
		System.out.println(e); 

		
		System.out.println("=================각 전자 제품의 정보 각각 출력======================");
		System.out.println();
		System.out.println("-----[for]-----");
		for(int i=0; i<e.size(); i++) {
			System.out.println(e.get(i));
		}

		
		System.out.println();
		System.out.println("-----[향상된 for]-----");
		for(Electronics e1:e) {
			System.out.println(e1);
		}
		
		
		System.out.println();
		System.out.println("=================각 전자 제품의 메서드 호출 후 정보 출력======================");
		for(Electronics e1:e) {
			e1.power(); // Electronics에 선언된 메서드만 호출(이 때, 재정의된 메서드 호출됨)
		
			//★★자식 클래스에 추가된 메서드 호출하기 위해 코드 작성
			if(e1 instanceof TVCR) { //가장 마지막 자식부터 
				for(int i=1; i<=2; i++) {
				((TVCR) e1).channelUP(); //TVCR 채널 2번 up
				}
				((TVCR) e1).play();
				((TVCR) e1).ff();
				((TVCR) e1).rew();
				((TVCR) e1).stop();
			} else if(e1 instanceof TV) { //e1이 참조하는 객체가 TV또는 TV자식 객체이면 true(VCR은 자식 객체가 아니므로 false)
				for(int i=1; i<=4; i++) {
					((TV) e1).channelUP(); //TV 채널 4번 up
					}
			} else if(e1 instanceof VCR) {
					((VCR) e1).capture();
			}
			
			System.out.println(e1);
			System.out.println("--------------------------------------------------------------");
		}//for
	
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
