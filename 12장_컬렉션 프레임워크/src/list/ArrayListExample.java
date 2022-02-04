/*
      컬렉션 프레임워크 : 배열의 문제점을 해결하고 널리 알려진 자료구조를 바탕으로
   				'객체들을 효율적으로 추가, 삭제, 검색'할 수 있도록
   				java.util 패키지에 컬렉션과 관련된 인터페이스와 클래스들을 포함 시켜놓고
   				이들을 총칭해서 '프레임워크'라고 부름
   				(반드시 객체만 관리)
   
   					'Collection' 인터페이스  							Map 인터페이스
   						  |												 |
   		 	|--------------------------|						키와 값의 쌍(=엔트리)으로 저장
   		List 인터페이스				  Set 인터페이스					  키: 중복 x , 값: 중복 o 
   	  	 	|						   |								 |	 
      배열과 유사하여 index로 관리			  index로 관리 x						        클래스
    -> 순서를 유지하면서 저장			-> 순서없이 저장								 
   	         중복 저장 가능				   중복 저장 불가(집합)						  HashMap	: 싱글스레드
 			|						   |							  HashTable : 멀티스레드
 		     클래스						   클래스							  TreeMap
  		ArrayList					HashSet
  		Vector						TreeSet
 		LinkedList
 		
  -------------------------------------------------------------------------------------- 	
 	List 인터페이스를 구현한 클래스
	<공통점> 1. 배열과 유사하여 index로 관리 => 순서를 유지하여 저장
			  => for문 사용 가능
		   2. (같은 객체)중복 저장 가능
		   
	1. ArrayList  : 1) 앞에서부터 차례대로 추가, 검색할 때 효율적
				    2) 중간에 추가, 삭제가 빈번히 일어나는 곳에서 비효율적 => 속도 느림
				   	  '싱글 쓰레드'에 사용
	2. Vector	  : 1)2)ArrayList 특징과 같다 (단, 멀티 쓰레드에 사용)
	
	3. LinkedList : 1) 앞에서부터 검색할 때 비효율적
					2) 중간에 추가, 삭제가 빈번히 일어나는 곳에서 효율적 => 속도 빠름
	
 */


package list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class ArrayListExample {

	public static void main(String[] args) {
		/*
		 * 부모 인터페이스 = 자식 객체가 부모 타입(List)으로 자동 형 변환되어 대입
		 * 
		 * 컴파일러 입장 : 모든 자식 객체들을 부모 타입인 List로 인식하여
		 * 			  List에 선언된 추상 메서드만 호출 가능
		 * 
		 * 그런데 자식 클래스들은 클래스의 특징에 맞게 추상 메서드를 재정의하였으므로
		 * 재정의 메서드가 호출됨
		 * 
		 */
		
		List<String> list = new ArrayList<String>(); //List로 해두면 앞뒤로 바꾸기만 하면 됨, 편리 => 부모 타입으로 받는 이유
		//ArrayList<String> list = new ArrayList<String>(); //10개의 공간이 생김
		//Vector<String> list = new Vector<String>(); 
		//LinkedList<String> list = new LinkedList<String>(); 
		
		
		for(String str : list) {
			System.out.println(str);
		} //출력값 x 모두 null로 채워져있기때문
		
		System.out.println("---- 추가 후 값을 얻기 ----");
		
		list.add("여러분~");   //0
		list.add("힘내세요~");  //1
		list.add("^^");		 //2
		
		list.add(1, "모두"); // 1->2 , 2->3 // Set계통에는 이 메서드 없음 (index가 없으므로)
		list.add("여러분~");  //중복 허용 //Set계통에서는 비허용 
		
		System.out.println("저장된 총 객체 수 : " + list.size());
		System.out.println(); 
		
		if(list.contains("모두")) { //주어진 객체가 저장되어 있으면 true
			System.out.println("\"모두\"가 존재한다.");
		} else System.out.println("\"모두\"가 존재하지 않는다.");
		
		System.out.println();
	
		//get(index) : 해당 index의 값 얻기 => Set계통에는 이 메서드 없음 (index가 없으므로)
		System.out.println("index 2의 값 : " + list.get(2));
		System.out.println();
		
		
		System.out.println("---- for문으로 모든 객체 값 출력 ----");
		int i;
		for(i=0; i<list.size(); i++) { //size는 length보다 효율적 
			System.out.println("index " + i + "의 값 : " + list.get(i));
		}
		System.out.println();
		
		
		System.out.println("---- 향상된 for문으로 모든 객체 값 출력 ----");
		for(String str : list) {  // index를 사용하지 않으므로 Set계통에서 사용
			System.out.println(str);
		}
		System.out.println();
		
		
		System.out.println("-- 삭제-1 (index 이용)--"); //Set계통에 없음 (index 없음)
		System.out.println("index 1에 저장된 삭제한 문자열 : " + list.remove(1));
		System.out.println();
		for(i=0; i<list.size(); i++) { //size는 length보다 효율적 
			System.out.println("index " + i + "의 값 : " + list.get(i));
		}
		System.out.println();
		
		
		System.out.println("-- 삭제-2 (Object 이용 : 객체)--");	// index를 사용하지 않으므로 Set계통에서 사용
		if(list.remove("정말~")) System.out.println("찾아서 있으면 삭제 후 true -> 삭제됨");
		else System.out.println("찾아서 없으면 false -> 삭제 안 됨");
		
		
		//remove(Object) : Object 타입이므로 모든객체 다 수용. but, String 이외 객체는 노란줄로 경고 띄움
		if(list.remove(new Integer(13))) System.out.println("찾아서 있으면 삭제 후 true -> 삭제됨");
		else System.out.println("찾아서 없으면 false -> 삭제 안 됨");
		System.out.println();
		
		
		System.out.println("-- 모두 삭제 --");
		if(list.removeAll(list)) System.out.println("모두 삭제");
		else System.out.println("모두 삭제 안 됨");
		
		list.clear(); //Clear()로 모두 삭제하면 void이므로 삭제되었는지 확인하려면
		
		//방법 1
		System.out.println("저장된 총 객체 수 : " + list.size());
		
		//방법 2
		if(list.isEmpty()) System.out.println("저장된 객체가 없음"); //저장된=관리하는=참조하는
		else System.out.println("저장된 객체가 있음");
		
		
	}

}
