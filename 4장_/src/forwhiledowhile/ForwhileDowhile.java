package forwhiledowhile;

public class ForwhileDowhile {

	public static void main(String[] args) {

		System.out.println(1);
		System.out.println(2);
		System.out.println(3);
		System.out.println(4);
		System.out.println(5);
		System.out.println(); //구분줄
		
		
		/* 반복문 3가지 */
		
		System.out.println("*** for문 : 배열에서 많이 사용 ***");
		
		int i;
		for(i=1;i<=5;i++) { //for문에서만 조건문 생략 가능(생략시 true)			
			System.out.print(i+"");
		}
		System.out.println("\n"); //커서를 아래로->구분줄

		//-------------------------------------------
		
		for(i=0;i<=4;i++) { //for문에서만 조건문 생략 가능(생략시 true)
			System.out.println(i+1);
		}
		System.out.println(); //구분줄
		
		//-------------------------------------------
		
		i=1;
		//for(;i>=1;) { //최대값+1=>최소값(음수)이 되어 멈춤(무한루프x)
		for(;i<=5;) {
			System.out.println(i);
			i++;
		}
		System.out.println(); //구분줄
		
		//-------------------------------------------------------
		
		System.out.println("*** while문 : for문과 같은 결과 ***");
		
		
		i=1;
		while(i<=5) { //조건문 생략 불가
			System.out.println(i);
			i++;
		}
		System.out.println(); //구분줄
		
		//-------------------------------------------------------
		
		System.out.println("*** do-while문 : 참/거짓에 관계없이 무조건 한번은 실행 ***");
		
		
		i=1;
		do{
			System.out.println(i);
			i++;
		}while(i<=5); // 주의) ; 붙임
		System.out.println(); //구분줄
	}

}