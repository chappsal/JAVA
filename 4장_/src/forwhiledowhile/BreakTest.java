package forwhiledowhile;

public class BreakTest {

	public static void main(String[] args) {
		/*
		 * [문제] 1부터 계속 더하다가 합이 100을 초과하는 최초의 정수값을 알아보기
		 * 
		 * 
		 * */

		int i=1, hap=0;
		for(;true;i++) {
			hap+=i;
			if(hap>100)
			break;
		}
		System.out.println("[for문]"+i+","+hap);
		
		
		i=1; hap=0;
		while(true) {
			hap+=i;
			if(hap>100) break;
			i++;
		}
		System.out.println("[while문]"+i+","+hap);
		
		
		i=1; hap=0;
		do {
			hap+=i;
			if(hap>100) break;
			i++;
		}while(true);
		System.out.println("[do~while문]"+i+","+hap);
		
		
		System.out.println("---------------------------------");
		System.out.println("i 초기값을 0으로 변경, i++ 위치를 반복문 안에서 위로 이동함"); // 0+0+1+2+3을 0+1+2+3으로 바꾸려고
		
		
		i=0; hap=0;
		for(;true;) {
			i++; // 0->1->...->14->15
			if(hap>100) break;
			hap+=i; // 0+1+2+...+14
			//if(hap>100) break;
		}
		System.out.println("[for문]"+i+","+hap);
		
		
		i=0; hap=0;
		while(true) {
			i++;// 15
			//if(hap>100) break;//i가 15가 된 상태에서 반복문 멈춤
			hap+=i;// 1~14
			if(hap>100) break;
			
		}
		System.out.println("[while문]"+i+","+hap);
		
		
		i=0; hap=0;
		do {
			i++;
			//if(hap>100) break;//i가 15가 된 상태에서 반복문 멈춤
			hap+=i;
			if(hap>100) break; // 초기값에 따라 i를 더한 상태에서 if문/break가 와야 함 // 초기값이 0일 경우
		}while(true);
		System.out.println("[do~while문]"+i+","+hap);
		
		
		
		
		
		
		
		
		
		
	}// main

}