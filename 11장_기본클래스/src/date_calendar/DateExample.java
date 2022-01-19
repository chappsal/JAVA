/*
 * Date() 생성자는 여러 개의 생성자가 선언되어 있지만 대부분 Deprecated(비권장)되어
 * 현재는 Date() 생성자만 주로 사용
 * 
 */


package date_calendar;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateExample {

	public static void main(String[] args) {
		Date now = new Date(); 				//컴퓨터의 현재 날짜를 읽어 Date 객체를 생성
		String strNow1 = now.toString(); 	//현재 날짜를 문자열로 얻고 싶다면 toString() 사용
		System.out.println(strNow1); 		//Wed Jan 19 12:06:03 KST 2022
		//System.out.println(now.toString()); // 윗줄과 같음
		
		
		/*
		 * toString() 은 영문으로 된 날짜를 리턴하는데
		 * 만약 특정 문자열 포맷으로 얻고 싶다면
		 * java.text.SimpleDateFormat 클래스를 이용하면 된다.
		 */
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초"); //월, 분 대소문자 구분
		String now2 = sdf.format(now);
		System.out.println(now2);
	}

}