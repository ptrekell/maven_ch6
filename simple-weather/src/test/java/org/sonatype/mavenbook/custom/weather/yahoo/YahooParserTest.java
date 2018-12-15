package org.sonatype.mavenbook.custom.weather.yahoo;

import java.io.InputStream;

import junit.framework.TestCase;
import org.junit.Test;
import org.sonatype.mavenbook.custom.weather.Weather;
import org.sonatype.mavenbook.custom.weather.YahooParser;

import static org.junit.Assert.assertEquals;


public class YahooParserTest  {



	@Test
	public void testParser() throws Exception {
		InputStream nyData = 
			getClass().getClassLoader().getResourceAsStream("ny-weather.xml");
		Weather weather = new YahooParser().parse( nyData );
		assertEquals( "New York", weather.getCity() );
		assertEquals( "NY", weather.getRegion() );
		assertEquals( "US", weather.getCountry() );
		assertEquals( "39", weather.getTemp() );
		assertEquals( "Fair", weather.getCondition() );
		assertEquals( "39", weather.getChill() );
		assertEquals( "67", weather.getHumidity() );
	}
}
