package map.treemapmember;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapMember {
	//1. 멤버변수 : Entry<Integer, Member>를 관리하는 TreeMap타입을 포함관계
	private TreeMap<Integer, Member> treeMap;
	
	//2. 매개변수가 없는 생성자
	public TreeMapMember() { //key기준으로 오름차순 정렬된 TreeMap
		//Integer는  Comparable인터페이스를 이미 구현하여 재정의된 compareTo()메서드로 오름차순 정렬되어 있음
		treeMap = new TreeMap<Integer, Member>();
	}
	
	//3. 메서드 : 외부에 노출된 버튼
	public void addMember(Member m) { //회원 추가
		treeMap.put(m.getMemberId(), m);
	}
	
	//회원 아이디로 삭제
	public boolean removeMember(int memberId) { //memberId(회원아이디=키)로 삭제
		if(treeMap.containsKey(memberId)) {
			//★ 순서 주의 : 출력 후 삭제 (삭제 후 출력시 null 출력)
			System.out.println(treeMap.get(memberId) + "가 삭제되었습니다.");			
			treeMap.remove(memberId);
			return true;
		}
		
		System.out.println(memberId + "가 존재하지 않습니다.");
		return false;
	}
	
	//회원으로 삭제
	public boolean removeMember(Member member) {
		//방법 1
		/*
		if(treeMap.containsValue(member)) {
			treeMap.remove(member.getMemberId());
			return true;
		}
		*/
		
		//방법 2
		if(treeMap.remove(member.getMemberId(), member)) {
			System.out.println(member + "가 삭제되었습니다.");
			return true;
		}
		//remove(V value) 값으로 삭제하는 메서드가 없는 이유 : 값은 중복 가능하므로 여러 키가 삭제될 수 있음
		
		else {
			System.out.println(member + "가 존재하지 않습니다.");
			return false;
		}
	}
	
	//TreeMap<Integer, Member>() 생성자로 객체 생성 : key를 기준으로 오름차순 정렬
	public void showAllMember() {//오름차순으로 정렬
		System.out.println("----오름차순 정렬----");
		//반복자
		Iterator<Integer> keyItr = treeMap.descendingKeySet().iterator();
		
		while(keyItr.hasNext()) {
			Integer key = keyItr.next();
			System.out.println(key + "," + treeMap.get(key));
		}
	}
	
	
	public void showAllDesendingMember() { //내림차순 정렬
		System.out.println("---- 내림차순 정렬 ----");
		//향상된 for문 [방법 1]
		NavigableSet<Integer> dMemberMap = treeMap.descendingKeySet();
		for(Integer key : dMemberMap) {
			System.out.println(key + ", " + treeMap.get(key));
		}
		
		//향상된 for문 [방법 2]
		/*
		NavigableMap<Integer, Member> dMemberMap = treeMap.descendingMap();
		Set<Entry<Integer, Member>> eSet = dMemberMap.entrySet();
		
		for(Entry<Integer, Member> entry : eSet) {
			System.out.println(entry.getKey() + ", " + entry.getValue());
		}
		*/
		System.out.println();
		
	}
	
	
}