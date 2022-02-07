package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class IOExceptionClass {

	public static void main(String[] args) { //throws FileNotFoundException { => JVM이 처리하는 방법(프로그램 종료됨)
		
		/*
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("a.txt");
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} finally { //finally 사용하는 이유 : 자동으로 resources를(FileInputStream 이런것들) 종료하기 위해
			//try{}에서 선언한 지역변수는 finally에서 인식 안 됨
			if(fis != null) {
		
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				} 
		}
			
			System.out.println("항상 실행됩니다.");
		}
		
		System.out.println("여기도 항상 실행됩니다.");
		*/
		
		//---------------------------------------------------------------------------------
		
		
		//java7부터~ (우린 8)
		//finally를 없애 자동으로 닫기
		
		/*
		 * 해당 리소스(=FileInputStream)가 AutoCloseable 인터페이스를 구현해야 아래 문법 사용 가능
		 */
		try(FileInputStream fis = new FileInputStream("a.txt")) {
			
		} catch(IOException e) { //주의 : IOException으로 받아야 함
			System.out.println(e);
		} finally { //close를 위한 finally가 아니라 반드시 실행하는 것을 위한 것
			System.out.println("항상 실행됩니다.");
		}
		
		System.out.println("여기도 항상 실행됩니다.");
		
	}

}