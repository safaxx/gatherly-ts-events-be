package com.techsisters.gatherly.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.TimeZone;

public class DateUtil {
    private static final String DATE_FORMAT = "yyyy-MM-dd";
    private static final String DB_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static Date convertStringToDate(String dateStr){
        Date ds = null;
        DateFormat format = new SimpleDateFormat(DB_DATE_FORMAT);
        try{
            ds = format.parse(dateStr);
        }catch(ParseException e){
            return ds;
        }
        return ds;
    }
    public static Date getFormattedCurrentDate(String timezone){
        DateFormat formatter = new SimpleDateFormat(DB_DATE_FORMAT);
        formatter.setTimeZone(TimeZone.getTimeZone(timezone)); //"America/Los_Angeles"
        return convertStringToDate(formatter.format(new Date()));
    }
}
