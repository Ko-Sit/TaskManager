package com.qulix.sitkinke.trainingtask.managers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Manager class that converts date format.
 *
 * @author sitkin
 */
public class SQLDateConverter {

    /**
     * Gets employee list.
     *
     * @param string the string date
     * @return the new string date
     */
    public static Date getDate(String string) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = df.parse(string);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
