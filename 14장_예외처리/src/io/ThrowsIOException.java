/*
 * 오류?
 * 1. 컴파일 오류 : 문법적인 오류
 * 2. 실행 오류 
 * 		(1) 시스템 오류 (Error 클래스) : JVM에서 발생 (ex)메모리에 문제 -> 프로그램에서 제어 불가
 * 		(2) Exception 클래스 (예외) : 프로그램에서 제어 가능
 * 		
 * 		※ 교재 488p 아래 그림 참조 
 *  	- Exception 클래스의 자식 클래스들은 예외 처리해야 함
 *  	- 그러나 , RunTimeException(실행 오류 예외)는 프로그래머의 실수로 발생하는 예외이므로
 *  	  try~catch()로 처리하는 것보다 실수를 수정하는 방법으로 해결하는 것이 더 좋다
 *  
 *  	- IOException(입출력 예외 처리)의 자식 예외들은 반드시 예외 처리해줘야 함
 *  		(메서드에 마우스 올렸을때 throws~ 어쩌고 뜨는 것)
 *  
 *  				Throwable
 *  					|
 *  	-----------------------------------
 *      |								  |
 *    Error							  Exception
 *  									  |
 *  							---------------------
 *  							|					|					
 *  					   IOException		 RunTimeException
 *  
 *  
 *  
 * ★ 예외 처리 방법 1
 * 	try {
 *    예외 발생 가능성 
 * 	} catch(Exception e) { //모든 예외의 부모
 *    예외 처리
 *  } finally {
 *    무조건 실행 (예외 발생 유무에 관계 x)
 *  }
 *  
 * ★ 예외 처리 방법 2 : 호출한 쪽에서 처리하도록 던져서 처리
 * throws 예외 클래스명
 * 
 * 
 *  
 */

package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ThrowsIOException {
	//기본생성자
	
	//
	public Class loadClass(String fileName, String className) throws FileNotFoundException, ClassNotFoundException{
		//1.첫번째 매개값
		FileInputStream fis = new FileInputStream(fileName);
		//2.두번째 매개값
		Class c = Class.forName(className); //IO와 관련된 것, 메서드 이름에 마우스 올렸을때 throws~ 어쩌고 뜨는 것들은 무조건 처리해줘야함
		
		return c;
	}
	
	
	
	public static void main(String[] args) {
		ThrowsIOException test = new ThrowsIOException();

		try {
			test.loadClass("a.txt", "java.lang.string");
		} /*catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} */ catch(FileNotFoundException | ClassNotFoundException e) {
			System.out.println(e);
		}
		
		System.out.println("** 끝 **");
		
		
	}

}