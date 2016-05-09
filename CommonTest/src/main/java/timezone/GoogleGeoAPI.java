package timezone;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

import org.apache.http.client.ClientProtocolException;

public class GoogleGeoAPI {

	public static void main(String[] args) throws ClientProtocolException, IOException, ParseException {
		GoogleGeoAPI geoObject = new GoogleGeoAPI();
		geoObject.init();
		geoObject.run();
	}
	
	private Scanner scanner;
	private String filePath;
	private TimeZoneUtil timeZoneUtil;
	
	public void init() {
		scanner = new Scanner(System.in);
		filePath = "";
		timeZoneUtil = new TimeZoneUtil(new LocationInjector());
	}
	
	public void run() throws ParseException {
		System.out.println("*** Read timezone ***\n Type \"exit\" or \"quit\" to escape");
		while (true) {
			printOut("Enter CSV file path: ");
			filePath = scanner.nextLine();
			if(filePath.equals("exit") || filePath.equals("quit")) {
				scanner.close();
				return;
			}
			displayOutput();
			printOut("=================================");
		}
	}
	
	private void displayOutput() {
		try {
			if (timeZoneUtil.isValidExtension(filePath)) {
				List<Location> locationList = timeZoneUtil.readLocationFromFile(filePath);
				if (locationList != null) {
					for (Location location : locationList) {
						TimeZone timeZone = timeZoneUtil.getTimeZone(location);
						if (timeZone != null) {
							location.setArea(timeZone.getTimeZoneId());
							location.setLocalTime(new Timestamp(location.getDate().getTime() + timeZone.getRawOffset() * 1000));
							printOut(location.toString());
						}
					}
				}
			} else {
				printOut("Not valid file extension. Please input CSV file only");
			}
		} catch (FileNotFoundException e) {
			printOut("File not found");
		} catch (IOException e) {
			printOut("An IOException happened");
		} catch (InjectionException e) {
			printOut(e.getMessage());
		}
	}

	private void printOut(String s) {
		System.out.println(s);
	}
}
