package subway.domain.function;

import static subway.util.Message.*;

import java.util.Arrays;

public enum MainRoute {
	MANAGE_STATION("1") {
		@Override
		void function() {

		}
	},
	MANAGE_LINE("2") {
		@Override
		void function() {

		}
	},
	MANAGE_SECTION("3") {
		@Override
		void function() {

		}
	},
	PRINT_SUBWAY_MAP("4") {
		@Override
		void function() {

		}
	},
	QUIT("Q") {
		@Override
		void function() {

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
			.orElseThrow(() -> new IllegalArgumentException(errorMainRouteCommand()));
	}

	abstract void function();

	public void applyFunction() {
		this.function();
	}

	public boolean isSameQuit() {
		return this.command.equals("Q");
	}
}
