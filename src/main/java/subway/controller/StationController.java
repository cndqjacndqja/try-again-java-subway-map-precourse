package subway.controller;

import static subway.view.InputView.*;
import static subway.view.OutputView.*;

import java.util.Scanner;

import subway.domain.function.StationRoute;

public class StationController {
	public void run(Scanner sc) {
		printManageStationScreen();
		StationRoute stationRoute = StationRoute.findRoute(inputFunctionCommand(sc));
		if(stationRoute.isSameQuit()) {
			return;
		}
		stationRoute.applyFunction(sc);
	}
}
