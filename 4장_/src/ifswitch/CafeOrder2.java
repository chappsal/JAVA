package ifswitch;

import java.util.Scanner;

public class CafeOrder2 {

	public static void main(String[] args) {

		System.out.println("-----2.do~while 카페 주문시작-------------------------------------------------");

		Scanner scanner = new Scanner(System.in);
		String order = null;

		// 각 메뉴 카운트 변수 선언
		int americanoCount = 0;
		int caffelatteCount = 0;
		int cappuccinoCount = 0;

		// 각 메뉴 가격 변수 선언
		int totalPrice = 0;
		int americanoPrice = 3000;
		int caffelattePrice = 4000;
		int cappuccinoPrice = 3500;

		do {
			System.out.print("메뉴(아메리카노:3000원, 카페라떼:4000원, 카푸치노:3500원)중에서 주문(단, 주문안함 또는 stop)>");
			order = scanner.next(); // "주문안함"

			if (order.equals("주문안함"))
				break; // 가장 가까운 반복문 빠져나감

			switch (order) {
			case "아메리카노":
				totalPrice += americanoPrice;
				System.out.println(order + "를 " + (++americanoCount) + "잔 주문하셨습니다.");
				break;
			case "카페라떼":
				totalPrice += caffelattePrice;
				System.out.println(order + "를 " + (++caffelatteCount) + "잔 주문하셨습니다.");
				break;
			case "카푸치노":
				totalPrice += cappuccinoPrice;
				System.out.println(order + "를 " + (++cappuccinoCount) + "잔 주문하셨습니다.");
				break;
			case "stop":
				if (americanoCount == 0 && caffelatteCount == 0 && cappuccinoCount == 0) {
					System.out.println("아무것도 주문하지 않았습니다.");
					break;
				}

				String temp = "";

				if (americanoCount > 0) {
					temp += "아메리카노 " + americanoCount + "잔에 " + americanoPrice * americanoCount + "원,\n";
				}
				if (caffelatteCount > 0) {
					temp += "카페라떼 " + caffelatteCount + "잔에 " + caffelattePrice * caffelatteCount + "원,\n";
				}
				if (cappuccinoCount > 0) {
					temp += "카푸치노 " + cappuccinoCount + "잔에 " + cappuccinoPrice * cappuccinoCount + "원,\n";
				}
				temp = temp.substring(0, temp.length() - 2);

				System.out.println(temp);
				System.out.println("총 가격은 " + totalPrice + "원 입니다.");
				break;
			default:
				System.out.println("메뉴에 없습니다."); // break;
			}
		} while (!order.equalsIgnoreCase("stop"));

		System.out.println("-------2.do~while 카페 주문 처리 끝---------------------------------------------------");

	}

}
