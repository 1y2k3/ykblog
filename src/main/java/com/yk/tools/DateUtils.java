package com.yk.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: chaizi
 */
public class DateUtils {

    public static String getCurrent() {
        return getCurrent("yyyy-MM-dd");
    }

    public static String getCurrent(String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date(System.currentTimeMillis()));
    }

    public static String getDateFormat(Date date,String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }
}
