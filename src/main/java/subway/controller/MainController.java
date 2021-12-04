package subway.controller;

import static subway.view.InputView.*;
import static subway.view.OutputView.*;

import java.util.Scanner;

import subway.domain.function.MainRoute;

public class MainController {
	public void run(Scanner sc) {
		printMainScreen();
		MainRoute mainRoute = MainRoute.findRoute(inputFunctionCommand(sc));
		if (mainRoute.isSameQuit()) {
			return;
		}
		mainRoute.applyFunction(sc);
		run(sc);
	}
}
