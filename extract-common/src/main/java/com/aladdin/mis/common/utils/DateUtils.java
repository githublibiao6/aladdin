package com.aladdin.mis.common.utils;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

/**
 * 日期工具类
 *
 * @author zhaoy
 */
public class DateUtils {

    public static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_PATTERN = "yyyy-MM-dd";
    public static final String TIME_PATTERN = "HH:mm:ss";
    public static final String DATE_PATTERN_NO_SYLBOM = "yyyyMMdd";

    /**
     * 格式化日期时间
     *
     * @param dateTime 日期时间
     * @return 格式化结果
     */
    public static String formatDateTime(LocalDateTime dateTime) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern(DATE_TIME_PATTERN);
        return df.format(dateTime);
    }

    /**
     * 格式化日期
     *
     * @param dateTime 日期时间
     * @return 格式化结果
     */
    public static String formatDate(LocalDateTime dateTime) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern(DATE_PATTERN);
        return df.format(dateTime);
    }

    /**
     * 格式化日期
     *
     * @param date 日期时间
     * @return 格式化结果
     */
    public static String formatDateStr(LocalDate date) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern(DATE_PATTERN);
        return df.format(date);
    }
    /**
     * 解析日期
     *
     * @param dateStr 日期字符串
     * @return 解析结果
     */
    public static LocalDate parseDate(String dateStr) {
        if(StringUtils.isEmpty(dateStr)) {
            return null;
        }
        return LocalDate.parse(dateStr, DateTimeFormatter.ofPattern(DateUtils.DATE_PATTERN));
    }
    /**
     * 解析日期
     *
     * @param dateStr 日期字符串
     * @return 解析结果
     */
    public static LocalDateTime parseDateTime(String dateStr) {
        if(StringUtils.isEmpty(dateStr)) {
            return null;
        }
        return LocalDateTime.parse(dateStr, DateTimeFormatter.ofPattern(DateUtils.DATE_TIME_PATTERN));
    }
    /**
     * 获取系统时间的当月的第一天
     *
     * @return 第一天
     */
    public static LocalDateTime getFirstDayOfMonth() {

        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime firstOfDay = localDateTime.with(TemporalAdjusters.firstDayOfMonth()).with(LocalTime.MIN);

        return firstOfDay;
    }

    /**
     * 获取系统时间的当月的最后以天
     *
     * @return 最后一天
     */
    public static LocalDateTime getLastDayOfMonth() {

        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime endOfDay = localDateTime.with(TemporalAdjusters.lastDayOfMonth()).with(LocalTime.MAX);
        return endOfDay;
    }

    public static String getDateTime(){
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter df = DateTimeFormatter.ofPattern(DATE_PATTERN_NO_SYLBOM);
        return df.format(localDateTime);
    }

    /**
     * 获取跟月底的时间差 天数
     * @return
     */
    public static Integer getDayNumToLastDayMonth() {
        LocalDate now = LocalDate.now();
        LocalDateTime localDateTime = getLastDayOfMonth();
        LocalDate lastDay = localDateTime.toLocalDate();
        Period next = Period.between(now, lastDay);
        return next.getDays();
    }
    /**
     * 获取跟年底的时间差 天数
     * @return
     */
    public static Integer getDayNumToLastDayYear() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime endOfDay = now.with(TemporalAdjusters.lastDayOfYear()).with(LocalTime.MAX);
        LocalDate nowDay = LocalDate.now();
        LocalDate endDay = endOfDay.toLocalDate();
        Period next = Period.between(nowDay, endDay);
        return next.getDays();
    }

    /**
     * 计算时间差 秒
     * @param startTime
     * @param endTime
     * @return
     */
    public static Long timeDifferenceSeconds(LocalDateTime startTime, LocalDateTime endTime) {
        if (startTime != null && endTime != null) {
            Duration duration = Duration.between(startTime, endTime);
            return duration.getSeconds();
        }
        return null;
    }

    public static Long getAge(LocalDate localDate) {
        if (localDate != null) {
            LocalDate today = LocalDate.now();

            long duration = ChronoUnit.YEARS.between(localDate, today);
            return duration;
        } else {
            return null;
        }
    }

    /**
     * 时间字符串转为java.sql.Date
     * @param strDate date字符串 yyyy-MM-dd HH:mm:ss
     * @return java.sql.Date
     */
    public static Date strToSqlDate(String strDate) {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        TemporalAccessor dateTemp = dateTimeFormatter.parse(strDate);
        LocalDate date = LocalDate.from(dateTemp);

        Date sqlDate = Date.valueOf(date);
        return sqlDate;
    }

    /**
     * 时间字符串转为java.sql.Date
     * @param strDate date字符串 yyyy-MM-dd
     * @return java.sql.Date
     */
    public static Date strToSqlDateDate(String strDate) {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        TemporalAccessor dateTemp = dateTimeFormatter.parse(strDate);
        LocalDate date = LocalDate.from(dateTemp);

        Date sqlDate = Date.valueOf(date);
        return sqlDate;
    }

    /**
     * 时间字符串转为java.sql.Time
     * @param strTime time字符串 HH:mm:ss
     * @return java.sql.Time
     */
    public static Time strToSqlTime(String strTime){

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        TemporalAccessor timeTemp = dateTimeFormatter.parse(strTime);
        LocalTime time = LocalTime.from(timeTemp);

        Time sqlTime = Time.valueOf(time);
        return sqlTime;
    }

    /**
     * timeStamp转换为String
     * @return
     */
    public static String dateStampToString(){
        //定义格式，不显示毫秒
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        //获取系统当前时间
        Timestamp now = new Timestamp(System.currentTimeMillis());
        String str = df.format(now);
        return str;
    }

    /**
     * timeStamp转换为String
     * @return string
     */
    public static String timeStampToString(Timestamp timestamp ,String format){
        //定义格式，不显示毫秒
        SimpleDateFormat df = new SimpleDateFormat(format);
        return df.format(timestamp==null?Timestamp.valueOf(LocalDateTime.now()):timestamp);
    }

    /**
     * timeStamp转换为String
     * @return string
     */
    public static String sqlDateToString(Date date,String format){
        //定义格式，不显示毫秒
        SimpleDateFormat df = new SimpleDateFormat(format);
        return df.format(date==null?Timestamp.valueOf(LocalDateTime.now()):date);
    }
}
