package com.assistant.utils;

import java.text.NumberFormat;

/**
 * @author hefan.hf
 * @version $Id: NumberUtil, v 0.1 16/5/9 12:41 hefan.hf Exp $
 */
public class NumberUtil {

    public static String getPercent(int i1, int i2) {
        NumberFormat numberFormat = NumberFormat.getInstance();
        // 设置精确到小数点后2位
        numberFormat.setMaximumFractionDigits(2);
        String result = numberFormat.format((float) i1 / (float) i2 * 100) + " %";
        return result;
    }

    public static String preserveOneDigit(int i) {
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(1);
        String result = numberFormat.format((float) i / 60);
        return result;
    }
}