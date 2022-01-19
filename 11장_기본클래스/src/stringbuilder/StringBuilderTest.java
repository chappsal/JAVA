/*
 * [StringBuilder와 StringBuffer 클래스]
 * - String 클래스는 생성되면 내부의 문자열 값 변경되지 않기 때문에
 *   문자열을 concat() 또는 + 로 연결하거나 subString()등의 메서드로 변경하면
 *   항상 새로운 문자열 객체가 생성되어 메모리 낭비가 심하다 
 * 
 * ※ 위 문제를 해결하기 위해  StringBuilder와  StringBuffer 클래스가 등장
 * 
 * - 두 클래스의 유일한 차이점
 *   -Stringbuilder : 싱글 스레드에서 사용 => 속도 향상
 *   -StringBuffer  : 멀티 스레드에서 사용 => 동기화 보장 (앞에 synchronized가 붙어있는걸 제외하면 StringBuilder와 같음 A와 B가 동시에 add()를 사용할때 
 *   											A가 사용하다 시간이 끝나 B의 차례가 되면 그대로 lock해서 B가 사용 못 함
 *   											시간이 지나 다시 A차례가 오고 사용이 끝나면 unlock되어서 B가 사용할 수 있음. 효율은 떨어지지만 동기화 보장)
 */

package stringbuilder;

public class StringBuilderTest {

	public static void main(String[] args) {
		String javaStr = new String("Java");
		//처음 생성된 메모리 실제 주소
		System.out.println("추가 전 JavaStr 문자열 실제 주소 : " + System.identityHashCode(javaStr));
		
		javaStr = javaStr.concat(" and JSP"); //String타입으로 돌려준다는 것은 새로운 객체를 만든다는 것
		System.out.println("추가 후 JavaStr 문자열 실제 주소 : " + System.identityHashCode(javaStr));
		
		System.out.println();
		
		//"Java and JSP" String으로부터 StringBuilder 생성
		StringBuilder stringBuilder = new StringBuilder(javaStr); //빈괄호로 만들면 기본값으로 만들어지고 괄호안에 뭘 넣으면 그 문자값으로 만들어짐
		System.out.println("추가 전 StringBuilder 실제 주소 : " + System.identityHashCode(stringBuilder));
		
		//String에 concat() 하고 싶은 것을 StringBuilder에 append()로 문자열 연결
		stringBuilder.append(" and");     //문자열 추가		
		stringBuilder.append(" android"); //문자열 추가
		
		System.out.println("추가 후 StringBuilder 실제 주소 : " + System.identityHashCode(stringBuilder));
		
		System.out.println();
		
		javaStr = stringBuilder.toString();
		System.out.println(javaStr);
		
		System.out.println("새로 생성된 JavaStr 문자열 실제 주소 : " + System.identityHashCode(javaStr));
		
	}

}


