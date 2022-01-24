/*
 * ArrayList와 LinkedList에 10,000개의 객체를 삽입하는데 걸린 시간 측정
 * 
 * 	=> LinkedList가 빠른 성능을 낸다
 * 
 * 
 */


package list;

import java.util.ArrayList;
import java.util.LinkedList;

public class LinkedListArrayListExample {

	public static void main(String[] args) {
		
		//둘 다 사용 방법은 같지만 내부 구조는 다름
		ArrayList<String> list1 = new ArrayList<String>();
		LinkedList<String> list2 = new LinkedList<String>();

		//시간 측정을 위해 시작 시간과 끝 시간 변수 선언
		long startTime;
		long endTime;
	
		/********************* ArrayList **************************/
		startTime = System.nanoTime(); //시작 시간 = 나노타임 저장
		
		for(int i=0; i<10000; i++) {
			//(0,"0") -> (0,"1")(1, "0") -> (0,"2")(1,"1")(2,"0") 
			list1.add(0, String.valueOf(i)); //숫자 => 문자 변환 // list의 0번 index에 10000번 문자열이 바뀌며 저장됨
		}
		endTime = System.nanoTime(); //for문 수행 후, 끝 시간 = 나노타임 저장
		System.out.println("ArrayList 걸린 시간: " + (endTime-startTime) + "ns"); //ns = nanoSecond
	
	
		
		/*********** LinkedList : 특정 위치(앞,중간)에 삽입, 삭제할 때 더 빠름 **********/
		startTime = System.nanoTime(); //시작 시간 = 나노타임 저장
		
		for(int i=0; i<10000; i++) {
			//주소로 앞 뒤를 연결
			list2.add(0, String.valueOf(i)); //숫자 => 문자 변환 // list의 0번 index에 10000번 문자열이 바뀌며 저장됨
		}
		endTime = System.nanoTime(); //for문 수행 후, 끝 시간 = 나노타임 저장
		System.out.println("LinkedList 걸린 시간: " + (endTime-startTime) + "ns"); //ns = nanoSecond
		//결과는 CPU의 상황에 따라 달라짐
		
	
	
	
	
	
	
	
	
	}

}