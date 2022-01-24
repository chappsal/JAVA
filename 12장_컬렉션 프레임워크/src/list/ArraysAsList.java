/*
 * ArrayList : 배열처럼 선언과 동시에 초기화 불가능하다. (기본값인 null로 채워짐)
 * 				그러나 추가, 삭제 등은 메서드를 통해 쉽게 해결 가능
 * 
 * Arrays	 : 배열을 조작하기 위한 클래스
 * 				배열처럼 선언과 동시에 초기화 가능
 * 				그러나 추가, 삭제를 위한 메서드가 없음
 * 
 * 그래서 배열처럼 '선언과 동시에 초기화'되면서
 * ArrayList처럼 '추가, 삭제  메서드를 사용'할 수 있도록
 * 아래 소스에서 방법을 알려줌
 * 
 * ArrayList도 선언과 동시에 초기화하는 방법 (5장 BookArrayListMain.java)
 * 
 * [정리]
 * ArrayList 이용하여 객체 관리 - 삭제, 추가 편리 
 * 초기화가 안되는 단점       
 * 해결법: Arrays.asList() 메서드 사용하여 초기화 가능
 * (배열은 초기화가 가능 ex. int[] arr = {1,2,3})
 * 
 * 
 */


package list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysAsList {

	public static void main(String[] args) {
		/*
		 * 1. Arrays.asList() 이용하여 순차적으로 입력된 값 (초기 값)으로 "고정된 List객체" 생성
		 * (아직 추가, 삭제 메서드 사용 불가. ★why? 고정된 크기의 객체여서 크기를 줄이거나 늘릴 수 없으므로)
		 */
		
		List<String> list1 = Arrays.asList("최희윤","박미현","정혜정"); //초기화
		System.out.println("저장된 총 객체 수 : " + list1.size());
		
		System.out.println(list1.get(0) + "\n"); 
	
		for(String str : list1) {
			System.out.println(str);
		}
		System.out.println();
		
		int i;
		for(i=0; i<list1.size(); i++) {
			System.out.println(list1.get(i));
		}
		System.out.println();
		
		//------------------------------------------------------------
		
		
		try {
			list1.add("박영현"); //추가 => 예외 발생 => 프로그램 강제 종료 
			list1.remove(0);   //삭제 => 예외 발생 => 프로그램 강제 종료 
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println(e); //java.lang.UnsupportedOperationException
		}
		System.out.println();
		
		
		//------------------------------------------------------------
		
		
		/*
		 * 2. 위에서 만들어진 List 객체로  ArrayList 객체를 생성하여 
		 * 		추가, 삭제 메서드를 사용할 수 있게 한다.
		 */
		
		list1 = new ArrayList<String>(list1); //초기화  + 추가, 삭제 메서드 등 사용 가능
		list1.add("박영현"); //추가
		System.out.println("저장된 총 객체 수 : " + list1.size());
		
		System.out.println("index 0에 저장된 문자열 삭제 : " + list1.remove(0)); //삭제
		
		for(String str : list1) {
			System.out.println(str);
		}
		System.out.println();
		
		System.out.println("--------------------------------------");
		
		List<Integer> list2 = Arrays.asList(1,2,3); //기본타입(int)을 -> (자동) autoBoxing하여 Integer 타입으로 변환
		List<Integer> list3 = Arrays.asList(new Integer(1), new Integer(2), new Integer(3)); //자동 Boxing
		
		System.out.println("[ Integer객체 -> 자동 unBoxing -> 기본타입(int)로 변환 ]");
		for(int value : list3) {
			System.out.print(value);
		}
		System.out.println();
		
		//추가, 삭제 메서드 사용하기 위해
		list3 = new ArrayList<Integer>(list3);
		list3.add(4);				//기본타입(int)을 -> (자동) autoBoxing하여 Integer 타입으로 변환
		list3.add(new Integer(5));	
		
		System.out.println("index 0에 저장된 정수 삭제 : " + list3.remove(0)); //삭제
		
		for(int value : list3) {
			System.out.print(value);
		}
		System.out.println();
		
		
		
		
		
		
		
		
		
	}

}



