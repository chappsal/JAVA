/*
   [Set 인터페이스] index 사용 안 함, 순서 x, 중복 x
   
   1. HashSet 클래스 : 저장 순서에 상관 없는 출력 결과
   					Set은 index를 사용 안 하므로 저장 순서가 중요하지 않음
   
      그러나
   2. LinkedHashSet 클래스 : 저장 순서 유지하는 예외적인 Set 클래스
   3. TreeSet : 이진트리를 기반으로 검색 기능을 강화
   
   [★★  Hash~시작하는 클래스(중복을 허용하지 않을 때)에서 객체를 추가할 때 '같은 객체 판단하는 방법']
   ex) HashSet, HashMap (키 값: 중복 허용하지 않음)
   
       객체를 add(),put()(저장=추가)하기 전에
   1. 반드시 hashCode()메서드 호출
   	  => 리턴된 해쉬코드(정수)값 비교 : 같으면  -> 2. 같은지 한번 더 확인하기 위해 equals()메서드 호출
   										-> true이면 같은 객체로 인식하여 추가 x
   										   false이면 다른 객체로 인식하여 추가 o
   
   	  => 리턴된 해쉬코드(정수)값 비교 : 다르면  -> 2. 서로 다른 객체로 인식하여 추가함
   
   
         ※ 해쉬코드(정수) : 객체의 주소로 만듦
   
   [Object]
   - Object의 hashCode() : 객체의 '주소 값'으로 해쉬코드 만듦
   - 제공받은 Object의 자식 클래스들(ex.String)의 hashCode() : 객체의 '실제 값'으로 해쉬코드 만듦  // int 리턴
  
   - Object의 equals() : 객체의 '주소 값' 비교
   - 제공받은 Object의 자식 클래스들(ex.String)의 equals() : 객체의 '실제 값'으로 해쉬코드 만듦 // true ,false 리턴
   
       그러나, 우리가 만든 '사용자 정의 클래스'는 Object의 hashCode()와 equals()를 재 정의하여 사용해야 함
   (단, Set인터페이스를 구현한 클래스(ex.HashSet)를 사용하려면 반드시 재 정의) 
   
  
   
 */


package set;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetExample {

	public static void main(String[] args) {
		
		HashSet<String> set = new HashSet<String>();
	
		set.add("여러분");
		set.add("모두");
		// set은 중복 허용하지 않음 : add()하기 전, 중복 여부를 판단하는 String 클래스 메서드 2개 호출 (HashCode, equals) -> 추가 x
		set.add("모두"); 
		set.add("마지막까지"); 
		set.add("화이팅~"); 
		
		System.out.println("총 객체 수 : " + set.size());
		System.out.println();
		
		if(set.contains("모두")) {//주어진 객체가 포함되어 있으면 true, 없으면 false
			System.out.println("\"모두\"가 존재한다.");
		} else System.out.println("\"모두\"가 존재하지 않는다.");
		System.out.println();
	
	
		/******* Set에 저장된 객체 얻는 방법-1 : 향상된 for문 이용 - index를 사용하지 않기 때문에 *******/
	
		for(String str : set) {
			System.out.print(str + " ");
		}
		System.out.println();
		

		/******* ★★ Set에 저장된 객체 얻는 방법-2 : 반복자(=지팡이 역할) 이용 - index를 사용하지 않기 때문에 *******/
		
		Iterator<String> itr = set.iterator(); // 반복자를 생성하는 메서드-Set에서 많이 사용
		
		while(itr.hasNext()) {
			System.out.print(itr.next() + " ");
		}
		System.out.println();

		System.out.println("-- 삭제 (Object 이용 : 객체)--");	// index를 사용하지 않으므로 Set계통에서 사용
		if(set.remove("모두")) System.out.println("찾아서 있으면 삭제 후 true -> 삭제됨");
		else System.out.println("찾아서 없으면 false -> 삭제 안 됨");
		
		
		//remove(Object) : Object 타입이므로 모든객체 다 수용. but, String 이외 객체는 노란줄로 경고 띄움
		if(set.remove(new Integer(13))) System.out.println("찾아서 있으면 삭제 후 true -> 삭제됨");
		else System.out.println("찾아서 없으면 false -> 삭제 안 됨");
		System.out.println();
		
		
		System.out.println("-- 모두 삭제 --");
		if(set.removeAll(set)) System.out.println("모두 삭제");
		else System.out.println("모두 삭제 안 됨");
		
		set.clear(); //Clear()로 모두 삭제하면 void이므로 삭제되었는지 확인하려면
		
		//방법 1
		System.out.println("저장된 총 객체 수 : " + set.size());
		
		//방법 2
		if(set.isEmpty()) System.out.println("저장된 객체가 없음"); //저장된=관리하는=참조하는
		else System.out.println("저장된 객체가 있음");
		
		
		
		
		
		
		
		
		
		
		
		
	}

}


