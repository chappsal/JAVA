package stringbuilder;

public class StringBuilderExample {

	public static void main(String[] args) {
		
		StringBuilder sb = new StringBuilder(); //16개의 초기 버퍼 (=16칸) ,객체이기 때문에+빈괄호이기 때문에 기본 값 (null문자)로 채워져있음
		//StringBuffer sb = new StringBuffer(); // 멀티 스레드에서 사용
		
		
		System.out.println("추가 전 StringBuilder 실제 주소-1: " + System.identityHashCode(sb));
		
		sb.append("Java "); //버퍼에 추가
		System.out.println("추가 후 StringBuilder 실제 주소-1: " + System.identityHashCode(sb));
		
		sb.append("and JSP"); //버퍼에 추가
		System.out.println("추가 후 StringBuilder 실제 주소-2: " + System.identityHashCode(sb));
				
		System.out.println(sb);
		System.out.println(sb.toString());
	
		sb.insert(4, "2"); //Java and JSP => Java2 and JSP ("2" 대신 2 , '2'로 넣어도 결과는 같음, 문자로 들어감)
		System.out.println(sb);
		
		sb.setCharAt(4, '7');
		System.out.println(sb);
		
		sb.replace(6, 12+1, "book");//6~12까지 해당 내용을 book으로 변경  //java에서는 끝 index는 항상 +1 해줌 
		System.out.println(sb); 	// Java7 book
		
		sb.delete(4, 5);			// 7삭제
		System.out.println(sb); 
		
		sb.insert(4, true); 		//'t' 'r' 'u' 'e' 하나하나가 문자로 바뀌어 들어감
		System.out.println(sb);		//Javatrue book
		
		System.out.println("총 문자수: " + sb.length());
		
		System.out.println();
		
		System.out.println("String 생성 전 StringBuilder 실제 주소: " + System.identityHashCode(sb));
		String result = sb.toString(); // toString()을 사용해 String으로 바꿈
		System.out.println(result);
		
		System.out.println();
		
		System.out.println("String 생성 후 String 실제 주소: " + System.identityHashCode(result));
		System.out.println(result);
	}

}
