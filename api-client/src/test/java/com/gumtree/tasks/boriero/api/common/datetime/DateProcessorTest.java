package com.gumtree.tasks.boriero.api.common.datetime;

import org.junit.Test;

import java.util.Locale;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Andrea Boriero <dreborier@gmail.com>
 */
public class DateProcessorTest {

    @Test
    public void shouldFormatDateInUKLocaleddMMMM() {
        String date = "2012-11-21 10:12:10 BST";
        DateProcessor dp = new DateProcessor();

        String result = dp.format( date, Locale.UK );

        assertThat( result, is( "21 November" ) );
    }
}
