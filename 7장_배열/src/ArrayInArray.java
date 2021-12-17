import java.util.Arrays;

public class ArrayInArray {
	

	public static void main(String[] args) {
		
		/******** 2차원 배열 선언하는 방법 - 1 *******************/
		System.out.println("*** 2차원 배열 선언하는 방법 - 1 ***");
		
		
		int[][] m = new int[2][3]; // 2행 3열
		
		System.out.println(Arrays.toString(m[0])); // m[0](주소)가 참조하는 배열 객체의 값 출력
		System.out.println(Arrays.toString(m[1])); // 기본값으로 채워진 배열 객체 출력 [0,0,0]
		System.out.println(); // 구분용 빈 줄
		
		int i;
		for(i=0;i<m.length;i++) {
			System.out.println(Arrays.toString(m[i]));
		}
		System.out.println(); // 구분용 빈 줄
		
		//-------------------------------------------------------
		
		System.out.println("** 향상된 for문 : index 사용 안 함 (index로 접근해야만 하는 상황에서는 사용 못 함) **");
		
		
		for(int[] arr : m) {
			System.out.println(Arrays.toString(arr));
		}
		System.out.println(); // 구분용 빈 줄
		
		//-------------------------------------------------------
		// 위를 풀어내면 아래와 같음
		
		System.out.println("** for문 사용 안 하고 출력 **");
		System.out.print("[");
		System.out.print(m[0][0]+", "); // m[0] 주소의 배열로 가서 [0]인덱스 출력 // 기본값 0 출력
		System.out.print(m[0][1]+", "); 
		System.out.print(m[0][2]);
		System.out.println("]"); // 커서 아래로
		
		System.out.print("[");
		System.out.print(m[1][0]+", "); // m[1] 주소의 배열로 가서 [0]인덱스 출력
		System.out.print(m[1][1]+", ");
		System.out.print(m[1][2]);
		System.out.println("]"); // 커서 아래로
		
		System.out.println(); // 구분용 빈 줄
		
		System.out.println("** 배열의 값 변경 후 출력 **");
		
		m[0][0] = 95;
		m[0][1] = 100;
		m[0][2] = 87;
		
		m[1][0] = 83;
		m[1][1] = 92;
		m[1][2] = 78;
		
		
		for(int[] arr : m) {
			System.out.println(Arrays.toString(arr));
		}
		System.out.println(); // 구분용 빈 줄
		
		
		/*
		 * 12/17 과제 1
		 * 중첩된 for문을 이용하여 아래 내용 출력
		 * [98,100,87]
		 * [83,92,78] 
		 * 
		 */
		System.out.println("-----[과제1] : m이 참조하는 배열-----");
		
		int j;
		
		
		for(i=0; i<m.length; i++) {
			
			for(j=0; j<m[i].length; j++) {
				
				if( j == 0 ) {
					System.out.print( "[" + m[i][j] + "," );
				} else if ( j != m[i].length-1 ) {
				System.out.print(m[i][j]+",");
				} else {
					System.out.println(m[i][j]+"]");
				}
			}
		}
		 
		 
		 
		 
		 System.out.println();
		//---------------------------------------------------------------

		/******* 2차원 배열 선언하는 방법 - 2 ******************/
		System.out.println("*** 2차원 배열 선언하는 방법 - 2 ***");
		
		int[][] e = new int[2][]; // 값을 넣지 않으면 null로 채워짐
		System.out.println(Arrays.toString(e)); // e는 주소 , [null, null]
		
		e[0] = new int [2]; // [0,0]   (1반 2명) 학교의 반이라고 가정했을때
		e[1] = new int [3]; // [0,0,0] (2반 3명)
		
		try {//예외가 발생할 가능성이 있는 부분
			e[0][0] = 85; 
			e[0][1] = 99;
			e[0][2] = 77;  //예외객체 생성 -> JVM이 예외객체를 던져서
			
			e[1][0] = 88; // ★★ 아래부분을 실행하지 않음
 			e[1][1] = 100; 
			e[1][2] = 95; 
		} catch (Exception e1) { //잡아서
			e1.printStackTrace(); //처리
		}
		
		System.out.println(Arrays.toString(e[0]));
		System.out.println(Arrays.toString(e[1])); // 출력되나 [0,0,0]으로 나옴 => try 범위 잘 잡기
		
		
		// ↓ 해결방법 1 -----------------------------------------------------
		
		System.out.println("해결 1");
		
		try {//예외가 발생할 가능성이 있는 부분
			e[0][0] = 85; 
			e[0][1] = 99;
			e[0][2] = 77;  //예외객체 생성 -> JVM이 예외객체를 던져서
			
			
		} catch (Exception e1) { //잡아서
			e1.printStackTrace(); //처리
		}
		//★★실행되도록 try{}에서 빼냄
		e[1][0] = 88;
		e[1][1] = 100; 
		e[1][2] = 95; 
		
		System.out.println(Arrays.toString(e[0]));
		System.out.println(Arrays.toString(e[1]));
		
		// ↓ 해결방법 2 -----------------------------------------------------
		System.out.println("해결 2");
		
		try {//예외가 발생할 가능성이 있는 부분
			e[0][0] = 85; 
			e[0][1] = 99;
			e[0][2] = 77;  //예외객체 생성 -> JVM이 예외객체를 던져서
			
		} catch (Exception e1) { //잡아서
			e1.printStackTrace(); //처리       //예외가 발생했을때만 catch실행
		
		} finally { // 예외 발생 여부에 관계없이 try{} 영역에 진입하면 무조건 실행
			
			e[1][0] = 88; 
 			e[1][1] = 100; 
			e[1][2] = 95; 
			
		}
		
		System.out.println(Arrays.toString(e[0]));
		System.out.println(Arrays.toString(e[1]));
		
		System.out.println(); // 구분용 빈 줄

		System.out.println("---------[과제1-2] : e가 참조하는 배열---------"); //위 두줄도 중첩문으로 나타내기
		//[85, 99]
		//[88, 100, 95]

		for(i=0; i<e.length; i++) {
					
					for(j=0; j<e[i].length; j++) {
						
						if( j == 0 ) {
							System.out.print( "[" + e[i][j] + "," );
						} else if ( j != e[i].length-1 ) {
						System.out.print(e[i][j]+",");
						} else {
							System.out.println(e[i][j]+"]");
						}
					}
				}System.out.println();
		
		
		
		/******* 2차원 배열 선언하는 방법 - 3 **********************/
		System.out.println("***** 2차원 배열 선언하는 방법 - 3 *****");
		
		int[][] s = new int[2][];
		
		s[0] = new int[] {87,93}; // 기본값이 아닌 '초기값 배열' 생성
		s[1] = new int[] {97, 88, 100};
		
		System.out.println();
		System.out.println("---------[과제1-3] : s가 참조하는 배열---------");
		
		
		for(i=0; i<s.length; i++) {
			
			for(j=0; j<s[i].length; j++) {
				
				if( j == 0 ) {
					System.out.print( "[" + s[i][j] + "," );
				} else if ( j != s[i].length-1 ) {
				System.out.print(s[i][j]+",");
				} else {
					System.out.println(s[i][j]+"]");
				}
			}
		}System.out.println();
		
		
	
		/******* 2차원 배열 선언하는 방법 - 4 **********************/
		
		
		System.out.println("***** 2차원 배열 선언하는 방법 - 4 *****");
		int[][] java = {
				
				{95, 97},          // 1반 2명, java[0].legnth == 2
				{98, 100, 99, 75}, // 2반 4명, java[1].legnth == 4
				{100, 88, 92}      // 3반 3명, java[2].legnth == 3
		};
				

		
		/*
		 *  12/17 과제 2 
		 *  각 반의 java 성적의 합과 평균 구하기
		 *  java 성적의 총 합과 총 평균 구하기
		 *  중첩된 for문
		 */
		System.out.println();
		System.out.println("------------[과제2]------------");
		
		
		j=0;
		int sum=0;
		
		for(i=0; i<java.length; i++) {
			sum=0;
			for (j=0; j<java[i].length; j++ ) {
				sum += java[i][j];
			} System.out.println( "java[" + i + "]반 성적 합=" + sum + ", 평균=" + ((double)sum/j) );
		} 
		
		System.out.println();
		sum=0;
		
		for(i=0; i<java.length; i++) {
			for (j=0; j<java[i].length; j++ ) {
				sum += java[i][j];
			} 
		} System.out.println( "모든 반의 성적 총 합=" + sum + ", 총 평균=" + ((double)sum/j) );
		
		
		
		
		
		
		
		
		
		
	} // main
}