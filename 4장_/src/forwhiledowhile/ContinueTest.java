package forwhiledowhile;

public class ContinueTest {

	public static void main(String[] args) {
		/*
		 * 1과 10사이의 숫자를 출력하되 그 중 3의 배수인 것은 제외
		 * 1 2 4 5 7 8 10
		 *
		 */
		
		int i;
		for (i=1;i<=10;i++) {
			if(i%3==0) continue; // 아래 실행문은 실행되지 않고 증감식으로 올라감
			System.out.print(i+" ");
		}
		System.out.println();//커서를 아래로
		System.out.println("\n"); // 구분용 빈줄
		
		/* 과제 2 반복문 사용 , 다섯개를 카운트 하는 변수를 생성
		 * 1과 50사이의 숫자를 출력하되 그 중 7의 배수인 것은 제외
		 * 단, 한 줄에 다섯개씩 출력 (간격 맞추기)
		 * 1 2 3 4  5
		 * 6 8 9 10 11
		 */
		System.out.println("for문");
		
		int c;
		for(i=1,c=0;i<=50;i++) {	
			if(i%7==0) continue;
			c++;
			System.out.print(i+"\t");
			if(c%5==0) System.out.println();
		}
		
		System.out.println("\n"); // 커서 아래로
		System.out.println(); // 구분용 빈줄
		
		
		// 과제 1, i++을 어디에 둘지
		// 풀이 2 while문 이용  
		System.out.println("while문");
		
		c=0;
		i=1;
		while(i<=50) {
			if(i%7==0) i++;
			System.out.print(i+"\t");
			i++;
			c++;
			if(c%5==0) System.out.println();
		}	
		
		System.out.println("\n");

		
		

		// 과제 1, i++을 어디에 둘지
		// do~while문 이용  
		System.out.println("do~while문");
		
		c=0;
		i=0;
		do {
			if(i%7==0) i++;
			System.out.print(i+"\t");
			i++;
			c++;
			if(c%5==0) System.out.println();
		}while(i<=50);
		
		System.out.println("\n");

		
		
		
		
		
		
	}//main

}
