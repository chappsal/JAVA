package ifswitch;

import java.util.Scanner;

public class CafeOrder3 {

	public static void main(String[] args) {

		System.out.println("[과제1]do~while문 카페 주문 처리시작");
		Scanner sc = new Scanner(System.in);
		String order = null; // 메뉴선택
		int amCnt = 0, cpCnt = 0, cfCnt = 0; // 메뉴개수
		
		int amPie = 3000;
		int cpPie = 4000;
		int cfPie = 3500; // 메뉴가격
		int sum = 0; // 총 가격

		do {
			System.out.print(
					"------메뉴-------\n"
					+ "아메리카노 3000원\n"
					+ "카페라떼 4000원\n"
					+ "카푸치노 3500원\n"
					+ "주문종료 stop\n"
					+ "주문안함 NoOrder\n"
					+ "--------------\n"
					+ "--주문해주세요>");
			order = sc.next();
			
			if (order.equalsIgnoreCase("주문안함") || order.equalsIgnoreCase("NoOrder")) {
				break;
			}
			
			switch (order) {
			case "아메리카노":
				System.out.println(order + "를 주문하셨습니다.");
				System.out.print("--몇 잔을 주문하시겠습니까?>");
				amCnt = sc.nextInt();
				if (amCnt > 0) {
					System.out.println(order + " " + amCnt + "잔을 주문하셨습니다.");
				} else {
					System.out.println("0은 입력할 수 없습니다.");
				}
				sum = sum + amCnt * amPie;
				break;

			case "카페라떼":
				System.out.println(order + "를 주문하셨습니다.");
				System.out.print("--몇 잔을 주문하시겠습니까?>");
				cpCnt = sc.nextInt();
				if (cpCnt > 0) {
					System.out.println(order + " " + cpCnt + "잔을 주문하셨습니다.");
				} else {
					System.out.println("0은 입력할 수 없습니다.");
				}
				sum = sum + cpCnt * cpPie;
				break;

			case "카푸치노":
				System.out.println(order + "를 주문하셨습니다.");
				System.out.print("--몇 잔을 주문하시겠습니까?>");
				cfCnt = sc.nextInt();
				if (cfCnt > 0) {
					System.out.println(order + " " + cfCnt + "잔을 주문하셨습니다.");
				} else {
					System.out.println("0은 입력할 수 없습니다.");
				}
				sum = sum + cfCnt * cfPie;
				break;

			case "stop":
				System.out.println("그만 주문하겠습니다.");
				break;

			default:
				System.out.println("메뉴에 없습니다.");
				break;
			}
			
		} while (!order.equalsIgnoreCase("stop"));
		
		if(!(order.equals("주문안함") || order.equalsIgnoreCase("NoOrder")) ) {
			System.out.println("------주문내역------");
			String tempOrder = "";
			if (amCnt > 0)
				tempOrder = tempOrder + "아메리카노" + amCnt + "잔에 " + amPie + "원,  \n";
			if (cpCnt > 0)
				tempOrder = tempOrder + "카페라떼" + cpCnt + "잔에 " + cpPie + "원,  \n";
			if (cfCnt > 0)
				tempOrder = tempOrder + "카푸치노" + cfCnt + "잔에 " + cfPie + "원,  \n";
			tempOrder = tempOrder.substring(0, tempOrder.length() - 4); // 콤마 스페이스 줄바꿈 모두 포함 +1
			System.out.println(tempOrder + "\n총 " + (amCnt + cpCnt + cfCnt) + "잔, 총 가격은 " + sum + "원 입니다.");	
			
		}
		System.out.println("do~while문 카페 주문 처리끝");
	}

}
