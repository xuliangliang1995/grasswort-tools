package org.grasswort.time;


import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * @author xuliangliang
 * @Classname GsTimeUtil.java
 * @Description
 * @Date 2020/5/15
 * @blame Java Team
 */
public class GsTimeUtil {

    private final static int SECOND_PER_DAY = 24 * 60 * 60;

    private final static ZoneOffset SYSTEM_ZONE_OFF_SET = OffsetDateTime.now().getOffset();

    public static String format(ZonedDateTime zonedDateTime, String pattern) {
        return zonedDateTime.format(DateTimeFormatter.ofPattern(pattern));
    }

    public static String format(Instant instant, String pattern) {
        return instant.atZone(SYSTEM_ZONE_OFF_SET).format(DateTimeFormatter.ofPattern(pattern));
    }

    public static long daysBetween(Instant instant1, Instant instant2) {
       return Math.abs(instant2.getEpochSecond() - instant1.getEpochSecond()) / SECOND_PER_DAY;
    }

    public static long daysBetween(LocalDate localDate1, LocalDate localDate2) {
        return Math.abs(localDate1.atStartOfDay(SYSTEM_ZONE_OFF_SET).toEpochSecond()
                - localDate2.atStartOfDay(SYSTEM_ZONE_OFF_SET).toEpochSecond())
                / SECOND_PER_DAY;
    }

    public static void main(String[] args) {

        System.out.println(ZoneId.systemDefault());
        System.out.println(OffsetDateTime.now().getOffset());
        System.out.println(daysBetween(LocalDate.of(2020, 5, 12), LocalDate.of(2020, 5, 15)));
        String text = "20200512";
        char[] year = new char[4];
        char[] month = new char[2];
        char[] day = new char[2];
        text.getChars(0, 4, year, 0);
        text.getChars(4, 6, month, 0);
        text.getChars(6, 8, day, 0);
        System.out.println(year);
        System.out.println(Integer.valueOf(String.valueOf(month)));
        System.out.println(day);
    }

}
