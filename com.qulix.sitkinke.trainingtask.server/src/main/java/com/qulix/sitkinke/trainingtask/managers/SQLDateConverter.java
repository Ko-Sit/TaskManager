package com.qulix.sitkinke.trainingtask.managers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * Created by upsit on 14.06.2017.
 */
public class SQLDateConverter {
    public static Date getDate(String string){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = df.parse(string);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
