package ifswitch;

import java.util.Scanner;

public class CafeOrder {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String order="";
		
		System.out.println("----2.do~while문 카페 주문 처리 시작------------");

		int amCnt = 0, cfCnt = 0, cpCnt = 0; // 각 메뉴 count 변수 선언 , 아메 카페 카푸
		int price = 0;
		int amPrice = 0, cfPrice = 0, cpPrice = 0, totalCnt = 0;

		// String order; // 위에서 선언됨

		cafe: do {
			System.out.print("메뉴(Americano:3000원,카페라떼:4000원,카푸치노:3500원)중에서 주문\n"
					+ "(단,주문안함(=NoOrder), stop)");
			order = sc.next(); // 주문안함

			if (order.equalsIgnoreCase("주문안함") || order.equalsIgnoreCase("NoOrder")) {
				break;
			}

			switch (order.toUpperCase()) { // 영어가 대문자로 변환 , 경우의 수 줄이기, order가 참조하는 것은 대문자가 아니라 입력한 값 그 자체임(대입연산자를 사용하지 않는 이상)
											
			case "AMERICANO":
				System.out.println(order + "를(을) 주문하셨습니다.");
				amCnt++;
				amPrice += 3000;
				break;
			case "카페라떼":
				System.out.println(order + "를(을) 주문하셨습니다.");
				cfCnt++;
				cfPrice += 4000;
				break;
			case "카푸치노":
				System.out.println(order + "를(을) 주문하셨습니다.");
				cpCnt++;
				cpPrice += 3500;
				break;
			case "STOP":
				System.out.println("그만 주문하겠습니다.");

				String tempOrder = "";
				if (amCnt > 0)
					tempOrder += "아메리카노" + amCnt + "잔에" + amPrice + "원, ";
				if (cfCnt > 0)
					tempOrder += "카페라떼" + cfCnt + "잔에" + cfPrice + "원, ";
				if (cpCnt > 0)
					tempOrder += "카푸치노" + cpCnt + "잔에" + cpPrice + "원, ";

				tempOrder = tempOrder.substring(0, tempOrder.length() - 2);

				totalCnt = amCnt + cfCnt + cpCnt;
				price = amPrice + cfPrice + cpPrice;

				if (totalCnt > 0)
					System.out.println(tempOrder + "\n총" + totalCnt + "잔, 총 가격은 " + price + "입니다.");
				break cafe; // cafe (do~while)레이블 빠져나감
			default:
				System.out.println("메뉴에 없습니다.");
			}

		} while (!order.equalsIgnoreCase("stop")); // 위에서 대문자만 참조하고 있기 때문에 IgnoreCase 떼도 됨
		if (amCnt + cfCnt + cpCnt != 0) {
			System.out.println(

					"아메리카노" + amCnt + "잔, " + "카페라떼 " + cfCnt + "잔, 카푸치노 " + cpCnt + "잔 총 " + (amCnt + cfCnt + cpCnt)
							+ "잔 가격은 " + price + "원 입니다.");

		}
		System.out.println("2.do~while문 카페 주문 처리 끝");


	}

}