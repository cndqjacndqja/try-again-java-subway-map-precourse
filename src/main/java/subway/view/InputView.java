package subway.view;

import static subway.util.Constant.*;

import java.util.Scanner;

public class InputView {
	public static String inputFunctionCommand(Scanner sc) {
		System.out.println(TITLE_CHOICE_FUNCTION);
		return sc.nextLine();
	}

	public static String inputRegisterStation(Scanner sc) {
		System.out.println(TITLE_REGISTER_STATION);
		return sc.nextLine();
	}

	public static String inputDeleteStation(Scanner sc) {
		System.out.println(TITLE_DELETE_STATION);
		return sc.nextLine();
	}
}
