package set.hashsetmember;

import java.util.HashSet;

public class HashSetMember {

	public static void main(String[] args) {
		System.out.println("----------------- HashSet<String> -----------------");
		HashSet<String> setStr = new HashSet<String>();
		setStr.add("같은 문자열");		
		setStr.add("같은 문자열"); // 중복 -> 추가 x
		
		System.out.println("총 객체 수 : " + setStr.size());
	
		
		
		System.out.println("----------------- HashSet<Member> -----------------");
		HashSet<Member> setMember = new HashSet<Member>();
		setMember.add(new Member("홍길동", 24));
		setMember.add(new Member("홍길동", 24));
		
		System.out.println("총 객체 수 : " + setMember.size());
			
	}
	

}
