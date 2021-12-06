package subway.domain.function;

import static subway.domain.LineRepository.*;
import static subway.view.InputView.*;

import java.util.Scanner;

public enum SectionRoute {
	REGISTER_SECTION("1") {
		@Override
		void function(Scanner scanner) {
			String lineName = inputLinenNameForRegisterSection(scanner);
			String stationName = inputStationNameForRegisterSection(scanner);
			int numberForRegisterSection = inputNumberForRegisterSection(scanner);
			registerSection(lineName, stationName, numberForRegisterSection);
		}
	},
	DELETE_SECTION("2") {
		@Override
		void function(Scanner scanner) {


		}
	},
	BACK("B") {
		@Override
		void function(Scanner scanner) {

		}
	},
	;

	private String command;

	abstract void function(Scanner scanner);

	SectionRoute(String command) {
		this.command = command;
	}
}
