/*
 * Map 인터페이스
 * 1. 키와 값으로 구성된 Map.Entry 객체를 저장
 * 2. 키와 값은 모두 객체
 * 3. 키 : 중복 x, 값 : 중복 o
 * 4. 기존에 저장된 key와 동일한 값으로 저장하면 기존의 값은 없어지고 새로운 값으로 대체됨
 */


package map;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapExample {

	public static void main(String[] args) {
		//<키,값>Map 컬렉션 생성
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		
		//객체 추가
		map.put(new Integer(6), "홍길동");
		map.put(3, "이순신"); // int -> 자동 Boxing되어 'Integer객체'
		map.put(7, "김구");
		
		System.out.println("저장된 총 객체수 : " + map.size()); //3
		
		
		//기존에 저장된 key와 동일한 값으로 저장하면 기존의 값은 없어지고 새로운 값으로 대체됨
		map.put(6, "유관순");
		System.out.println("저장된 총 객체수 : " + map.size()); //3
		System.out.println("6의 이름 : " + map.get(6)); //int -> 자동 Boxing되어 'Integer객체' -> Object객체 
		System.out.println();
		
		System.out.println("** map 주소만 **");
		System.out.println(map); //{3=이순신, 6=유관순, 7=김구}
		
		System.out.println("** 저장된 전체 객체를 대상으로 키와 값을 얻고 싶을 때 (4가지 방법) **");
		
		
		
		
		/*----------------keySet() : 향상된 for문, 반복자----------------------------------------------------*/
		
		
		//keySet()메서드로 모든 키 얻어 Set 객체로 담기
		Set<Integer> kset = map.keySet(); // 6,3,7
		
		System.out.println("방법 1 : keySet() -> 향상된 for문");
		for(Integer key : kset) { // 6 3 7
			System.out.println(key + "번의 이름은 " + map.get(key)); // 3,6,7 
		}
		System.out.println();
		
		
		System.out.println("방법 2 : keySet() -> 반복자 Iterator 이용");
		Iterator<Integer> itr1 = kset.iterator();
		while(itr1.hasNext()) {
			Integer key = itr1.next();
			System.out.println(key + "번의 이름은 " + map.get(key));
		}
		
		
		/*----------------entrySet() : 향상된 for문, 반복자----------------------------------------------------*/
		
		
		//entrySet()메서드로 모든 키와 값인 Map.Entry를 얻어 Set 객체로 담기
		Set<Entry<Integer, String>> eSet = map.entrySet();
		
		System.out.println("방법 3 : entrySet() -> 향상된 for문");
		for(Entry<Integer, String> entry : eSet) { // [3, 이순신] -> [6, 유관순] -> [7, 김구]
			System.out.println(entry.getKey() + "번의 이름은 " + entry.getValue());
		}
		System.out.println();
		
		
		
		System.out.println("방법 4 : entrySet() -> 반복자 Iterator 이용");
		Iterator<Entry<Integer, String>> eitr = eSet.iterator(); //<키, 값>의 반복자를 통해
		
		while(eitr.hasNext()) {
			Entry<Integer, String> entry = eitr.next(); //Map.Entry 하나씩 열어 : [3, 이순신] [6, 유관순]
			System.out.println(entry.getKey() + "번의 이름은 " + entry.getValue());
		}
		System.out.println();
		
		System.out.println("*******************************************************");
		System.out.println("**** 저장된 전체 객체를 대상으로 삭제하는 방법 ****");
		System.out.println();
		
		System.out.println("3번 객체 삭제 후 값을 리턴 : " + map.remove(3));
		
		map.clear(); //객체 전체 삭제
		System.out.println("총 Entry 객체 수 : " + map.size()); //삭제 확인 방법 1
		
		if(map.isEmpty()) System.out.println("모두 삭제되어 비었음"); //삭제 확인 방법 2
		else System.out.println("비어있지 않음");

		//keySet()메서드로 모든 키 얻어 Set 객체로 담아
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}