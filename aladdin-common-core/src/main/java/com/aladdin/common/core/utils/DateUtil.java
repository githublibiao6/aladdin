package com.aladdin.common.core.utils;

import com.aladdin.common.core.constant.CommonConstant;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

/**
 * 日期工具类
 *
 * @author cles
 * @date 2026/04/30
 */
public class DateUtil {

    public static final String DATE_TIME_PATTERN = CommonConstant.DATE_TIME_PATTERN;
    public static final String DATE_PATTERN = CommonConstant.DATE_PATTERN;
    public static final String TIME_PATTERN = CommonConstant.TIME_PATTERN;
    public static final String DATE_PATTERN_NO_SYMBOL = "yyyyMMdd";

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DATE_TIME_PATTERN);
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_PATTERN);
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern(TIME_PATTERN);
    private static final DateTimeFormatter DATE_NO_SYMBOL_FORMATTER = DateTimeFormatter.ofPattern(DATE_PATTERN_NO_SYMBOL);

    private DateUtil() {
    }

    public static String formatDateTime(LocalDateTime dateTime) {
        return dateTime == null ? null : DATE_TIME_FORMATTER.format(dateTime);
    }

    public static String formatDate(LocalDate date) {
        return date == null ? null : DATE_FORMATTER.format(date);
    }

    public static String formatDate(LocalDateTime dateTime) {
        return dateTime == null ? null : DATE_FORMATTER.format(dateTime.toLocalDate());
    }

    public static String formatTime(LocalDateTime dateTime) {
        return dateTime == null ? null : TIME_FORMATTER.format(dateTime.toLocalTime());
    }

    public static LocalDateTime parseDateTime(String dateTimeStr) {
        return isEmpty(dateTimeStr) ? null : LocalDateTime.parse(dateTimeStr, DATE_TIME_FORMATTER);
    }

    public static LocalDate parseDate(String dateStr) {
        return isEmpty(dateStr) ? null : LocalDate.parse(dateStr, DATE_FORMATTER);
    }

    public static LocalDateTime now() {
        return LocalDateTime.now();
    }

    public static LocalDate today() {
        return LocalDate.now();
    }

    public static String getDateTime() {
        return DATE_NO_SYMBOL_FORMATTER.format(LocalDateTime.now());
    }

    public static LocalDateTime getFirstDayOfMonth() {
        return LocalDateTime.now()
                .with(TemporalAdjusters.firstDayOfMonth())
                .with(LocalTime.MIN);
    }

    public static LocalDateTime getLastDayOfMonth() {
        return LocalDateTime.now()
                .with(TemporalAdjusters.lastDayOfMonth())
                .with(LocalTime.MAX);
    }

    public static int getDayNumToLastDayMonth() {
        LocalDate now = LocalDate.now();
        LocalDate lastDay = getLastDayOfMonth().toLocalDate();
        Period period = Period.between(now, lastDay);
        return period.getDays();
    }

    public static int getDayNumToLastDayYear() {
        LocalDate now = LocalDate.now();
        LocalDate lastDay = LocalDateTime.now()
                .with(TemporalAdjusters.lastDayOfYear())
                .with(LocalTime.MAX)
                .toLocalDate();
        Period period = Period.between(now, lastDay);
        return period.getDays();
    }

    public static Long timeDifferenceSeconds(LocalDateTime startTime, LocalDateTime endTime) {
        if (startTime != null && endTime != null) {
            return Duration.between(startTime, endTime).getSeconds();
        }
        return null;
    }

    public static Long getAge(LocalDate birthDate) {
        if (birthDate != null) {
            return ChronoUnit.YEARS.between(birthDate, LocalDate.now());
        }
        return null;
    }

    public static java.sql.Date strToSqlDate(String strDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_TIME_PATTERN);
        LocalDate date = LocalDate.from(formatter.parse(strDate));
        return java.sql.Date.valueOf(date);
    }

    public static java.sql.Date strToSqlDateDate(String strDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_PATTERN);
        LocalDate date = LocalDate.from(formatter.parse(strDate));
        return java.sql.Date.valueOf(date);
    }

    public static Time strToSqlTime(String strTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(TIME_PATTERN);
        LocalTime time = LocalTime.from(formatter.parse(strTime));
        return Time.valueOf(time);
    }

    public static String dateStampToString() {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        Timestamp now = new Timestamp(System.currentTimeMillis());
        return df.format(now);
    }

    public static String timeStampToString(Timestamp timestamp, String format) {
        SimpleDateFormat df = new SimpleDateFormat(format);
        return df.format(timestamp == null ? Timestamp.valueOf(LocalDateTime.now()) : timestamp);
    }

    public static String sqlDateToString(java.sql.Date date, String format) {
        SimpleDateFormat df = new SimpleDateFormat(format);
        return df.format(date == null ? Timestamp.valueOf(LocalDateTime.now()) : date);
    }

    private static boolean isEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }
}
