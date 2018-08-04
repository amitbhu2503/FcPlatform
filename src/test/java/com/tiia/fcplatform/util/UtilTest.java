package com.tiia.fcplatform.util;

import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class UtilTest {

    @Test
    public void getDateString() {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String dateStr = df.format(date);
        assertEquals(dateStr, Util.getDateString(date));
    }
}