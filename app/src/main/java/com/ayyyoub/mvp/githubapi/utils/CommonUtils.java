package com.ayyyoub.mvp.githubapi.utils;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public final class CommonUtils {

    public static String getLastThirtyDayDate(String template) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, -30);
        Date yesterday = calendar.getTime();
        return new SimpleDateFormat(template,Locale.FRANCE).format(yesterday);
    }

    public static String integerFormat(int value) {
        if (value < 1000) return value+"";
        if (value < 1000000) return new DecimalFormat("#.#").format(value/1000.0f)+"k";
        return new DecimalFormat("#.#").format(value/1000000.0f)+"m";
    }

}
