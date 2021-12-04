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
		
		
		/* 과제 2 반복문 사용 , 다섯개를 카운트 하는 변수를 생성
		 * 1과 50사이의 숫자를 출력하되 그 중 7의 배수인 것은 제외
		 * 단, 한 줄에 다섯개씩 출력 (간격 맞추기)
		 * 1 2 3 4  5
		 * 6 8 9 10 11
		 */
		
		int c;
		for(i=1,c=0;i<=50;i++) {	
			if(i%7==0) continue;
			c++;
			System.out.print(i+"\t");
			if(c%5==0) System.out.println();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}//main

}