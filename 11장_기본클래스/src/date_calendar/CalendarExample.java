package date_calendar;

import java.util.Calendar;

public class CalendarExample {

	public static void main(String[] args) {
		/*
		 * Calendar는 추상클래스이기 때문에 new하여 객체 생성이 불가하고
		 * Calendar.getInstance()를 이용하거나
		 * Calendar 클래스를 상속받는 GregorianCalendar 클래스를 이용하여 객체를 생성할 수 있다
		 */
		
		Calendar now = Calendar.getInstance();

		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH)+1; //★주의(1월:0 ~ 12월:11)
		int day = now.get(Calendar.DAY_OF_MONTH);   //현재 월의 날짜 1
		int date = now.get(Calendar.DATE); 			//현재 월의 날짜 2
		//System.out.println(day);
		//System.out.println(date);
		
		
		int week = now.get(Calendar.DAY_OF_WEEK); //현재 요일(일요일:1, 토요일:7)
		//System.out.println(week);
				
		int dayYear = now.get(Calendar.DAY_OF_YEAR); //현재 년도의 날짜 (365일 기준)
		//System.out.println(dayYear);
		
		int weekYear = now.get(Calendar.WEEK_OF_YEAR); //현재 년도의 몇째 주
		//System.out.println(weekYear);
		
		int weekMonth = now.get(Calendar.WEEK_OF_MONTH); //현재 월의 몇째 주
		//System.out.println(weekMonth);
		
		
		String strWeek = null;
		switch(week) {
			case Calendar.MONDAY    : strWeek = "월"; break; 
			case Calendar.TUESDAY   : strWeek = "화"; break; 
			case Calendar.WEDNESDAY : strWeek = "수"; break; 
			case Calendar.THURSDAY  : strWeek = "목"; break; 
			case Calendar.FRIDAY    : strWeek = "금"; break; 
			case Calendar.SATURDAY  : strWeek = "토"; break; 		
			default    				: strWeek = "일"; 
			
		}
		
		int amPm = now.get(Calendar.AM_PM);
		String strAmPm = null;
		if(amPm == Calendar.AM) {
			strAmPm = "오전";
		} else {
			strAmPm = "오후";
		}
		
		int hour12 = now.get(Calendar.HOUR); //현재 시간(12시간)
		int hour24 = now.get(Calendar.HOUR_OF_DAY); //현재시간 (24시간)
		
		int minute = now.get(Calendar.MINUTE); //현재 분
		int second = now.get(Calendar.SECOND); //현재 초
		
		int milliSecond = now.get(Calendar.MILLISECOND); //1000분의 1초 (0~999)
		
		/*
		 * Calendar.ZONE_OFFSET : get 및 set를 위한 필드값로 GMT 로부터 직접 계산한 오프셋(offset)를 밀리 세컨드 단위로 가리킵니다.
		 * GMT(그리니치 표준 시) : 런던 기점 -12~+12 (대한민국 GMT+9)
		 */
		
		int timeZone = now.get(Calendar.ZONE_OFFSET);
		int lastDate = now.getActualMaximum(Calendar.DATE); //현재 달의 마지막 날
		
		System.out.println("오늘은 " + year + "년 " + month + "월 " + day + "일 ");
		System.out.println("오늘은 올해의 " + weekYear + "째 주, 이번 달의 " + weekMonth + "째 주 " + date + "일");
		System.out.println("오늘은 이번 해의 " + dayYear + "일이자, 이번 달의 " + day + "일이고 " + strWeek + "요일");
		
		System.out.println("현재 시각은 " + strAmPm + hour12 + "시 " + minute + "분 " + second + "초");		
		System.out.println("현재 시각은 " + hour24 + "시 " + minute + "분 " + second + "초");
		
		System.out.println("1000분의 1초 (0~999): " + milliSecond);
		
		//1000분의 1초를 시간으로 표시
		System.out.println("timeZone(-12~+12): " + timeZone + "초, " + timeZone/(60*60*1000));
		System.out.println(month + "월의 마지막 날: " + lastDate);
		
	}

}
