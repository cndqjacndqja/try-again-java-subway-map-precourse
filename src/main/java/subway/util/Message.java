package subway.util;

public class Message {
	private static final String ERROR_MESSAGE = "[ERROR] ";
	private static final String SUCCESS_MESSAGE = "[INFO] ";

	public static String errorRouteCommand() {
		return ERROR_MESSAGE + "올바르지 않은 명령어 입니다.";
	}
	public static String errorDuplicateStation() {
		return ERROR_MESSAGE + "중복된 역이 있습니다.";
	}
	public static String errorStationNameLengthUnderMin() {
		return ERROR_MESSAGE + "최소 2글자 이상이여야 합니다.";
	}

	public static String FINISH_REGISTER_STATION() {
		return SUCCESS_MESSAGE + "지하철 역이 등록 되었습니다.";
	}

}
