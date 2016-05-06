package timezone;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;

public class GoogleGeoAPI {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		displayTimeZoneFromFile("C:/logs/timzone.txt");
	}
	
	private static void displayTimeZoneFromFile(String filePath) {
		TimeZoneUtil timeZoneUtil = new TimeZoneUtil();
		List<Location> locationList = timeZoneUtil.readLocationFromFile(filePath);
		for (Location location : locationList) {
			printOut(timeZoneUtil.getTimeZone(location));
		}
	}

	private static void printOut(String s) {
		System.out.println(s);
	}
}
