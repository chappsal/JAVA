/*
 *  String이나 Integer등 제공받은 클래스는 Comparable 인터페이스를 이미 구현하여
 *  재정의된 CompareTo()로 오름차순 정렬되어 추가됨
 * 
 *  그런데 내림차순으로 바꾸고 싶은 경우에는 어떻게 해야 하는지?
 *  String이나 Integer 클래스의 경우 final로 선언되어 있어 
 *  compareTo()를 상속받아 내림차순 정렬로 재정의 불가
 *  이러한 경우 Comparator 인터페이스를 구현하여 compare()를 내림차순 정렬로 재정의 후 사용하면 해결
 *  
 *  ※ Comparator 사용 시 유의점 : TreeSet 생성자에 Comparator를 구현한 객체를 매개변수로 전달해야 함
 *  
 */

package set.treesetstring;

import java.util.Comparator;
import java.util.TreeSet;



//사용자 정의 클래서 :String을 내림차순 정렬
class ComparatorString implements Comparator<String>{

	//String 클래스에는 유니코드로  비교하여 오름차순 정렬시키는 compareTo()가 이미 재정의되어 있음
	
	
	//그래서 compare()에서는 String을 내림차순 정렬시키도록 재정의 
	@Override
	public int compare(String o1, String o2) {
	 	return o1.compareTo(o2) * (-1); //반환값 음수 : 내림차순  => -1을 곱하면 반대로 
	}
	
	
}






public class ComparatorStringTest {

	public static void main(String[] args) {
		TreeSet<String> set = new TreeSet<String>();
		set.add("bbb"); //compareTo()호출 -> 오름차순 정렬
		set.add("ccc");
		set.add("aaa");
		
		//set.toString()호출 -> 저장된 각 객체의 toString()호출
		System.out.println(set); // [aaa, bbb, ccc]

		//★주의 : TreeSet생성자에 Comparator를 구현한 객체를 매개변수로 전달하면
		set = new TreeSet<String>(new ComparatorString());
		set.add("bbb"); 
		set.add("ccc");
		set.add("aaa");
		
		//set.toString()호출 -> 저장된 각 객체의 toString()호출
		System.out.println(set);
		
		
	}

}
