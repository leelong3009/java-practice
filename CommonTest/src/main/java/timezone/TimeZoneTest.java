package timezone;

import org.junit.Test;

import junit.framework.TestCase;

public class TimeZoneTest extends TestCase {
	
	@Test
	public void test() {
		assertEquals(GoogleGeoAPI.getTimeZone(39.6034810, -119.6822510), "Pacific Standard Time");
	}
}
