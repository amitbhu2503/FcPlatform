package com.tiia.fcplatform.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by AmitG on 8/4/2018.
 */
public final class Util {
    private static final String DATE_FORMATTER = "dd-MM-yyyy";

    private Util() {
        //not called
    }

    public static String getDateString(Date date){
        DateFormat df = new SimpleDateFormat(DATE_FORMATTER);
        return df.format(date);
    }
}
