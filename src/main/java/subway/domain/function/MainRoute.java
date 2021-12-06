package subway.domain.function;

import static subway.view.OutputView.*;

import java.util.Arrays;
import java.util.Scanner;

import subway.controller.StationController;

public enum MainRoute {
	MANAGE_STATION("1") {
		@Override
		void function(Scanner sc) {
			StationController stationController = new StationController();
			stationController.run(sc);
		}
	},
	MANAGE_LINE("2") {
		@Override
		void function(Scanner sc) {

		}
	},
	MANAGE_SECTION("3") {
		@Override
		void function(Scanner sc) {

		}
	},
	PRINT_SUBWAY_MAP("4") {
		@Override
		void function(Scanner sc) {

		}
	},
	QUIT("Q") {
		@Override
		void function(Scanner sc) {

		}
	};

	private String command;

	MainRoute(String command) {
		this.command = command;
	}

	public static MainRoute findRoute(String command) {
		return Arrays.stream(values())
			.filter(i -> i.command.equals(command))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException(ERROR_MESSAGE + "올바르지 않은 명령어 입니다."));
	}

	abstract void function(Scanner sc);

	public void applyFunction(Scanner sc) {
		this.function(sc);
	}

	public boolean isSameQuit() {
		return this.command.equals("Q");
	}
}
