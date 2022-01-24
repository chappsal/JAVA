/*
   [HashSet과 TreeSet]
   
         ※ 공통점 : Set 계통이므로 모두 중복을 허용하지 않고 순서가 없는 컬렉션이다
   
   (1) 구현 방식 - HashSet : 해싱을 이용하여 구현 (해싱: 분류하여 검색하는 것)
   			 - TreeSet : 이진 탐색 트리를 이용하여 구현
   
   ------------------------------------------------------------------
       이지스 교재 428p~
   
   3. TreeSet : 이진 트리를 기반으로 검색 기능을 강화 	(ex) 검색과 관련된 메서드들 : first()...
   				저장과 동시에 '오름차순'으로 자동 정렬 	(ex) 숫자(Integer, Double..등) 타입일 경우 : 값으로 정렬
   				 								  문자열(String) 타입일 경우 : 유니코드 값으로 정렬
   
   
   
   
   
   
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
