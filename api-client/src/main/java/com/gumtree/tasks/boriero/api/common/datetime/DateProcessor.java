package com.gumtree.tasks.boriero.api.common.datetime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateProcessor {

    private static final String SERVER_SIDE_DATE_PATTERN = "yyyy-MM-dd hh:mm:ss Z";
    private static final String READABLE_PATTERN = "dd MMMM yyyy";

    public String format(String date) {
        return format( date, Locale.getDefault() );
    }

    public String format(String date, Locale locale) {
        if (date == null) {
            return "";
        }
        try {
            DateFormat df = new SimpleDateFormat( SERVER_SIDE_DATE_PATTERN );
            Date dateToConvert = df.parse( date );
            DateFormat rf = new SimpleDateFormat( READABLE_PATTERN, locale );
            return rf.format( dateToConvert );
        } catch (Exception e) {
            return "";
        }
    }
}
