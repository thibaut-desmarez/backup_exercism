public enum LogLevel {
    TRACE("TRC"),
    DEBUG("DBG"),
    INFO("INF"),
    WARNING("WRN"),
    ERROR("ERR"),
    FATAL("FTL"),
    UNKNOWN("UNKNOWN");

    private final String logLevel;

    LogLevel(String logLevel) {
        this.logLevel = logLevel;
    }

    public String getLogLevel() {
        return this.logLevel;
    }
}
