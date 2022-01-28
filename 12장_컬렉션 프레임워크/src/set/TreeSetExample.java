/*
   [HashSet과 TreeSet]
   
         ※ 공통점 : Set 계통이므로 모두 중복을 허용하지 않고 순서가 없는 컬렉션이다
   
   (1) 구현 방식   - HashSet : 해싱을 이용하여 구현 (해싱: 분류하여 검색하는 것)
   			  - TreeSet : 이진 탐색 트리를 이용하여 구현
   
   (2) 속도 비교   - HashSet > TreeSet
   			  - 해싱이 이진 탐색 트리보다 빠름
   			  - 해시 값을 이용하여 검색하기 때문에 검색하는 범위가 엄청 줄어들게 되어 검색 속도가 매우 빠름
   				(HashSet은 Set에서 가장 빠른 데이터 접근 속도를 가지고 있다)
   				
   (3) 정렬 기능   - HashSet < TreeSet
   			  - 이진 탐색 트리를 이용했기 때문에 데이터 정렬 가능 (Comparable 인터페이스 이용)
   
   ------------------------------------------------------------------
       이지스 교재 428p~
   
   3. TreeSet : 이진 트리를 기반으로 검색 기능을 강화 	(ex) 검색과 관련된 메서드들 : first()...
   				저장과 동시에 '오름차순'으로 자동 정렬 	(ex) 숫자(Integer, Double..등) 타입일 경우 : 값으로 정렬
   				 								  문자열(String) 타입일 경우 : 유니코드 값으로 정렬
   
   				그러나, 우리가 만든 '사용자 정의 클래스'는 정렬이 안되므로 [객체(데이터)를 정렬된 순서로 저장하기 위해]
   				1. 'java.lang.comparable<T> 인터페이스'를 구현해야 함
   				2. 추상 메서드인 compareTo() 메서드를 재정의
   				
   				TreeSet의 add() 호출하면 compareTo() 자동 호출되어 
   				크기를 비교하며 중복 여부를 알 수 있기 때문에 
   				(크기 비교시 값이 같으면 0을 반환, 같은 객체가 이미 존재한다고 간주 -> 추가 안 됨)
   				hashCode()와 equals()를 재정의 안 해줌	(※ hashCode()와 equals() 역할 : 객체 중복 여부 확인)
   
   	※ TreeSet 정리 : 자료의 중복을 허용하지 않으면서 출력 결과를 정리하는 클래스
   				   Tree~ 로 시작하는 클래스들은 객체를 추가한 후 결과 출력시 값이 정렬됨 
   				   
   ------------------------------------------------------------------ 
     
   String이나 Integer등 제공받은 클래스는 Comparable 인터페이스를 이미 구현하여
       재정의된 CompareTo()로 오름차순 정렬되어 추가됨
   
       그런데 내림차순으로 바꾸고 싶은 경우에는 어떻게 해야 하는지?
   String이나 Integer 클래스의 경우 final로 선언되어 있어 
   compareTo()를 상속받아 내림차순 정렬로 재정의 불가
       이러한 경우 Comparator 인터페이스를 구현하여 compare()를 내림차순 정렬로 재정의 후 사용하면 해결
    
       우리가 만든 사용자 정의 클래스는 Comparable<T> 인터페이스와 Comparator<T> 인터페이스를 함께 구현하여
   compareTo()로 '오름차순 정렬'되도록 재정의, compare()로 '내림차순 정렬'되도록 재정의하면 된다
    
           ※ Comparator 사용 시 유의점 : TreeSet 생성자에 Comparator를 구현한 객체를 매개변수로 전달해야 함
           
   ------------------------------------------------------------------   
   
   'TreeSet으로 관리하는 객체'와 'TreeMap에서 관리하는 Entry의 키 값'은 저장과 동시에 자동 오름차순 정렬
   (단, String이나 Integer등 제공 받은 클래스는 오름차순 정렬되어 있음)
   
   
 */


package set;

import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetExample {

	public static void main(String[] args) {
		TreeSet<Integer> treeSet = new TreeSet<Integer>();
		
		treeSet.add(new Integer(87));
		treeSet.add((95)); // 자동 boxing
		treeSet.add((78));		
		treeSet.add((98));
		treeSet.add((80));
		treeSet.add((83));
		
		treeSet.add((78)); // Set계열은 중복 허용 x => 추가 안 됨
		
		System.out.println("저장된 총 객체 수 : " + treeSet.size()); // 6
		System.out.println();
		
		System.out.println("** treeSet 객체의 주소만  **"); 
		System.out.println("오름차순: " + treeSet); //treeSet.toString() 호출 -> 저장된 각 개체의 toString() 호출
		System.out.println("내림차순: " + treeSet.descendingSet()); //NavigableSet<Integer>
		//출력값 [78, 80, 83, 87, 95, 98] 오름차순 정렬된 결과
		
		System.out.println();
		
		
		/************************************************************************************/
		
		
		System.out.println("------------ 검색과 관련된 메서드들 --------------");
		System.out.println();
		
		System.out.println("가장 낮은 객체 리턴 (=가장 낮은 점수) : " + treeSet.first()); // 78
		System.out.println("가장 높은 객체 리턴 (=가장 높은 점수) : " + treeSet.last());  // 98
		System.out.println();
		
		System.out.println("주어진 객체 95보다 바로 아래(작은) 객체 리턴 : " + treeSet.lower(95)); // 87
		System.out.println("주어진 객체 95보다 바로 위(큰) 객체 리턴 : " + treeSet.higher(95)); // 98
		System.out.println();
		
		System.out.println("주어진 객체 96과 같은 객체가 있으면 리턴, 없으면 96보다 바로 아래 객체 리턴 : " + treeSet.floor(96));		
		System.out.println("주어진 객체 94와 같은 객체가 있으면 리턴, 없으면 94보다 바로 위 객체 리턴 : " + treeSet.ceiling(94));
		System.out.println();
		
		System.out.println("------------ 범위 검색과 관련된 메서드들 --------------");
		System.out.println();
		
		
		/*
		 * SortedSet<E> subSet(E fromElement, E toElement)
		 * 						시작(포함)~끝 이전까지의 부분 집합 반환
		 * 
		 * NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive)
		 * 							     시작			        시작 포함 여부			 끝		  		끝 포함 여부
		 * 							시작(포함 여부 선택) ~ 끝(포함 여부 선택) 까지의 부분 집합 반환
		 * 							포함 o: true / 포함 x: false
		 * 
		 * 
		 * 
		 * ※ 주의해야 할 점은, 
		 * subSet 메소드의 내부에서 원본 set의 데이터들을 복사해서 새로 부분 집합을 구성하는 것이 아니라,
		 * 원본 데이터들을 그대로 두고, 원본 set과 subSet이 같이 바라보고 있는 상태에서
		 * subSet은 해당 범위만 바라볼 수 있는 형태로 되어 있다는 것이다.
		 * 
		 * 이에 따라, subSet 메소드 후에 원본 set이나 subSet에 변경이 일어나면 (추가,삭제 등)
		 * 원본 set, subSet 모두 변경이 동시에 일어남.
		 * (단, subSet은 해당 범위만 보여짐)
		 * 
		 */
		
		
		SortedSet<Integer> treeSetSub1 = treeSet.subSet(78, 95); // 95이전까지
		System.out.print("78 <= 찾는 점수 < 95 : ");
		
		for(Integer i : treeSetSub1) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		
		NavigableSet<Integer> treeSetSub2 = treeSet.subSet(78, true, 95, true); //95포함
		System.out.print("78 <= 찾는 점수 <= 95 : ");
		
		for(Integer i : treeSetSub2) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println("---------------------------------------------");
		
		
		System.out.println("**** [오름차순 Iterator 리턴] ****");
		Iterator<Integer> itr = treeSet.iterator(); //오름차순 반복자
		while(itr.hasNext()) {
			System.out.print(itr.next() + " "); //Integer(87)의 toString() 호출 결과 출력
		} 
		System.out.println("\n");

		
		System.out.println("**** [내림차순 Iterator 리턴] ****");
		Iterator<Integer> ditr = treeSet.descendingIterator(); //내림차순 반복자
		while(ditr.hasNext()) {
			System.out.print(ditr.next() + " "); 
		}
		System.out.println("\n");
		
		
		/************************************************************************************/
		
		
		System.out.println("**** [내림차순으로 정렬된 NavigableSet을 리턴] ****");
		System.out.println();
		
		NavigableSet<Integer> dSet = treeSet.descendingSet();
		
		System.out.println("1. 향상된 for 이용 ");
		for(Integer score : dSet) {
			System.out.print(score + " ");
		}
		System.out.println("\n");
		
		System.out.println("2. Iterator(=반복자) 이용 ");
		Iterator<Integer> dSetitr = dSet.iterator(); //반복자 , 이미 Set이 정렬되어있기 때문에 그대로 가져옴
		while(dSetitr.hasNext()) {
			System.out.print(dSetitr.next() + " "); //next() : 지팡이로 가리킴
		}
		System.out.println("\n");
		
		
		
		System.out.println("**** [내림차순으로 정렬된 NavigableSet을 descendingSet()으로 한 번 더 호출하면 오름차순 정렬] ****");
		NavigableSet<Integer> aSet = dSet.descendingSet(); //내림차순 정렬 한 번 더 하면 => 오름차순 정렬
		
		System.out.println("1. 향상된 for 이용 ");
		for(Integer score : aSet) {
			System.out.print(score + " ");
		}
		System.out.println("\n");
		
		System.out.println("2. Iterator(=반복자) 이용 ");
		Iterator<Integer> aSetitr = aSet.iterator(); //반복자 , 이미 Set이 정렬되어있기 때문에 그대로 가져옴
		while(aSetitr.hasNext()) {
			System.out.print(aSetitr.next() + " "); //next() : 지팡이로 가리킴
		}
		System.out.println("\n");
		

		/************************************************************************************/
		
		
		//pollFirst : 제일 낮은 객체부터 꺼내오고 treeSet 컬렉션에서 제거
		System.out.println("제일 낮은 객체부터 꺼내오며 제거한 순서 : ");
		while(!treeSet.isEmpty()) { //비어있지 않는 동안 반복
			System.out.print(treeSet.pollFirst() + " "); //제일 낮은 객체부터 꺼내오고 treeSet 컬렉션에서 제거
		}
		System.out.println();
		if(treeSet.isEmpty()) System.out.println("모두 삭제되어 비어있음");
		else System.out.println("비어있지 않음");
		
	
		
		//pollLast : 제일 높은 객체부터 꺼내오고 treeSet 컬렉션에서 제거
		System.out.println("제일 높은 객체부터 꺼내오며 제거한 순서 : ");
		while(!treeSet.isEmpty()) { 
			System.out.print(treeSet.pollLast() + " "); 
		}
		System.out.println();
		if(treeSet.isEmpty()) System.out.println("모두 삭제되어 비어있음");
		else System.out.println("비어있지 않음");
		
		System.out.println();

		
		/************************************************************************************/
	
		
		System.out.println("------------- [범위 검색] -------------------------------");
		
		TreeSet<String> treeSet2 = new TreeSet<String>();
		treeSet2.add("banana");		
		treeSet2.add("cherry");
		treeSet2.add("apple");
		treeSet2.add("black");		
		treeSet2.add("school");
		treeSet2.add("door");		
		treeSet2.add("element");
		
		System.out.println(treeSet2); // 오름차순 정렬되어 있음
		System.out.println();
		
		
		System.out.print("b ~ e 사이의 단어 검색 : ");
		NavigableSet<String> set = treeSet2.subSet("b", true, "e", true);
		System.out.println(set); // [banana, black, cherry, door]

		
		System.out.println();
		
		
		System.out.println("[banana]");
		
		//headSet 기본값 : false
		System.out.print("지정된 객체보다 작은 값의 객체 리턴 [방법 1] : ");
		SortedSet<String> set2 = treeSet2.headSet("banana"); 
		System.out.println(set2); // [apple]

		System.out.print("지정된 객체보다 작은 값의 객체 리턴 [방법 2] : ");
		SortedSet<String> set2_2 = treeSet2.headSet("banana", false); 
		System.out.println(set2_2); // [apple]

		System.out.print("지정된 객체를 포함하여 보다 작은 값의 객체 리턴 : ");
		SortedSet<String> set2_3 = treeSet2.headSet("banana", true); 
		System.out.println(set2_3); // [apple, banana]

		
		System.out.println();
		
		System.out.println("[bz]");
		
		//나열 순서가 사전과 같다고 생각하면 됨
		System.out.print("지정된 객체보다 작은 값의 객체 리턴 [방법 1] : ");
		SortedSet<String> set2_4 = treeSet2.headSet("bz"); // bz, ba ..등 확인해보기
		System.out.println(set2_4); // [apple, banana, black]
		
		System.out.print("지정된 객체보다 작은 값의 객체 리턴 [방법 2] : ");
		SortedSet<String> set2_5 = treeSet2.headSet("bz", false); 
		System.out.println(set2_5); // [apple, banana, black]
		
		System.out.print("지정된 객체를 포함하여 보다 작은 값의 객체 리턴 : ");
		SortedSet<String> set2_6 = treeSet2.headSet("bz", true); 
		System.out.println(set2_6); // [apple, banana, black]

		
		System.out.println();
		System.out.println("----------------------------------------------------------");
		
		
		System.out.println("[banana]");
		
		//tailSet 기본값 : true
		System.out.print("지정된 객체를 포함하여 큰 값의 객체 리턴 [방법 1] : ");
		SortedSet<String> set3 = treeSet2.tailSet("banana"); 
		System.out.println(set3); // [banana, black, cherry, door, element, school]

		System.out.print("지정된 객체를 포함하여 큰 값의 객체 리턴 [방법 2] : ");
		SortedSet<String> set3_2 = treeSet2.tailSet("banana", true); 
		System.out.println(set3_2); // [banana, black, cherry, door, element, school]

		System.out.print("지정된 객체보다 큰 값의 객체 리턴 : ");
		SortedSet<String> set3_3 = treeSet2.tailSet("banana", false); 
		System.out.println(set3_3); // [black, cherry, door, element, school]
		
		
		System.out.println();
	
	
		System.out.println("[bz]");
		
		System.out.print("지정된 객체를 포함하여 큰 값의 객체 리턴 [방법 1] : ");
		SortedSet<String> set3_4 = treeSet2.tailSet("bz"); 
		System.out.println(set3_4); // [cherry, door, element, school]

		System.out.print("지정된 객체를 포함하여 큰 값의 객체 리턴 [방법 2] : ");
		SortedSet<String> set3_5 = treeSet2.tailSet("bz", true); 
		System.out.println(set3_5); // [cherry, door, element, school]

		System.out.print("지정된 객체보다 큰 값의 객체 리턴 : ");
		SortedSet<String> set3_6 = treeSet2.tailSet("bz", false); 
		System.out.println(set3_6); // [cherry, door, element, school]
	
	
		System.out.println();
		
		treeSet2.removeAll(treeSet2);
		System.out.println("총 객체 수 : " + treeSet2.size());
	
	
	
	
	
	
	
	
	
	
	
	}

}


