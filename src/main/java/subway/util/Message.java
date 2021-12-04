package subway.util;

public class Message {
	private static final String ERROR_MESSAGE = "[ERROR] ";
	private static final String SUCCESS_MESSAGE = "[INFO] ";

	public static String ERROR_ROUTE_COMMAND = ERROR_MESSAGE + "올바르지 않은 명령어 입니다.";
	public static String ERROR_DUPLICATE_STATION = ERROR_MESSAGE + "중복된 역이 있습니다.";
	public static String ERROR_STATION_NAME_LENGTH_UNDER_MIN = ERROR_MESSAGE + "최소 2글자 이상이여야 합니다.";
	public static String MESSAGE_FINISH_REGISTER_STATION = SUCCESS_MESSAGE + "지하철 역이 등록 되었습니다.";
	public static String ERROR_MESSAGE_NOT_EXIST_STATION = ERROR_MESSAGE + "입력한 역이 존재하지 않습니다.";
	public static String SUCCESS_DELETE_STATION = SUCCESS_MESSAGE + "지하철 역이 삭제 되었습니다.";

}
