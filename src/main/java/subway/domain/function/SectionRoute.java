package subway.domain.function;

import static subway.domain.LineRepository.*;
import static subway.view.InputView.*;
import static subway.view.OutputView.*;

import java.util.Arrays;
import java.util.Scanner;

import subway.domain.LineRepository;

public enum SectionRoute {
	REGISTER_SECTION("1") {
		@Override
		void function(Scanner scanner) {
			String lineName = inputLinenNameForRegisterSection(scanner);
			String stationName = inputStationNameForRegisterSection(scanner);
			int numberForRegisterSection = inputNumberForRegisterSection(scanner);
			registerSection(lineName, stationName, numberForRegisterSection);
			printFinishRegisterSection();
		}
	},
	DELETE_SECTION("2") {
		@Override
		void function(Scanner scanner) {
			String lineNameForDeleteSection = inputLineNameForDeleteSection(scanner);
			String stationNameForDeleteSection =inputStationNameForDeleteSection(scanner);
			LineRepository.deleteSection(lineNameForDeleteSection, stationNameForDeleteSection);
			printFinishDeleteSection();
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

	public String getCommand() {
		return command;
	}


	public static SectionRoute findRoute(String command) {
		return Arrays.stream(values())
			.filter(i->i.getCommand().equals(command))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException(ERROR_MESSAGE + "올바르지 않은 명령어입니다."));
	}


	public boolean isSameQuit() {
		return this.command.equals("B");
	}
	public void applyFunction(Scanner sc) {
		this.function(sc);
	}
}
