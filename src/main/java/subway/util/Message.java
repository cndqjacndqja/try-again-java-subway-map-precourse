package subway.util;

public class Message {
	private static final String ERROR_MESSAGE = "[ERROR]";

	public static String errorRouteCommand() {
		return ERROR_MESSAGE + "올바르지 않은 명령어 입니다.";
	}
}
