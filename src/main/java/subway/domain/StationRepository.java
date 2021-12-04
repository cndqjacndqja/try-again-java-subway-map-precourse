package subway.domain;

import static subway.util.Message.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(String name) {
        Station station = new Station(name);
        validateStation(station);
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static void validateStation(Station station) {
        validateDuplicate(station);
        validateNameLength(station);
    }

    private static void validateDuplicate(Station station) {
        Optional<Station> stationOptional = stations.stream()
            .filter(i -> i.equals(station))
            .findAny();

        if(stationOptional.isPresent()) {
            throw new IllegalArgumentException(errorDuplicateStation());
        };
    }

    private static void validateNameLength(Station station) {
        station.validateNameLength();
    }
}
