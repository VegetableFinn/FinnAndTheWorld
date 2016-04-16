package com.assistant.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * @author hefan.hf
 * @version $Id: DateUtil, v 0.1 16/4/16 20:13 hefan.hf Exp $
 */
public class DateUtil {

    /**
     * 将GMT时间转换为GMT+8
     * @param date
     * @return
     */
    public static Date convertFromGMTToPRC(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR, 12);
        return calendar.getTime();
    }
}