package com.sample.common;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GoogleGeoAPI {

	private static String timeZoneUrl = "https://maps.googleapis.com/maps/api/timezone/json?location=%f,%f&timestamp=1331161200&key=AIzaSyB58YRN6g26bY6tRU6vJQdwFnvCVHIgORg";
	
	public static void main(String[] args) throws ClientProtocolException, IOException {
		List<Location> locationList = readLocationFromFile("C:/logs/timzone.txt");
		for (Location location : locationList) {
			printOut(getTimeZone(location.getLatitude(), location.getLongitude()));
		}
	}
	
	public static void printOut(String s) {
		System.out.println(s);
	}
	
	public static List<Location> readLocationFromFile(String filePath) {
		List<Location> locationList = new ArrayList<>();
		try {
			FileInputStream inputStream = new FileInputStream(filePath);
			BufferedReader fileReader = new BufferedReader(new InputStreamReader(inputStream));
			
			String location = "";
			while((location = fileReader.readLine()) != null) {
				String[] locationArray = location.trim().split(",");
				locationList.add(new Location(Float.valueOf(locationArray[0]), Float.valueOf(locationArray[1])));
			}
			
			fileReader.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return locationList;
	}
	
	public static String getTimeZone(double lat, double lng) {
		String result = "";
		HttpClient client = HttpClientBuilder.create().build();
		HttpPost post = new HttpPost(String.format(timeZoneUrl, lat, lng));
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
			TimeZone timeZone = gson.fromJson(buffer.toString(), TimeZone.class);
			result = timeZone.getTimeZoneName();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
