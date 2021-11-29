package forex;

public class BasicFor {

	public static void main(String[] args) {
		/* 반복문을 사용 안 하면 */
		System.out.println("오늘도 최선을...");
		System.out.println("오늘도 최선을...");
		System.out.println("오늘도 최선을...");
		System.out.println("오늘도 최선을...");
		System.out.println("오늘도 최선을...");
		
		System.out.println(); // 구분선
		
		/* '같은 실행문'이거나 '일정한 규칙성'이 있어야 '반복문'을 사용할 수 있다. */
		
		
		/**** 반복문을 사용 하면 : 카운터 변수 ***************************************************
		 * 
		 * 1.변수 선언 및 초기화(한번만);
		 * 
		 * for(1.변수 선언 및 초기화; 2.조건문; 4.변수 증가/감소->2){
		 * 		3.조건문이 참이면 실행->4
		 * }
		 * 3.조건문이 거짓->for문 빠져나옴(반복문 끝)
		 * 
		 * */	
		
		int i;// 카운터 변수 1 2 3 4 5
		
		for(i=1; i<=5; i++) { 
			System.out.println("오늘도 최선을...");
		}
		System.out.println("거짓이 되어 for문 빠져나옴 i="+i);
		System.out.println(); //구분선
		
		
		// 변수 i를 카운터 변수로만 사용한다면 초기값이 어떤 정수라도 가능함
		for(i=0; i<=4; i++) { //0 1 2 3 4 <= 4(참) 5<=(거짓)
			System.out.println("오늘도 최선을...");
		}
		System.out.println("거짓이 되어 for문 빠져나옴 i="+i +"\n");
		
		
		for(i=0; i>= -3; i--){ //1 0 -1 -2 -3 -3(참) 5<=(거짓)
			System.out.println("오늘도 최선을...");
		}	
		System.out.println("거짓이 되어 for문 빠져나옴 i="+i+"\n");
		
		
		for(i=1; i<=9; i+=2) {
			System.out.println("오늘도 최선을...");
		}
		System.out.println("거짓이 되어 for문 빠져나옴 i="+i+"\n");
		
		
		for(i=-3; i>=-11 ; i-=2) { // -3 -5 -7 -9 -11 >= -11(참) -13(거짓)
			System.out.println("오늘도 최선을...");
		}
		System.out.println("거짓이 되어 for문 빠져나옴 i="+i+"\n");
		
		i=-3;
		while(i>=-11) { // -3 -5 -7 -9 -11 >= -11(참) -13(거짓)
			System.out.println("오늘도 최선을...");
			i-=2;
		}
		System.out.println("거짓이 되어 for문 빠져나옴 i="+i+"\n");
		
		
		i=-3;
		do { // -3 무조건 실행 -5 -7 -9 -11   -13>=11
			System.out.println("오늘도 최선을...");
			i-=2;
		}while(i> -11);
		System.out.println("거짓이 되어 for문 빠져나옴 i="+i+"\n");
		
		
		/** 2. 반복문을 사용 안 하면 **/
		System.out.print(1+" ");
		System.out.print(2+" ");
		System.out.print(3+" ");
		System.out.print(4+" ");
		System.out.print(5+" ");
		
		
		System.out.println(); // 커서를 아래로
		
		
		/**** 2. 반복문을 사용 하면 : 카운터 변수 + 반복문의 실행문 ***************************************************/
		for(i=1;i<=5;i++) {//1->2->..->4->5(참)->6(거짓)
			System.out.print(i+" "); //1 2..4 5
		}
		System.out.println();//커서를 아래로
		
		
		
		for(i=0;i<=4;i++) {//0->1->2->3->4->5(거짓)
			System.out.print((i+1)+" "); //1 2 3 4 5
		}
		System.out.println();//커서를 아래로

		
		
		for(i=-10; i<=-6; i++) {//-10
			System.out.print(i+11+""); //1
		}
		System.out.println();//커서를 아래로
		
		
		
		
		/*** 3. 반복문을 사용 안 하면 1+2+3+4+...+10 합 출력 ***/
		
		int hap = 1+2+3+4+5+6+7+8+9+10;
		System.out.println("[반복문 사용 안 함]1~10까지 더한 합="+hap); //55
		
		/*** 3. 반복문을 사용하여 1+2+3+4+...+10 합 출력 ***/
		// i=1
		hap = 0; // 반드시 0으로 초기화
		for(i=1;i<=10;i++) { // i=1 => 2 => 3 => 4 => 5
			hap = hap + i; //0+1+2+3+5
		}
		System.out.println("[반복문 사용]1~10까지 더한 합="+hap); //55
	}
		
		
		
}


