package subway.controller;

import static subway.view.InputView.*;
import static subway.view.OutputView.*;

import java.util.Scanner;

import subway.domain.function.SectionRoute;
import subway.domain.function.StationRoute;

public class SectionController {

	public void run(Scanner sc) {
		printManageSectionScreen();
		SectionRoute sectionRoute = SectionRoute.findRoute(inputFunctionCommand(sc));
		if(sectionRoute.isSameQuit()) {
			return;
		}
		sectionRoute.applyFunction(sc);
		run(sc);
	}
}
