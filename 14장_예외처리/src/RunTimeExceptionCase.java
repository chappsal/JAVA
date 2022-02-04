/*
 * 오류?
 * 1. 컴파일 오류 : 문법적인 오류
 * 2. 실행 오류 
 * 		(1) 시스템 오류 (Error 클래스) : JVM에서 발생 (ex)메모리에 문제 -> 프로그램에서 제어 불가
 * 		(2) Exception 클래스 (예외) : 프로그램에서 제어 가능
 * 		
 * 		※ 교재 488p 아래 그림 참조 
 *  	- Exception 클래스의 자식 클래스들은 예외 처리해야 함
 *  	- 그러나 , RunTimeException(실행 오류 예외)는 프로그래머의 실수로 발생하는 예외이므로
 *  	  try~catch()로 처리하는 것보다 실수를 수정하는 방법으로 해결하는 것이 더 좋다
 *  
 *  
 * ★ 예외 처리 방법 1
 * 	try {
 *    예외 발생 가능성 
 * 	} catch(Exception e) { //모든 예외의 부모
 *    예외 처리
 *  } finally {
 *    무조건 실행 (예외 발생 유무에 관계 x)
 *  }
 *  
 *  
 */

public class RunTimeExceptionCase {

	public static void main(String[] args) {
		System.out.println("****** 예외를 각각 처리 ******");

		try {
			int[] arr = new int[3]; // 기본값 0 0 0 
			arr[3] = 20;			// index는 2까지 => 예외 발생 (ArrayIndexOutOfBoundsException)
			System.out.println("예외 발생하면 실행되지 않는 부분");
		} catch (Exception e) { //잡아서
			//e.printStackTrace(); // '예외 객체 종류 + e.getMessage()를 호출한 결과 + 예외 발생 전달 경로' 출력
			//System.out.println(e); // '예외 객체 종류 + e.getMessage()를 호출한 결과' 출력
			//System.out.println(e.getMessage()); // 'e.getMessage()를 호출한 결과 ' 출력
			System.out.println("배열의 범위를 넘어섬");
		} finally {
			System.out.println("예외 발생 유무에 관계없이 무조건 처리");
		}
		
		
		System.out.println();
		
		
		try {
			Object obj = new int[10]; //배열객체 -> Object 타입으로 자동 형 변환
			String str = (String) obj; //ClassCastException
			System.out.println("예외 발생하면 실행되지 않는 부분");
		} catch (Exception e) { 
			System.out.println("문자열로 형 변환이 안 됩니다.");
		} finally {
			System.out.println("예외 발생 유무에 관계없이 무조건 처리");
		}
		
		
		System.out.println();
		
		
		try {
			int[] arr2 = new int[-10]; // NegativeArraySizeException
			System.out.println("예외 발생하면 실행되지 않는 부분");
		} catch (Exception e) { 
			System.out.println("배열의 크기를 음수로 할 수 없습니다.");
		} finally {
			System.out.println("예외 발생 유무에 관계없이 무조건 처리");
		}
		
		
		System.out.println();
		
		
		try {
			String str2 = null;
			int len = str2.length(); //NullPointerException
			System.out.println("예외 발생하면 실행되지 않는 부분");
		} catch (Exception e) { 
			System.out.println("문자열 객체가 없는 null 상태입니다.");
		} finally {
			System.out.println("예외 발생 유무에 관계없이 무조건 처리");
		}
		
		
		
		//--------------------------------------------------------------------
		
		System.out.println();

		System.out.println("****** 예외를 하나의 try로 묶어서 처리 ******");
		
		
		int j = 3, size = -10;
		
		for(int i=1; i<=4; i++) {
			
			try {
				int[] arr = new int[3]; // 기본값 0 0 0 
				arr[j] = 20;			// 예외 발생 (ArrayIndexOutOfBoundsException)
				System.out.println("예외 발생하면 실행되지 않는 부분");
				
				Object obj = new int[10]; //배열객체 -> Object 타입으로 자동 형 변환
				//String str = (String) obj; //ClassCastException
				System.out.println("예외 발생하면 실행되지 않는 부분");
				
				int[] arr2 = new int[size]; // NegativeArraySizeException
				System.out.println("예외 발생하면 실행되지 않는 부분");
				
				String str2 = null;
				int len = str2.length(); //NullPointerException
				System.out.println("예외 발생하면 실행되지 않는 부분");
				
			} //RuntimeException의 자손들 대표 - 4가지 
			
			catch(ArrayIndexOutOfBoundsException e) { //자식예외가 부모보다 먼저
				System.out.println("배열의 범위를 넘어섬");
				j=0;
				continue; //생략 가능하나 결과 다름 , finally는 실행하나 그 아래의 명령문은 실행 안 됨
				
			} catch(ClassCastException e) {
				System.out.println("문자열로 형 변환이 안 됩니다.");
				continue;
				
			} catch(NegativeArraySizeException e) {
				System.out.println("배열의 크기를 음수로 할 수 없습니다.");
				size = 10;
				continue;
				
			} catch (NullPointerException e) {
				System.out.println("문자열 객체가 없는 null 상태입니다.");
				continue;
				
			} catch (RuntimeException e) { //RuntimeException : 위 4가지 예외를 제외한 자손들
				System.out.println(e);
				continue;
				
			} catch (Exception e) {	//제일 아래는 부모
				e.printStackTrace();
				continue;
			} 
			
			System.out.println("[for문의 끝]");
	
		} //for문
		
		System.out.println("****** 예외 처리 종료 ******");
		
		
		
		
		/*
		System.out.println("***** 예외를 하나의 try로 묶어서 처리 -2*****");		
		
		for(int i=1;i<=4;i++) {
			try {
				switch(i) {
				case 1 :
					int[] arr = new int[3];//index 0 1 2 (기본값 0 0 0)
					arr[3] = 20;//ArrayIndexOutOfBoundsException 발생하면
					System.out.println("예외가 발생하면 실행되지 않는 부분");
					break;
				
				case 2 :
					Object obj = new int[10];//배열객체 -> Object타입으로 자동형변환
					String str = (String) obj;//ClassCastException
					System.out.println("예외가 발생하면 실행되지 않는 부분");
					break;
				
				case 3 :
					int[] arr2 = new int[-10];//NegativeArraySizeException
					System.out.println("예외가 발생하면 실행되지 않는 부분");
					break;
				
				case 4 :
					String str2 = null;
					int len = str2.length();//NullPointerException
					System.out.println("예외가 발생하면 실행되지 않는 부분");
					break;
				}
				
			} //RuntimeException의 자손들 대표 - 4가지
			  catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("배열의 범위를 넘어섬");
				continue; //생략해도 되나 결과가 달라짐 : finally는 무조건 실행하나 [for문의 끝] 실행안됨
			} catch (ClassCastException e) { 			
				System.out.println("문자열로 형변환이 안됩니다.");
				continue; 
			} catch (NegativeArraySizeException e) {	
				System.out.println("배열의 크기를 음수로 할 수 없습니다.");				
				continue; 
			} catch (NullPointerException e) {	
				System.out.println("문자열 객체가 없는 null 상태입니다.");
				continue; 
			} //RuntimeException은 Exception의 자손	
			  catch (RuntimeException e) { //RuntimeException : 위의 4가지 제외한 RuntimeException의 자손들
				System.out.println(e);
				continue; 
			} catch (Exception e) { //가장 아래는 부모인 Exception
				e.printStackTrace();
				continue; 
			} 			
			System.out.println("[for문의 끝-2]");
		}
		 */
		
		
		
		
		
		
	}

}
