package subway.view;

import static subway.util.Constant.*;
import static subway.util.Message.*;

public class OutputView {

	public static void printMainScreen() {
		System.out.println(TITLE_MAIN_SCREEN);
		System.out.println(TITLE_MANAGE_STATION);
		System.out.println(TITLE_MANAGE_LINE);
		System.out.println(TITLE_MANAGE_SECTION);
		System.out.println(TITLE_PRINT_SUBWAY_MAP);
		System.out.println(TITLE_QUIT);
		printEmptyLine();
	}

	public static void printManageStationScreen() {
		System.out.println(TITLE_MANAGE_STATION_SCREEN);
		System.out.println(TITLE_MANAGE_STATION);
		System.out.println(TITLE_STATION_STATION_REMOVE);
		System.out.println(TITLE_FIND_STATION);
		System.out.println(TITLE_BACK);
		printEmptyLine();
	}

	public static void printEmptyLine() {
		System.out.println();
	}

	public static void printFinishRegisterStation() {
		System.out.println(MESSAGE_FINISH_REGISTER_STATION);
	}

	public static void printFinishDeleteStation() {
		System.out.println(SUCCESS_DELETE_STATION);

	}
}
