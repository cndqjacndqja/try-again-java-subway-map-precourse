package subway.controller;

import static subway.view.InputView.*;
import static subway.view.OutputView.*;

import java.util.Scanner;

import subway.domain.function.LineRoute;

public class LineController {
	public void run(Scanner sc) {
		printManageLineScreen();
		LineRoute lineRoute = LineRoute.findRoute(inputFunctionCommand(sc));
		if(lineRoute.isSameQuit()) {
			return;
		}
		lineRoute.applyFunction(sc);
	}
}
