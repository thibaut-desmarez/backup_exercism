import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAmount;

public class Gigasecond {
    LocalDateTime dateTime = LocalDateTime.now();

    public Gigasecond(LocalDate moment) {
        this.dateTime = LocalDateTime.of(moment, LocalTime.MIN);
    }

    public Gigasecond(LocalDateTime moment) {
        this.dateTime = moment;
    }

    public LocalDateTime getDateTime() {
        return this.dateTime.plusDays(11574).plusHours(1).plusMinutes(46).plusSeconds(40);
    }
}