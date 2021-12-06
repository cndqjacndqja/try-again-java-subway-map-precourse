package subway.domain.function;

import static subway.view.InputView.*;
import static subway.view.OutputView.*;

import java.util.Arrays;
import java.util.Scanner;

import subway.domain.Line;
import subway.domain.LineRepository;

public enum LineRoute {
	REGISTER_LINE("1") {
		@Override
		void function(Scanner sc) {
			try {
				String lineName = inputRegisterLine(sc);
				String startStation = inputStartStationsForRegisterLine(sc);
				String endStation = inputEndStationsForRegisterLine(sc);
				if (startStation.equals(endStation)) {
					throw new IllegalArgumentException(ERROR_MESSAGE + "상행 종점역과 하행 종점역이 같습니다.");
				}
				LineRepository.addLine(new Line(lineName, startStation, endStation));
				printFinishRegisterLine();
			} catch (IllegalArgumentException illegalArgumentException) {
				System.out.println(illegalArgumentException.getMessage());
				function(sc);
			}
		}
	},
	DELETE_LINE("2") {
		@Override
		void function(Scanner sc) {
			try {
				String lineNameForDelete = inputDeleteLine(sc);
				LineRepository.deleteLineByName(lineNameForDelete);
				printFinishDeleteLine();
			} catch (IllegalArgumentException illegalArgumentException) {
				System.out.println(illegalArgumentException.getMessage());
				function(sc);
			}
		}
	},
	FIND_LINE("3") {
		@Override
		void function(Scanner sc) {
			printAllLineNames(LineRepository.getAllLineNames());
		}
	},
	BACK("B") {
		@Override
		void function(Scanner sc) {

		}
	};

	private String command;

	abstract void function(Scanner sc);

	LineRoute(String command) {
		this.command = command;
	}

	public static LineRoute findRoute(String command) {
		return Arrays.stream(values())
			.filter(i -> i.command.equals(command))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException(ERROR_MESSAGE + "올바르지 않은 명령어 입니다."));
	}

	public void applyFunction(Scanner sc) {
		this.function(sc);
	}

	public boolean isSameQuit() {
		return this.command.equals("B");
	}
}