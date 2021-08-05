package com.facecto.code.base.utils;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * @author Jon So
 * @author page https://cto.pub
 * @date 2021/5/01
 */
public class DateTimeUtils {

    /**
     * yyyy-MM-dd
     */
    public final static String DATE_PATTERN = "yyyy-MM-dd";

    /**
     * yyyy-MM-dd HH:mm:ss
     */
    public final static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    /**
     * yyyyMMddHHmmss
     */
    public final static String DATE_TIME_STRING_PATTERN = "yyyyMMddHHmmss";

    /**
     * get milliseconds now
     *
     * @return
     */
    public static long getMilli() {
        return LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
    }

    /**
     * get seconds now
     *
     * @return
     */
    public static long getSecond() {
        return LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"));
    }


    /**
     * get milliseconds by local datetime
     *
     * @param time
     * @return
     */
    public static long getMilli(LocalDateTime time) {
        return time.toInstant(ZoneOffset.of("+8")).toEpochMilli();
    }


    /**
     * get seconds by local datetime
     *
     * @param time
     * @return
     */
    public static long getSecond(LocalDateTime time) {
        return time.toEpochSecond(ZoneOffset.of("+8"));
    }


    /**
     * yyyy-MM-dd
     *
     * @param date
     * @return
     */
    public static String format(Date date) {
        return format(date, DATE_PATTERN);
    }

    /**
     * return by format
     *
     * @param date
     * @param pattern
     * @return
     */
    public static String format(Date date, String pattern) {
        if (date != null) {
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            return df.format(date);
        }
        return null;
    }


    /**
     * string convert date
     *
     * @param strDate
     * @param pattern
     * @return
     */
    public static Date stringToDate(String strDate, String pattern) {
        if (StringUtils.isBlank(strDate)) {
            return null;
        }

        DateTimeFormatter fmt = DateTimeFormat.forPattern(pattern);
        return fmt.parseLocalDateTime(strDate).toDate();
    }

    /**
     * get the begin date and end date from week number
     *
     * @param week week  0= this week，-1= last week，-2= two weeks ago，1= next week，2= week after next
     * @return date[0]= begin date、date[1]= end date
     */
    public static Date[] getWeekStartAndEnd(int week) {
        DateTime dateTime = new DateTime();
        LocalDate date = new LocalDate(dateTime.plusWeeks(week));

        date = date.dayOfWeek().withMinimumValue();
        Date beginDate = date.toDate();
        Date endDate = date.plusDays(6).toDate();
        return new Date[]{beginDate, endDate};
    }

    /**
     * add or minus second
     *
     * @param date    date
     * @param seconds second is number, it can be negative number
     * @return
     */
    public static Date addDateSeconds(Date date, int seconds) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusSeconds(seconds).toDate();
    }

    /**
     * add or minus minute
     *
     * @param date    date
     * @param minutes minute is number, it can be negative number
     * @return
     */
    public static Date addDateMinutes(Date date, int minutes) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusMinutes(minutes).toDate();
    }

    /**
     * add or minus hour
     *
     * @param date  date
     * @param hours hour is number, it can be negative number
     * @return
     */
    public static Date addDateHours(Date date, int hours) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusHours(hours).toDate();
    }

    /**
     * add or minus day
     *
     * @param date date
     * @param days day is number, it can be negative number
     * @return
     */
    public static Date addDateDays(Date date, int days) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusDays(days).toDate();
    }

    /**
     * add or minus week
     *
     * @param date  date
     * @param weeks week is number, it can be negative number
     * @return
     */
    public static Date addDateWeeks(Date date, int weeks) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusWeeks(weeks).toDate();
    }

    /**
     * add or minus month
     *
     * @param date   date
     * @param months month is number, it can be negative number
     * @return
     */
    public static Date addDateMonths(Date date, int months) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusMonths(months).toDate();
    }

    /**
     * add or minus year
     *
     * @param date  date
     * @param years year is number，it can be negative number
     * @return
     */
    public static Date addDateYears(Date date, int years) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusYears(years).toDate();
    }

    /**
     * convert time to RFC3339
     *
     * @param date
     * @return 2021-01-29T17:05:58+08:00
     */
    public static String getRFC3339(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
        String formatDate = simpleDateFormat.format(date);
        return formatDate;
    }

    /**
     * convert time to RFC3339 format
     *
     * @param datetime format：2021-01-29 17:05:58
     * @return
     */
    public static String getRFC3339(String datetime) {
        java.time.format.DateTimeFormatter formatter1 = java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        ZoneId shanghaiZoneId = ZoneId.of("Asia/Shanghai");
        LocalDateTime localDateTime = LocalDateTime.parse(datetime, formatter1);
        ZonedDateTime zonedDateTime = localDateTime.atZone(shanghaiZoneId);
        java.time.format.DateTimeFormatter formatter2 = java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX");
        String formatDate = zonedDateTime.format(formatter2);
        return formatDate;
    }

}
