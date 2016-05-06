package timezone;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TimeZoneTest {
	private TimeZoneUtil timeZoneUtil;
	private Location location;
	
	@Before
	public void setUp() {
		timeZoneUtil = new TimeZoneUtil();
		location = new Location(39.6034810, -119.6822510);
	}
	
	@Test
	public void testReadTimeZone() {
		assertEquals(timeZoneUtil.getTimeZone(location), "Pacific Standard Time");
	}
	
	@Test
	public void testReadFile() {
		assertTrue(timeZoneUtil.readLocationFromFile("C:/logs/timzone.txt").size() > 0);
	}
}
