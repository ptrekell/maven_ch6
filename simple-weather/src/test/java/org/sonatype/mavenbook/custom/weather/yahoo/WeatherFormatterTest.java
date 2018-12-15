package org.sonatype.mavenbook.custom.weather.yahoo;

import java.io.InputStream;

import org.apache.commons.io.IOUtils;


import junit.framework.TestCase;
import org.junit.Test;
import org.sonatype.mavenbook.custom.weather.Weather;
import org.sonatype.mavenbook.custom.weather.WeatherFormatter;
import org.sonatype.mavenbook.custom.weather.YahooParser;

import static org.junit.Assert.assertEquals;


public class WeatherFormatterTest {


    @Test
    public void testFormat() throws Exception {
        InputStream nyData =
                getClass().getClassLoader().getResourceAsStream("ny-weather.xml");
        Weather weather = new YahooParser().parse(nyData);
        String formattedResult = new WeatherFormatter().format(weather);
        InputStream expected =
                getClass().getClassLoader().getResourceAsStream("format-expected.dat");
        assertEquals(IOUtils.toString(expected), formattedResult);
    }
}
