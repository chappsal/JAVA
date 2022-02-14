package first;

public class Hellojava {

	public static void main(String[] args) {
		
		System.out.println("Hello world");  // 문자열, String
		System.out.println("H");  // 문자, Character
		
		System.out.println("Hello \n world"); // \n 줄바꿈
		
		System.out.println("Hello \"world\""); // 따옴표 출력 시 \로 감싸기 (=escape)
		
		System.out.print(1);   // ln 삭제 시 다음줄과 붙어서 계산 됨
		System.out.println(1+2); 

		System.out.print(1+"\n");  // \n = ln
		System.out.println(1+2);
	}

}
