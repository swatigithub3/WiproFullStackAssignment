package com.day25;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTTPClient {

	public static void main(String[] args) {
		try {
			URL url = new URL("http://example.com");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			int responseCode = connection.getResponseCode();
			System.out.println("Response Code: " + responseCode);
			System.out.println("Response Headers: ");
			connection.getHeaderFields().forEach((key, value) -> {
				if(key != null) {
					System.out.println(key + ": " + value);
				}
			});
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuilder responseBody = new StringBuilder();
			String line;
			while((line = reader.readLine()) != null) {
				responseBody.append(line);
			}
			reader.close();
			System.out.println("\nResponse Body: ");
			System.out.println(responseBody.toString());
			connection.disconnect();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
