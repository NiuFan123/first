package com.util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class MyTimeUtil {

    public static Date dateChange(java.util.Date date){
        return new Date(date.getTime());
    }

    public static Date dateChange(String date){
        java.util.Date date1 = null;
        try {
            date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Date(date1.getTime());
    }
}
