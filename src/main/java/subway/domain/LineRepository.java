package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
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

    private static void validateAddLine(Line line) {

    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }
}
