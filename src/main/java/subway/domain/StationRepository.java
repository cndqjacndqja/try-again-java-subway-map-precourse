package subway.domain;

import static subway.view.OutputView.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public static void deleteStation(String name) {
        Station station = new Station(name);
        validateStationForDelete(station);
        stations.remove(station);
    }

    private static void validateStationForDelete(Station station) {
        for (Station stationInStations : stations) {
            if (stationInStations.equals(station)) {
                return;
            }
        }
        throw new IllegalArgumentException(ERROR_MESSAGE + "입력한 역이 존재하지 않습니다.");
    }

    public static void validateStation(Station station) {
        validateDuplicate(station);
        validateNameLength(station);
        validateIsRegisterLine(station);
    }

    private static void validateIsRegisterLine(Station station) {
        if(LineRepository.isRegisterStation(station)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "노선에 등록된 역은 삭제할 수 없습니다.");
        }
    }

    private static void validateDuplicate(Station station) {
        Optional<Station> stationOptional = stations.stream()
            .filter(i -> i.equals(station))
            .findAny();

        if(stationOptional.isPresent()) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "중복된 역이 있습니다.");
        }
    }

    private static void validateNameLength(Station station) {
        station.validateNameLength();
    }

    public static List<String> getStationNames() {
        return stations.stream()
            .map(Station::toString)
            .collect(Collectors.toList());
    }
}
