package random_math;

import java.util.Arrays;
import java.util.Random;

public class RandomExample {

	public static void main(String[] args) {
		//선택번호
		
		int[] sn = new int[6]; // [0,0,0,0,0,0] 선택번호 6개가 0으로 채워짐
		
		// 선택번호를 랜덤하게 얻기 위한 Random객체 생성
		//long seed = System.currentTimeMillis();
		//Random r = new Random(seed); //Random 객체 생성 방법 -1 : seed가 같으면 같은 난수 발생 => 당첨
		Random r = new Random(); //Random 객체 생성 방법 -1
		
		
		/* Random 클래스
		 * 
		 * r.nextInt(); : int타입 전 범위에서 난수 발생
		 * 
		 * 0 <= r.nextInt(int n) < n 	 (int형 난수 발생)
		 * 0 <= r.nextInt(45) < 45   	 (0~44 난수 발생)
		 * 0+1 <= r.nextInt(45)+1 < 45+1 (1~45 난수 발생)
		 * 
		 */
		
				
		System.out.print("선택 번호>");
		
		int i;
		for(i=0; i<sn.length; i++) {
			sn[i] = r.nextInt(45)+1; // 1부터 시작해서 45개 (정수 1~45 중 랜덤으로 발생시켜 배열에 저장)
			//System.out.print(sn[i]+" ");
		
		}
		System.out.print(Arrays.toString(sn));
		System.out.println(); // 커서 아래로
		
		
		//당첨번호
		int[] wn = new int[6]; //[0,0,0,0,0,0] 당첨번호 6개가 0으로 채워짐
		//long seed2 = System.currentTimeMillis(); //현재시간 값 리턴
		//Random r2 = new Random(seed); // long타입의 seed값을 주면 랜덤으로 같은 값들이 생성 (15,45열 주석 해제하면 당첨)
		Random r2 = new Random();

		System.out.print("당첨 번호>");
		
		
		for(i=0; i<wn.length; i++) {
			wn[i] = r2.nextInt(45)+1; // 1부터 시작해서 45개 (정수 1~45 중 랜덤으로 발생시켜 배열에 저장)
			//System.out.print(wn[i]+" ");
		
		}
		System.out.print(Arrays.toString(wn));
		System.out.println(); // 커서 아래로
		
		
		// 당첨 여부
		System.out.print("당첨 여부>");
		if(Arrays.equals(sn, wn)) {
			System.out.println("1등에 당첨되었습니다.");
		} else System.out.println("당첨되지 않았습니다.");
		
		
		
		/*
		 * 이진 '탐색' : 반듯이 정렬 -> 정렬된 데이터를 대상으로 탐색하는 알고리즘
		 * 이를 이용하여 배열의 특정 숫자가 포함 되었는지 여부와
		 * 만일 포함되어 있지 않다면 그 숫자의 적절한 위치까지 찾아주는 것이 가능
		 */
		
		//1.정렬
		Arrays.sort(wn); // 오름차순 정렬
		System.out.println(Arrays.toString(wn));
		
		//2.binarySearch(배열, 찾을 값) : 정렬된 배열에서 34를 찾아서 index번호 리턴
		int idx = Arrays.binarySearch(wn, 21);
		System.out.println("21은 "+(idx+1)+"번째로 작은 값이다.");
		
		/*
		 * binarySearch(배열, 찾을 값) : 찾을 index 번호를 리턴
		 * 							  찾을 값이 없으면 찾을 값보다 큰 최초의 위치를 찾음
		 * 
		 * binarySearch(배열, 2) : 찾을 값(=2) 가 없으므로 2보다 큰 최초의 값(=3) 의 위치 값 (=1)
		 * 						   그 위치*(-1)-1 = -2리턴
		 * 1     2     3     4     5     6      
		 * 0   (-2)    1   (-3)    2   (-4)  (index)
		 * 
		 */
		
		
		
		//예시
		
		int[] arr = {5,1,3};
		//1.정렬
		Arrays.sort(arr);
		//2.binarySearch(배열, 찾을 값)
		idx = Arrays.binarySearch(arr, 3);
		System.out.println("3은(는) "+(idx+1)+"번째로 작은 값이다.");
		
		//찾을 값이 없는 ex.
		idx = Arrays.binarySearch(arr, 2); // 배열에 없는 값
		System.out.println("2은(는) "+(idx)+"위치이다."); //-2
		
		idx = Arrays.binarySearch(arr, 4); // 배열에 없는 값
		System.out.println("4은(는) "+(idx)+"위치이다."); //-3
		
		idx = Arrays.binarySearch(arr, 6); // 배열에 없는 값
		System.out.println("6은(는) "+(idx)+"위치이다."); //-4
		
		
		for(i=0; i<10; i++) {
			System.out.println(i+"의 위치값="+Arrays.binarySearch(arr, i));
		}
		
		
	}

}
