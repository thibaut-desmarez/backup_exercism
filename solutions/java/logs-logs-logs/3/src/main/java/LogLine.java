import java.util.Arrays;
import java.util.Optional;

public class LogLine {

    String message;
    LogLevel logLevel;
    public LogLine(String logLine) {
        String logLevelValue = logLine.split(":")[0].substring(1,4);
        this.message = logLine.split(":")[1].trim();
        this.logLevel = Arrays.stream(LogLevel.values())
                .filter(logLevel -> logLevel.getLogLevel().equals(logLevelValue))
                .findFirst()
                .orElse(LogLevel.UNKNOWN);
    }

    public LogLevel getLogLevel() {
        return  this.logLevel;
    }

    public String getOutputForShortLog() {
        return switch (this.logLevel.getLogLevel()) {
            case "UNKNOWN" -> "0:" + this.message;
            case "TRC" -> "1:" + this.message;
            case "DBG" -> "2:" + this.message;
            case "INF" -> "4:" + this.message;
            case "WRN" -> "5:" + this.message;
            case "ERR" -> "6:" + this.message;
            case "FTL" -> "42:" + this.message;
            default -> throw new IllegalStateException("Unexpected value: " + this.logLevel.getLogLevel());
        };
    }
}
