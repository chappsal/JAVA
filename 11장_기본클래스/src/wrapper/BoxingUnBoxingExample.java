package wrapper;

public class BoxingUnBoxingExample {

	public static void main(String[] args) {
		//자동 Boxing
		Integer obj = 100;
		System.out.println("값: " + obj.intValue());
		
		// 자동 UnBoxing기본 타입 = 포장 객체		
		int value = obj;
		System.out.println("값: " + value);
		
		//연산시 자동 UnBoxing
		int result = obj + 10; //100+10
		System.out.println("값: " + result);
		
		/********************************************/
		//Boxing
		//Boxing
		Integer obj1 = new Integer(100); //생성자 이용
		Integer obj2 = new Integer("200");
		Integer obj3 = new Integer(300);
		Integer obj4 = new Integer("400");
		
		//UnBoxing
		int value1 = obj1.intValue();
		int value2 = obj2.intValue();
		int value3 = obj3;
		int value4 = obj4;
		
		System.out.println(value1);
		System.out.println(value2);
		System.out.println(value3);
		System.out.println(value4);
		
		
		/******************* 문자열 -> 기본타입으로, 기본타입 -> 문자열로 ************************/
		
		//문자열 -> 기본타입
		int v1 = Integer.parseInt("10");
		double d = Double.parseDouble("3.14");
		boolean b = Boolean.parseBoolean("true");
		
		//기본타입 -> 문자열
		String s1 = String.valueOf(10);
		String s2 = String.valueOf(123.45);
		
		System.out.println(s1);		
		System.out.println(s2);
		
		System.out.println();
		
		/*
		 * 포장 객체 (=wrapper class)에 정확히 어떤 값이 저장될지 모르는 상황이라면
		 * ==와 != 연산자는 사용하지 않는 것이 좋다
		 * 
		 * 직접 내부 값을 언박싱해서 비교하거나
		 * equlas()로 내부 값을 비교하는 것이 좋다
		 * 
		 * wrapper 클래스의  equals()는 내부의 값을 비교하도록 재정의되어 있음
		 */
		
		System.out.println("[-128 ~ 127 초과값일 경우]");
		Integer i1 = 300; //자동 Boxing
		Integer i2 = 300;
		
		//★★자동 UnBoxing되어 값이 비교 300==300 -> false (비정상적인 결과 나옴, 초과값이기 때문에)
		System.out.println("== 결과 : " + (i1==i2)); //false
		System.out.println("언박싱 후 == 결과 : " + (i1.intValue() == i2.intValue()));
		System.out.println("equlas() 결과: " + i1.equals(i2));
		
		System.out.println();
		
		System.out.println("[-128 ~ 127범위값일 경우]");
		Integer i3 = 10; //자동 Boxing
		Integer i4 = 10;

		//★★자동 UnBoxing되어 값이 비교 10==10 -> true (정상적인 결과 나옴)
		System.out.println("== 결과 : " + (i3==i4)); //true
		System.out.println("언박싱 후 == 결과 : " + (i3.intValue() == i4.intValue()));
		System.out.println("equlas() 결과: " + i3.equals(i4));
		
		
	}

}


