package copyrandom;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayCopyRandomExample {

	public static void main(String[] args) {
		/** 정수형 배열 **/
		int[] a1 = new int[5]; // [0, 0, 0, 0, 0] 기본값으로 채워짐
		//모두 초기값 2로 변경
		System.out.println("** 모두 초기값 2로 변경-1 **");
		a1[0]=2; //모두 다른 값으로 채울 때는 이 방법만 가능 (규칙성 x), 혹은 반복문으로 사용자에게 입력 받게 함
		a1[1]=2; 
		a1[2]=2; 
		a1[3]=2; 
		a1[4]=2; 
		
		System.out.println("** 모두 초기값 2로 변경-2 **");
		int i;
		for(i=0; i<a1.length; i++) {
			a1[i]=2;
		}
			
		System.out.println("** 모두 초기값 2로 변경-3 **");
		Arrays.fill(a1, 2); //a1이 참조하는 배열 값을 2로 채움(모두 같은 값으로 채울 때 많이 사용)
		System.out.println(Arrays.toString(a1));
			
			
		//1~10사이의 정수 값을 랜덤으로 출력
		System.out.println("1~10사이의 정수 값을 랜덤으로 채움");
		for(i=0;i<a1.length;i++) {
			a1[i]=(int)(Math.random()*10)+1;
		}
		System.out.println(Arrays.toString(a1));
		
		
		/*
		 *       0.0       <= 	    Math.random()    < 1.0        : 범위의 실수 값  (ex. 0.000123 , 0.1등) 
		 *       0.0*10    <= 	    Math.random()*10 < 1.0*10
		 *       0.0	   <= 	    Math.random()*10 < 10.0       : 실수 값 (ex. 7.42345, 9.9999등)
		 *  (int)0.0	   <= (int)(Math.random()*10)< (int)10.0  
		 *         0       <= (int)(Math.random()+1) < 10         : (ex. 0,1,2...9)
		 *         0+1     <= (int)(Math.random()+1) < 10+1       : (ex. 1,2,3...10)
		 *         
		 *         
		 *  ★공식: (int)(Math.random()*몇 개)+시작하는 정수
		 */
		
		
		System.out.println("11~29사이의 정수 값을 랜덤으로 채움");
		for(i=0;i<a1.length;i++) {
			a1[i]=(int)(Math.random()*(20-11+1))+11;
		}
		System.out.println(Arrays.toString(a1));
				
		
		System.out.println("88~101사이의 정수 값을 랜덤으로 채움");
		for(i=0;i<a1.length;i++) {
			a1[i]=(int)(Math.random()*(101-88+1))+1;
		}
		System.out.println(Arrays.toString(a1));
		
			
		/** 문자형 배열 **/	
			
		char[] ch = new char[3]; // 기본값 '\0','\0','\0' = null로 채워짐
		System.out.println(Arrays.toString(ch));
		
		
		Arrays.fill(ch, 'A');
		System.out.println(Arrays.toString(ch));
		

		//for문을 이용하여 항목 값을 모두 'a'로 변경 후 출력
		
		
		for(i=0; i<=ch.length; i++) {
			//ch[i] = (char)(ch[i]+32);
			//ch[i]+=32; // 복합 대입 연산자를 사용하면 형 변환 필요 없음
		}
		System.out.println(Arrays.toString(ch));
		
		
		/*
		 * 배열 복사 방법 4가지
		 * 
		 * 배우는 이유? 배열은 크기가 최초에 한 번 정해지면 변경 불가
		 */
			
		char[] arr = {'J', 'A', 'V', 'A'}; // arr.length==4	
			
		
		System.out.println("** 배열 복사 방법-1 **");
		char[] arr1 = new char[arr.length+2]; // null문자로 채워짐 (='\0')
		
		for(i=0; i<arr.length ; i++) {
			arr1[i]=arr[i];
		}
		System.out.println(Arrays.toString(arr1));
			
		
		System.out.println("** 배열 복사 방법-2 **");
		char[] arr2 = new char[arr.length+2]; // null문자로 채워짐 (='\0')
		
		//void arraycopy(원본, 원본의 시작 index, 도착지, 도착지의 시작 index, 복사할 개수) // void => 돌려주는 값 x
		System.arraycopy(arr, 0, arr2, 0, arr.length);
		System.out.println(Arrays.toString(arr2));
			
		
		System.out.println("** ★배열 복사 방법-3 **");
		char[] arr3 = null; // 값이 없다는 뜻. null문자로 채워지는 것x 
		
		
		//char[] copyOf(원본, 새로운 배열 객체의 길이) // char 타입으로 돌려줌
		arr3 = Arrays.copyOf(arr, arr.length+2); // copyOf 에 마우스 올리면 돌려주는 타입 뜬다
		
		System.out.println(Arrays.toString(arr3));
		
		
		System.out.println("** ★배열 복사 방법-4 (원하는 부분만 복사하여 배열 객체 생성) **");
		char[] arr4 = null;
		
		//T[] : 타입이 결정되지 않았음. 객체가 생성될 때 타입 결정 됨
		//T[] copyOfRange(원본, 복사할 시작 index, 복사할 끝 index+1) T:타입이 결정되지 않음, 원본 타입에 따라 돌려주는 값이 달라짐
		arr4 = Arrays.copyOfRange(arr, 1, 2+1); // 'A','V' (인덱스 1~인덱스2까지 복사) // 자바의 거의 모든 인덱스는 두 값이 나란히 있을때 뒤에 +1 해줘야 함
		
		System.out.println(Arrays.toString(arr4));
		
		
		/*
		 *  [12/20] 과제 1
		 *  키보드로 증가할 배열 크기를 입력 받아 새 배열 생성 (2를 입력하면 2 더 늘어남)(기본값으로 채워짐)
		 *  기존 배열 arr을 복사하여 새 배열에 대입
		 *  기본 값으로 채워진 곳은 사용자가 입력한 값으로 채움
		 *  최종 출력
		 *  ['J', 'A', 'V', 'A',   ,   ,   ] => ['J', 'A', 'V', 'A', ! , ~ , * ] 
		 */
		int num = arr.length;
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("배열 크기를 입력하세요>");
		int arrSize = sc.nextInt();
		char[] newArr = Arrays.copyOf(arr, arr.length+arrSize);
		

		for(i=1; i<=arrSize; i++) {
			System.out.print("배열에 추가할 값을 입력하세요>");
			String str = sc.next();
			char ch2 = str.charAt(0);
			
			ch2='\0';
		}
		
		System.out.println(Arrays.toString(newArr));
		
		
			
	}//main



}