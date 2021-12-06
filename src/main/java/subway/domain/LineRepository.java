package subway.domain;

import static subway.view.OutputView.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LineRepository {
	private static final List<Line> lines = new ArrayList<>();

	static {
		lines.add(new Line("2호선", "교대역", "역삼역"));
		findByName("2호선").addSection(new Station("강남역"), 1);
		lines.add(new Line("3호선", "교대역", "매봉역"));
		findByName("3호선").addSection(new Station("남부터미널역"), 1);
		findByName("3호선").addSection(new Station("양재역"), 2);
		lines.add(new Line("신분당선", "강남역", "양재시민의숲역"));
		findByName("신분당선").addSection(new Station("양재역"), 1);
	}
	public static List<Line> lines() {
		return Collections.unmodifiableList(lines);
	}

	public static void addLine(Line line) {
		validateAddLine(line);
		lines.add(line);
	}

	public static Line findByName(String lineName) {
		return lines.stream()
			.filter(i-> i.getName().equals(lineName))
			.findFirst()
			.orElseThrow(() ->  new IllegalArgumentException("존재하지 않는 노선입니다."));
	}

	public static List<String> getAllLineNames() {
		return lines().stream()
			.map(Line::getName)
			.collect(Collectors.toList());
	}

	public static void registerSection(String lineName, String stationName, int numberOfOrder) {
		Line line = lines().stream()
			.filter(i -> i.getName().equals(lineName))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("노선이 존재하지 않습니다."));

		line.addSection(new Station(stationName), numberOfOrder);
	}

	public static void deleteSection(String lineName, String station) {
		Line line = lines().stream()
			.filter(lineElement -> lineElement.getName().equals(lineName))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("노선이 존재하지 않습니다."));

		line.deleteSection(new Station(station));
	}

	private static void validateAddLine(Line line) {
		for (Line lineInLineList : lines) {
			if (Objects.equals(lineInLineList.getName(), line.getName())) {
				throw new IllegalArgumentException(ERROR_MESSAGE + "중복된 노선이 있습니다.");
			}
		}
	}

	public static void deleteLineByName(String name) {
		if (!lines.removeIf(line -> Objects.equals(line.getName(), name))) {
			throw new IllegalArgumentException("존재하지 않는 노선입니다.");
		}
	}

	public static boolean isRegisterStation(Station station) {
		for (Line line : lines) {
			if (line.isRegisterStation(station)) {
				return true;
			}
		}
		return false;
	}
}
