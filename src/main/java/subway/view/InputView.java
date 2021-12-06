package subway.view;

import java.util.Scanner;

public class InputView {
	public static String inputFunctionCommand(Scanner sc) {
		System.out.println("## 원하는 기능을 선택하세요.");
		return sc.nextLine();
	}

	public static String inputRegisterStation(Scanner sc) {
		System.out.println("## 등록할 역 이름을 입력하세요.");
		return sc.nextLine();
	}

	public static String inputDeleteStation(Scanner sc) {
		System.out.println("## 삭제할 역 이름을 입력하세요.");
		return sc.nextLine();
	}

	public static String inputRegisterLine(Scanner sc) {
		System.out.println("## 등록할 노선 이름을 입력하세요.");
		String input = sc.nextLine();
		validateInputRegisterLength(input);
		return input;
	}

	private static void validateInputRegisterLength(String input) {
		if (input.length() < 2) {
			throw new IllegalArgumentException("2글자 이상이여야 합니다.");
		}
	}

	public static String inputStartStationsForRegisterLine(Scanner scanner) {
		System.out.println("## 등록할 노선의 상행 종점역 이름을 입력하세요.");
		return scanner.nextLine();
	}

	public static String inputEndStationsForRegisterLine(Scanner scanner) {
		System.out.println("## 등록할 노선의 하행 종점역 이름을 입력하세요.");
		return scanner.nextLine();
	}

	public static String inputDeleteLine(Scanner scanner) {
		System.out.println("## 삭제할 노선 이름을 입력하세요.");
		return scanner.nextLine();
	}
}
