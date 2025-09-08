import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

class SpaceAge {

    long seconds = 0;

    SpaceAge(long seconds) {
        this.seconds = seconds;
    }

    long getSeconds() {
        return seconds;
    }

    double onEarth() {
        LocalDateTime start = LocalDateTime.of(0, 1, 1, 0,0);
        LocalDateTime age = start.plusSeconds(getSeconds());
        return age.getYear() + age.getDayOfYear()/365.25;
    }

    double onMercury() {
        return onEarth() / 0.2408467;
    }

    double onVenus() {
        return onEarth() / 0.61519726;
    }

    double onMars() {
        return onEarth() / 1.8808158;
    }

    double onJupiter() {
        return onEarth() / 11.862615;
    }

    double onSaturn() {
        return onEarth() / 29.447498;
    }

    double onUranus() {
        return onEarth() / 84.016846;
    }

    double onNeptune() {
        return onEarth() / 164.79132;
    }

}
