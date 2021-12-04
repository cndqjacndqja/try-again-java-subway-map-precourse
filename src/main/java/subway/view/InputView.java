package subway.view;

import static subway.util.Constant.*;

import java.util.Scanner;

public class InputView {
	public static String inputMainRouteCommand(Scanner sc) {
		System.out.println(TITLE_MAIN_CHOICE_MAIN_FUNCTION);
		return sc.nextLine();
	}

}
