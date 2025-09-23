import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class SplitSecondStopwatch {

    private String state;
    private LocalTime currentLap;
    private LocalTime total;
    private List<String> previousLaps;

    public SplitSecondStopwatch() {
        this.state = "ready";
        this.currentLap = LocalTime.of(0,0,0);
        this.total = LocalTime.of(0,0,0,0);
        this.previousLaps = new ArrayList<>();
    }

    public String state() {return this.state;}
    public String currentLap() {return this.currentLap.format(DateTimeFormatter.ofPattern("HH:mm:ss"));}
    public String total() {
        return this.total.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }
    public java.util.List<String> previousLaps() {return this.previousLaps;}

    public void start() {
        if(this.state.equals("running")){
            throw new IllegalStateException("cannot start an already running stopwatch");
        }
        this.state = "running";
    }

    public void stop() {
        if(!this.state.equals("running")){
            throw new IllegalStateException("cannot stop a stopwatch that is not running");
        }
        this.state = "stopped";
    }

    public void reset() {
        if(!this.state.equals("stopped")){
            throw new IllegalStateException("cannot reset a stopwatch that is not stopped");
        }
        this.currentLap = LocalTime.of(0,0,0);
        this.previousLaps = new ArrayList<>();
        this.state = "ready";
    }

    public void lap() {
        if(!this.state.equals("running")){
            throw new IllegalStateException("cannot lap a stopwatch that is not running");
        }
        this.previousLaps.add(currentLap());
        this.currentLap = LocalTime.of(0,0,0);
    }

    public void advanceTime(String timeString) {
        if(this.state.equals("running")){
            String[] timeParts = timeString.split(":");
            this.currentLap = this.currentLap.plusHours(Integer.parseInt(timeParts[0]));
            this.currentLap = this.currentLap.plusMinutes(Integer.parseInt(timeParts[1]));
            this.currentLap = this.currentLap.plusSeconds(Integer.parseInt(timeParts[2]));

            this.total = this.total.plusHours(Integer.parseInt(timeParts[0]));
            this.total = this.total.plusMinutes(Integer.parseInt(timeParts[1]));
            this.total = this.total.plusSeconds(Integer.parseInt(timeParts[2]));
        }
    }
}