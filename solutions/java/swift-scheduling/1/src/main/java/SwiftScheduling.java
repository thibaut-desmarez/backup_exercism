import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

public class SwiftScheduling {

    public static LocalDateTime convertToDeliveryDate(LocalDateTime meetingStart, String description) {
        LocalDateTime deliveryDate = meetingStart;
        if(description.equals("NOW")) {
            return deliveryDate.plusHours(2);
        }

        if(description.equals("ASAP")) {
            if(meetingStart.getHour() < 13) {
                return setTheHour(deliveryDate,17);

            }
            else{
                deliveryDate = deliveryDate.plusDays(1);
                return setTheHour(deliveryDate,13);
            }
        }

        if(description.equals("EOW")) {
            if(meetingStart.getDayOfWeek() == DayOfWeek.MONDAY){
                deliveryDate = setTheHour(deliveryDate,17);
                return deliveryDate.plusDays(4);
            }
            else if(meetingStart.getDayOfWeek() == DayOfWeek.TUESDAY){
                deliveryDate = setTheHour(deliveryDate,17);
                return deliveryDate.plusDays(3);
            }
            else if(meetingStart.getDayOfWeek() == DayOfWeek.WEDNESDAY) {
                deliveryDate = setTheHour(deliveryDate,17);
                return deliveryDate.plusDays(2);
            }
            else if(meetingStart.getDayOfWeek() == DayOfWeek.THURSDAY) {
                deliveryDate = setTheHour(deliveryDate,20);
                return deliveryDate.plusDays(3);
            }
            else if(meetingStart.getDayOfWeek() == DayOfWeek.FRIDAY) {
                deliveryDate = setTheHour(deliveryDate,20);
                return deliveryDate.plusDays(2);
            }
            else{
                throw new IllegalArgumentException();
            }
        }

        if(description.contains("M")) {
            int month = Integer.parseInt(description.split("M")[0]);
            deliveryDate = setTheHour(deliveryDate,8);
            deliveryDate = setTheMonthFirstDay(deliveryDate,month);
            if(meetingStart.getMonth().getValue() >= month) {
                deliveryDate = deliveryDate.plusYears(1);
            }
            return findFirstWorkdayOfMonth(deliveryDate);
        }
        else{//Q
            int quarter = Integer.parseInt(description.split("Q")[1]);
            if(quarter*3 < deliveryDate.getMonth().getValue()) {
                deliveryDate = deliveryDate.plusYears(1);
            }
            deliveryDate = setTheHour(deliveryDate,8);
            deliveryDate = setMonthNextQuarter(deliveryDate,quarter*3);
            deliveryDate = setTheMonthLastDay(deliveryDate);
            deliveryDate = findLastWorkdayOfMonth(deliveryDate);
            return deliveryDate;
        }
    }


    static LocalDateTime setTheHour(LocalDateTime deliveryDate, int hour){
        return LocalDateTime.of(deliveryDate.getYear(), deliveryDate.getMonth(), deliveryDate.getDayOfMonth(), hour, 0);
    }

    static LocalDateTime setTheMonthFirstDay(LocalDateTime deliveryDate, int month){
        return LocalDateTime.of(deliveryDate.getYear(), month, 1, deliveryDate.getHour(), 0);
    }

    static LocalDateTime setTheMonthLastDay(LocalDateTime deliveryDate){
        return LocalDateTime.of(deliveryDate.getYear(), deliveryDate.getMonth(), deliveryDate.with(TemporalAdjusters.lastDayOfMonth()).getDayOfMonth(), deliveryDate.getHour(), 0);
    }

    static LocalDateTime setMonthNextQuarter(LocalDateTime deliveryDate, int month){
        return LocalDateTime.of(deliveryDate.getYear(),  month, deliveryDate.getDayOfMonth(), deliveryDate.getHour(), 0);
    }

    static LocalDateTime findFirstWorkdayOfMonth(LocalDateTime deliveryDate){
        if(deliveryDate.getDayOfWeek() == DayOfWeek.SATURDAY){
            return deliveryDate.plusDays(2);
        }
        if(deliveryDate.getDayOfWeek() == DayOfWeek.SUNDAY) {
            return deliveryDate.plusDays(1);
        }
        return deliveryDate;
    }

    static LocalDateTime findLastWorkdayOfMonth(LocalDateTime deliveryDate){
        if(deliveryDate.getDayOfWeek() == DayOfWeek.SATURDAY){
            return deliveryDate.minusDays(1);
        }
        if(deliveryDate.getDayOfWeek() == DayOfWeek.SUNDAY) {
            return deliveryDate.minusDays(2);
        }
        return deliveryDate;
    }
}
