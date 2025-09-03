import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

class AppointmentScheduler {
    public LocalDateTime schedule(String appointmentDateDescription) {
        DateTimeFormatter parser = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
        return LocalDateTime.parse(appointmentDateDescription, parser);
    }

    public boolean hasPassed(LocalDateTime appointmentDate) {
        return appointmentDate.isBefore(LocalDateTime.now());
    }

    public boolean isAfternoonAppointment(LocalDateTime appointmentDate) {
        return (appointmentDate.getHour() >= 12 && appointmentDate.getHour() < 18);
    }

    public String getDescription(LocalDateTime appointmentDate) {
        return new StringBuilder().append("You have an appointment on ")
                .append(appointmentDate.getDayOfWeek().toString().substring(0,1).toUpperCase())
                .append(appointmentDate.getDayOfWeek().toString().substring(1).toLowerCase())
                .append(", ")
                .append(String.valueOf(appointmentDate.getMonth()).substring(0,1).toUpperCase())
                .append(String.valueOf(appointmentDate.getMonth()).substring(1).toLowerCase())
                .append(" ")
                .append(appointmentDate.getDayOfMonth())
                .append(", ")
                .append(appointmentDate.getYear())
                .append(", at ")
                .append(DateTimeFormatter.ofPattern("h:mm a").format(appointmentDate))
                .append(".")
                .toString();
    }

    public LocalDate getAnniversaryDate() {
        return LocalDate.of(LocalDate.now().getYear(),9,15);
    }
}
