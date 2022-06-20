package com.synectiks.json.filter.restclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.synectiks.json.filter.JsonFilter;

public class RestClient {

	public static String IP = "localhost";
	public static String PORT = "5057";
	public static String BASE_URL = "http://"+IP+":"+PORT+"/api";
	
	public static void testGetApi() {
		String API_END_POINT = BASE_URL + "/catalogue";
		HttpURLConnection conn = null;
	  	try {
			  	URL url = new URL(API_END_POINT);
				conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept", "application/json");
					
				if (conn.getResponseCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : "
							+ conn.getResponseCode());
				}
				BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			
				String output;
				System.out.println("Output from Server .... \n");
				while ((output = br.readLine()) != null) {
					System.out.println(output);
				}
		  }catch (MalformedURLException e) {
			  e.printStackTrace();
		  }catch (IOException e) {
			  e.printStackTrace();
		  }finally {
			  conn.disconnect();
		  }
	}

	public static void testUpdateApi() {
		String API_END_POINT = BASE_URL + "/catalogue";
		  try {

			URL url = new URL(API_END_POINT);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("PUT");
			conn.setRequestProperty("Content-Type", "application/json");

			String input = JsonFilter.loadJson("D:\\mycode\\json-data\\Catalogue\\catalogue.json");

			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();

			if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED && conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
				throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}

			conn.disconnect();

		  } catch (MalformedURLException e) {

			e.printStackTrace();

		  } catch (IOException e) {

			e.printStackTrace();

		 }

		}
	
	public static void main(String a[]) {
		testUpdateApi();
	}
}