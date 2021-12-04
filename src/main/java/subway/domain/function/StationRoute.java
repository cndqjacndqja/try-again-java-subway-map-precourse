package subway.domain.function;

import static subway.util.Message.*;
import static subway.view.InputView.*;
import static subway.view.OutputView.*;

import java.util.Arrays;
import java.util.Scanner;

import subway.domain.StationRepository;

public enum StationRoute {
	REGISTER_STATION("1") {
		@Override
		void function(Scanner sc) {
			try {
				StationRepository.addStation(inputRegisterStation(sc));
				printFinishRegisterStation();
			} catch (IllegalArgumentException exception) {
				System.out.println(exception.getMessage());
				function(sc);
			}
		}
	},
	REMOVE_STATION("2") {
		@Override
		void function(Scanner sc) {
			try {
				StationRepository.deleteStation(inputDeleteStation(sc));
				printFinishDeleteStation();
			} catch (IllegalArgumentException exception) {
				System.out.println(exception.getMessage());
				function(sc);
			}
		}
	},
	FIND_STATION("3") {
		@Override
		void function(Scanner sc) {

		}
	},
	BACK("B") {
		@Override
		void function(Scanner sc) {

		}
	};
	private String command;

	abstract void function(Scanner sc);

	StationRoute(String command) {
		this.command = command;
	}

	public static StationRoute findRoute(String command) {
		return Arrays.stream(values())
			.filter(i -> i.command.equals(command))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException(ERROR_ROUTE_COMMAND));
	}

	public void applyFunction(Scanner sc) {
		this.function(sc);
	}

	public boolean isSameQuit() {
		return this.command.equals("B");
	}
}
