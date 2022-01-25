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
		 * 						시작~끝 이전까지의 부분 집합 반환
		 * 
		 * NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive)
		 * 							     시작			        시작 포함 여부			 끝		  		끝 포함 여부
		 * 							시작(포함 여부 선택) ~ 끝(포함 여부 선택) 까지의 부분 집합 반환
		 * 							포함 o: true / 포함 x: false
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
		
		
		
		
		
		
		
		
		
		
		
	}

}

