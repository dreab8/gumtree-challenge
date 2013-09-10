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
    public void should_format_the_date_in_the_UK_locale_format_dd_MMMM_YYYY() {
        String date = "2012-11-21 10:12:10 BST";
        DateProcessor dp = new DateProcessor();

        String result = dp.format( date, Locale.UK );

        assertThat( result, is( "21 November 2012" ) );
    }
}