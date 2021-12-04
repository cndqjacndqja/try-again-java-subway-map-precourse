package subway.domain;

import static subway.util.Constant.*;
import static subway.util.Message.*;

public class Station {
    private String name;

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true; //같은 객체를 참조하여 참조값이 같은경우 true를 바로 리턴해준다.
        if (object == null || getClass() != object.getClass()) return false; //비교하는 객체가 null인지 클래스가 같은지 체크한다.
        Station station = (Station) object;
        return name.equals(station.getName());
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    public void validateNameLength() {
        if(this.name.length() < MIN_STATION_NAME_LENGTH) {
            throw new IllegalArgumentException(ERROR_STATION_NAME_LENGTH_UNDER_MIN);
        }
    }
}
