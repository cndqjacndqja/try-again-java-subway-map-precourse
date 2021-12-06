package subway.view;


import java.util.List;

public class OutputView {
	public static final String ERROR_MESSAGE = "[ERROR] ";
	public static final String INFO_MESSAGE = "[INFO] ";

	public static void printMainScreen() {
		System.out.println("## 메인 화면");
		System.out.println("1. 역 관리");
		System.out.println("2. 노선 관리");
		System.out.println("3. 구간 관리");
		System.out.println("4. 지하철 노선도 출력");
		System.out.println("Q. 종료");
		printEmptyLine();
	}

	public static void printManageStationScreen() {
		System.out.println("## 역 관리 화면");
		System.out.println("1. 역 등록");
		System.out.println("2. 역 삭제");
		System.out.println("3. 역 조회");
		System.out.println("B. 돌아가기");
		printEmptyLine();
	}

	public static void printEmptyLine() {
		System.out.println();
	}


	public static void printFinishRegisterStation() {
		System.out.println(INFO_MESSAGE + "지하철 역이 등록 되었습니다.");
		printEmptyLine();
	}

	public static void printFinishDeleteStation() {
		System.out.println(INFO_MESSAGE + "지하철 역이 삭제 되었습니다.");
		printEmptyLine();
	}

	public static void printStationNames(List<String> stationNames) {
		System.out.println("## 역 목록");
		for (String stationName : stationNames) {
			System.out.println(stationName);
		}
		printEmptyLine();
	}

	public static void printManageLineScreen() {
		System.out.println("## 노선 관리 화면");
		printEmptyLine();
	}

	public static void printFinishRegisterLine() {
		System.out.println(INFO_MESSAGE + "지하철 노선이 등록되었습니다.");
	}

	public static void printFinishDeleteLine() {
		System.out.println(INFO_MESSAGE + "지하철 역이 삭제되었습니다.");
	}

	public static void printAllLineNames(List<String> lineNames) {
		for (String lineName: lineNames) {
			System.out.println(INFO_MESSAGE + lineName);
		}
	}
}
