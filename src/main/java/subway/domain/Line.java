package subway.domain;

import java.util.LinkedList;

public class Line {
    private String name;
    private LinkedList<Station> stationList = new LinkedList<>();

    public Line(String name, String startStationName, String endStationName) {
        this.name = name;
        stationList.addFirst(new Station(startStationName));
        stationList.addLast(new Station(endStationName));
    }

    public String getName() {
        return name;
    }

    public void addSection(Station station, int numberOfOrder) {
        Station getStation = StationRepository.getStation(station);
        stationList.add(numberOfOrder, getStation);
    }

    public void deleteSection(Station station) {
        stationList.remove(station);
    }

    public boolean isRegisterStation(Station station) {
        for (Station stationInLine: stationList) {
            if (stationInLine.equals(station)) {
                return true;
            }
        }
        return false;
    }
}
