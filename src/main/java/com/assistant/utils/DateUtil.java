package com.assistant.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author hefan.hf
 * @version $Id: DateUtil, v 0.1 16/4/16 20:13 hefan.hf Exp $
 */
public class DateUtil {

    private static SimpleDateFormat sdf  = new SimpleDateFormat("dd/MM E");

    private static SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 将GMT时间转换为GMT+8
     * @param date
     * @return
     */
    public static Date convertFromGMTToPRC(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        //        calendar.add(Calendar.HOUR, 12);
        return calendar.getTime();
    }

    public static int diffMin(Date d1, Date d2) {
        long diff = d2.getTime() - d1.getTime();
        long mins = diff / 1000 / 60;
        return (int) mins;
    }

    public static String diff(Date d1, Date d2) {
        long diff = d2.getTime() - d1.getTime();
        long days = diff / (1000 * 60 * 60 * 24);

        long seconds = diff / 1000;
        if (seconds < 60) {
            return seconds + "秒";
        }
        seconds = seconds % 60;
        long minutes = diff / 1000 / 60;
        if (minutes < 60) {
            return minutes + "分" + seconds + "秒";
        }
        minutes = minutes % 60;
        long hour = diff / 1000 / 60 / 60;
        return hour + "时" + minutes + "分";
    }

    public static String convertToDoString(Date date) {
        Date now = convertFromGMTToPRC(new Date());
        long diff = date.getTime() - now.getTime();
        if (diff > 0) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            int dtDay = calendar.get(Calendar.DAY_OF_YEAR);
            calendar.setTime(now);
            int nowDay = calendar.get(Calendar.DAY_OF_YEAR);
            if (dtDay - nowDay == 0) {
                return "今天";
            } else if (dtDay - nowDay == 1) {
                return "明天";
            } else if (dtDay - nowDay == 2) {
                return "后天";
            }
        }

        return sdf.format(date);
    }

    public static Date convertFromTodoString(String date) throws ParseException {
        return sdf2.parse(date);
    }

    /**
     * 将Plan类型的添加时的时间字符串,只保留日期,转换成时间格式
     * @param date
     * @return
     * @throws ParseException
     */
    public static Date convertFromPlanDtStart(Date date) throws ParseException {
        String dateString = sdf2.format(date);
        String newDate = dateString.substring(0, 11) + "00:00:00";
        return sdf2.parse(newDate);
    }

    /**
     * 将Plan类型的添加时的时间字符串,只保留日期,转换成时间格式
     * @param date
     * @return
     * @throws ParseException
     */
    public static Date convertFromPlanDtEnd(Date date) throws ParseException {
        String dateString = sdf2.format(date);
        String newDate = dateString.substring(0, 11) + "23:59:59";
        return sdf2.parse(newDate);
    }

    public static String convertToPlanDtString(Date date) {
        return sdf.format(date);
    }

}