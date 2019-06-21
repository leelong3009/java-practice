package com.sample.google.timezone;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class TimeZoneTest {
	private TimeZoneUtil timeZoneUtil;
	private LocationInjector injector;
	
	@Before
	public void setUp() throws InjectionException {
		injector = mock(LocationInjector.class);
		when(injector.inject(any())).thenReturn(new Location());
		timeZoneUtil = new TimeZoneUtil(injector);
	}
	
	@Test
	@Ignore
	public void testNotNullTimeZone() throws ParseException {
		Timestamp ts = new Timestamp(DateTimeCommon.simpleFormat.parse("2013-07-10 02:52:49").getTime());
		Location location = new Location(ts, 39.6034810, -119.6822510);
		assertNotNull(timeZoneUtil.getTimeZone(location));
	}
	
	@Test(expected = FileNotFoundException.class)
	public void testNotExistFileReading() throws FileNotFoundException, IOException, InjectionException {
		timeZoneUtil.readLocationFromFile("notExistingFile");
	}
	
	@Test
	public void testReadExistingFile() throws FileNotFoundException, IOException, InjectionException {
		injector = mock(LocationInjector.class);
		timeZoneUtil = new TimeZoneUtil(injector);
		assertTrue(timeZoneUtil.readLocationFromFile("c:/logs/locations.csv").size() > 0);
	}
	
	@Test(expected = InjectionException.class)
	public void testFailInjector() throws InjectionException {
		LocationInjector injector = new LocationInjector();
		injector.inject(new String[]{"","",""});
	}
	
	@Test
	public void testValidInjector() throws InjectionException {
		LocationInjector injector = new LocationInjector();
		assertNotNull(injector.inject(new String[]{"2013-07-10 02:52:49","-44.490947","171.220966"}));
	}
	
	@Test
	public void testValidExtension() {
		assertTrue(timeZoneUtil.isValidExtension("file.csv"));
	}
	
	@Test
	public void testNotValidExtension() {
		assertFalse(timeZoneUtil.isValidExtension("file.txt"));
	}
}
