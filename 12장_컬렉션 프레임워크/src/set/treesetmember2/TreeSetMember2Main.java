package set.treesetmember2;

import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSetMember2Main {

	public static void main(String[] args) {
		System.out.println("------- [아이디로 오름차순 정렬] -------");
		TreeSet<Member2> tsm2 = new TreeSet<Member2>();
		
		tsm2.add(new Member2(21, "배수철"));
		tsm2.add(new Member2(23, "고승범"));
		tsm2.add(new Member2(20, "김동준"));
		
		for(Member2 m2 : tsm2) {
			System.out.println(m2);
		}
		
		System.out.println();
		
		System.out.println("** treeSet 객체의 주소만  **");
		System.out.println(tsm2); //tsm2.toString() 호출 -> 저장된 각 개체의 toString() 호출
		System.out.println();
		
		/*
		 * ※ Comparator 사용 시 유의점 : TreeSet 생성자에 Comparator를 구현한 객체를 매개변수로 전달해야 함
		 * 오름차순 정렬 뿐만 아니라
		 * 추가로 내림차순 정렬까지 되도록 하기 위해서
		 * TreeSet 생성자에 Comparator를 구현한 객체를 매개변수로 전달하면 됨
		 * 
		 * 
		 */
		
		
		
		System.out.println("------- [아이디로 내림차순 정렬] -------");
		tsm2 = new TreeSet<Member2>(new DescendingMember2());
		
		//compare() 호출하여 내림차순 정렬시켜 추가
		tsm2.add(new Member2(21, "배수철"));
		tsm2.add(new Member2(23, "고승범"));
		tsm2.add(new Member2(20, "김동준"));
		
		for(Member2 m2 : tsm2) {
			System.out.println(m2);
		}
		
		
		
	}

}