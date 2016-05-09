package timezone;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;

public class LocationInjector {
	public Location inject(String... data) throws InjectionException  {
		Timestamp date = convertTimeStamp(data[0]);
		Double longitude = convertDouble(data[1]);
		Double latitude = convertDouble(data[2]);
		return new Location(date, longitude, latitude);
	}
	
	private Timestamp convertTimeStamp(String rawData) throws InjectionException {
		Date date;
		try {
			date = DateTimeCommon.simpleFormat.parse(rawData);
			Timestamp ts = new Timestamp(date.getTime());
			return ts;
		} catch (ParseException e) {
			throw new InjectionException("Parsing data failed " + rawData);
		}
		
	}
	
	private Double convertDouble(String rawData) throws InjectionException {
		try {
			return Double.parseDouble(rawData);
		} catch (Exception e) {
			throw new InjectionException("Parsing data failed " + rawData);
		}
	}
}
