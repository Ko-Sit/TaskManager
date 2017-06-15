package com.qulix.sitkinke.trainingtask.main;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * Created by upsit on 14.06.2017.
 */
public class TestDate {
    public static void main(String[] args) throws ParseException {
        String string = "2017-06-07";
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = df.parse(string);
        System.out.println(date);
    }
}
