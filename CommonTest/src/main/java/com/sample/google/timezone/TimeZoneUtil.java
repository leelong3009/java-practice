package com.sample.google.timezone;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import au.com.bytecode.opencsv.CSVReader;

public class TimeZoneUtil {
	
	private final String timeZoneUrl = "https://maps.googleapis.com/maps/api/timezone/json?location=%f,%f&timestamp=%s&key=AIzaSyB58YRN6g26bY6tRU6vJQdwFnvCVHIgORg";
	LocationInjector injector;
	
	public TimeZoneUtil(LocationInjector injector) {
		this.injector = injector;
	}
	
	public boolean isValidExtension(String filePath) {
		if (filePath.isEmpty() || filePath == null) return false;
		String extension = filePath.substring(filePath.lastIndexOf('.') + 1, filePath.length()).toLowerCase();
		if ("csv".equals(extension)) {
			return true;
		}
		return false;
	}
	
	public List<Location> readLocationFromFile(String fileName) throws FileNotFoundException, IOException, InjectionException {
		List<Location> locationList = new ArrayList<>();

		Reader inputStreamReader = new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream(fileName));
		CSVReader csvReader = new CSVReader(inputStreamReader, ',', '"');
		String[] line = csvReader.readNext();
		
		while (line != null) {
			if (line.length == 3) {
				locationList.add(injector.inject(line));
			}
			line = csvReader.readNext();
		}
		csvReader.close();
		return locationList;
	}
	
	public TimeZone getTimeZone(Location location) {
		TimeZone timeZone = null;
		HttpClient client = HttpClientBuilder.create().build();
		long diffSeconds = diffTimeStamp(location.getDate(), DateTimeCommon.utcRoot);
		HttpPost post = new HttpPost(String.format(timeZoneUrl, location.getLatitude(), location.getLongitude(), diffSeconds));
		HttpResponse response;
		try {
			response = client.execute(post);
			BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			
			StringBuffer buffer = new StringBuffer();
			String line = "";
			while((line = reader.readLine()) != null) {
				buffer.append(line);
			}
			reader.close();
			
			// convert String to JSON object
			Gson gson = new GsonBuilder().create();
			timeZone = gson.fromJson(buffer.toString(), TimeZone.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return timeZone;
	}
	
	private long diffTimeStamp(Timestamp ts1, Timestamp ts2) {
		return (ts1.getTime() - ts2.getTime()) / 1000;
	}
	
}
