package map;


import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class TreeMapExample {
	

	public static void main(String[] args) {
		
		TreeMap<Integer, String> treeMap= new TreeMap<Integer, String>();
		
		//Tree(검색, 정렬) + Map(키,값) Entry / 두 기능을 합친 Entry
		treeMap.put(new Integer(89), "이순신");
		treeMap.put(95, "홍길동");
		treeMap.put(78, "김유신");
		treeMap.put(98, "유관순");
		treeMap.put(80, "김구");
		treeMap.put(83, "강감찬");
		
		treeMap.put(78, "유재석");
		
		System.out.println("저장된 총 Entry 객체 수 : " + treeMap.size());
		
		System.out.println("** map 주소만 **");
		System.out.println(treeMap); //{78=유재석, 80=김구, 83=강감찬, 89=이순신, 95=홍길동, 98=유관순}

		
		System.out.println();
		
		
		/************************************************************************************/
		
		System.out.println("------------ 검색과 관련된 메서드들 --------------");
		System.out.println();
		
		System.out.println("가장 낮은 객체 리턴 [방법 1] : " + treeMap.firstKey() + ", " + treeMap.get(treeMap.firstKey())); //정렬되어 있기 때문에 firstKey 사용 가능 // 키 값 + value 
																								// value
		System.out.println("가장 낮은 객체 리턴 [방법 2] : " + treeMap.firstEntry().getKey() + ", " + treeMap.firstEntry().getValue());
		//Entry 속에는 getKey(), getValue()가 있음
		
		Integer key = treeMap.lastKey();
		System.out.println("가장 높은 객체 리턴 [방법 1] : " + key + ", " + treeMap.get(key));
		
		Entry<Integer, String> entry = treeMap.lastEntry();
		System.out.println("가장 높은 객체 리턴 [방법 2] : " + entry.getKey() + ", " + entry.getValue());
		
		
		System.out.println();
		
		
		entry = treeMap.lowerEntry(95);
		System.out.println("주어진 key 객체인 95보다 바로 아래 Entry 객체 리턴 : " + entry.getKey() + ", " + entry.getValue());
		
		entry = treeMap.higherEntry(95);
		System.out.println("주어진 key 객체인 95보다 바로 위 Entry 객체 리턴 : " + entry.getKey() + ", " + entry.getValue());
		System.out.println();
		
		entry = treeMap.floorEntry(96);
		System.out.println("주어진 key 객체인 96과 같은 key 객체가 있으면 그 Entry 객체 리턴, 없으면 주어진 key 객체 바로 아래 Entry 객체 리턴 : " + entry.getKey() + ", " + entry.getValue());
		
		entry = treeMap.ceilingEntry(94);
		System.out.println("주어진 key 객체인 94와 같은 key 객체가 있으면 그 Entry 객체 리턴, 없으면 주어진 key 객체 바로 위 Entry 객체 리턴 : " + entry.getKey() + ", " + entry.getValue());
	
		
		//---------------------------------------------------------------------------------
		
		System.out.println();
		System.out.println("------------ 범위 검색과 관련된 메서드들 --------------");
		System.out.println();
		
		/*
		 * SortedMap<K,V> subMap(K fromKey, K toKey)
		 * 						시작(포함)~끝 이전까지의 부분 집합 반환
		 * 
		 * NavigableMap<K,V> subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive)
		 * 							     시작			        시작 포함 여부		끝		  	끝 포함 여부
		 * 							시작(포함 여부 선택) ~ 끝(포함 여부 선택) 까지의 부분 집합 반환
		 * 							포함 o: true / 포함 x: false
		 */
		
		SortedMap<Integer, String> treeMapSub1 = treeMap.subMap(78, 95); //SortedMap : 정렬된 맵
		System.out.println("-- 78 <= 찾는 점수 < 95 --");
		
		Set<Entry<Integer, String>> set1 = treeMapSub1.entrySet();
		System.out.println("방법 1 : " + set1); //정렬된 상태(treeMap에서 가져왔기 때문에) [78=유재석, 80=김구, 83=강감찬, 89=이순신]
		
		
		System.out.print("방법 2 : [");
		Iterator<Entry<Integer,String>> set1Itr = set1.iterator();
		
		while(set1Itr.hasNext()) {
			entry = set1Itr.next();
			System.out.print(entry.getKey() + "=" + entry.getValue() + " ");
		}
		System.out.println("]");
		System.out.println();
		
		//---------------------------------------------------------------------------------
		
		
		SortedMap<Integer, String> treeMapSub2 = treeMap.subMap(78, true, 95, true); //SortedMap : 정렬된 맵
		System.out.println("-- 78 <= 찾는 점수 <= 95 --");
		
		Set<Entry<Integer, String>> set2 = treeMapSub2.entrySet();
		System.out.println("방법 1 : " + set2); //정렬된 상태(treeMap에서 가져왔기 때문에) [78=유재석, 80=김구, 83=강감찬, 89=이순신]
		
		
		System.out.print("방법 2 : [");
		Iterator<Entry<Integer,String>> set2Itr = set2.iterator();
		
		while(set2Itr.hasNext()) {
			entry = set2Itr.next();
			System.out.print(entry.getKey() + "=" + entry.getValue() + " ");
		}
		System.out.println("]");
		
		
		
		
		
	}

}