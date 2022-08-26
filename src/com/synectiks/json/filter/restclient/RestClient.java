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
			 if(conn != null) {
				conn.disconnect();
			 }
		  }
	}

	public static void testUpdateApi() {
		System.out.println("calling Update API");
		String API_END_POINT = BASE_URL + "/catalogue";
		HttpURLConnection conn = null;
		  try {

			URL url = new URL(API_END_POINT);
			conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("Content-Type", "application/json");

			String input = JsonFilter.loadJson("D:\\mycode\\json-data\\Catalogue\\catalogue.json");
			try(OutputStream os = conn.getOutputStream()) {
				byte[] byteInput = input.getBytes("utf-8");
				os.write(byteInput, 0, byteInput.length);	
				os.flush();		
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}

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

			

		  } catch (MalformedURLException e) {

			e.printStackTrace();

		  } catch (IOException e) {

			e.printStackTrace();

		 }finally {
			 if(conn != null) {
				 conn.disconnect();
			 }
			  
		 }

	}
	
	public static void transformServiceDetails() {
		String API_END_POINT = BASE_URL + "/service-detail/transform";
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
			 if(conn != null) {
				conn.disconnect();
			 }
		  }
	}
	
	public static void searchWithFiltersServiceDetails() {
		String API_END_POINT = BASE_URL + "/service-detail/search-with-filter";
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
			 if(conn != null) {
				conn.disconnect();
			 }
		  }
	}
	
	
	public static void createBulkDataServiceDetail() {
		String API_END_POINT = BASE_URL + "/service-detail/create-bulk-data";
		HttpURLConnection conn = null;
		  try {

			URL url = new URL(API_END_POINT);
			conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("Content-Type", "application/json");
			
			String input = JsonFilter.loadJson("C:\\mycode\\json-data\\services.json");
			try(OutputStream os = conn.getOutputStream()) {
				byte[] byteInput = input.getBytes("utf-8");
				os.write(byteInput, 0, byteInput.length);	
				os.flush();		
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}

//			if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED && conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
//				throw new RuntimeException("Failed : HTTP error code : "
//					+ conn.getResponseCode());
//			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}
		  } catch (MalformedURLException e) {
			e.printStackTrace();
		  } catch (IOException e) {
			e.printStackTrace();
		 }finally {
			 if(conn != null) {
				 conn.disconnect();
			 }
		 }

	}
	
	public static void addServiceDetail() {
		String API_END_POINT = BASE_URL + "/service-detail";
		HttpURLConnection conn = null;
		  try {

			URL url = new URL(API_END_POINT);
			conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("Content-Type", "application/json");
			
			String input = JsonFilter.loadJson("C:\\mycode\\json-data\\single-service.json");
			try(OutputStream os = conn.getOutputStream()) {
				byte[] byteInput = input.getBytes("utf-8");
				os.write(byteInput, 0, byteInput.length);	
				os.flush();		
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}

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
		  } catch (MalformedURLException e) {
			e.printStackTrace();
		  } catch (IOException e) {
			e.printStackTrace();
		 }finally {
			 if(conn != null) {
				 conn.disconnect();
			 }
		 }

	}
	
	public static void updateSlaJson() {
		String API_END_POINT = BASE_URL + "/service-detail/sla-json";
		HttpURLConnection conn = null;
		  try {

			URL url = new URL(API_END_POINT);
			conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("Content-Type", "application/json");
			
			String input = JsonFilter.loadJson("C:\\mycode\\json-data\\sla-json.json");
			try(OutputStream os = conn.getOutputStream()) {
				byte[] byteInput = input.getBytes("utf-8");
				os.write(byteInput, 0, byteInput.length);	
				os.flush();		
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}

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
		  } catch (MalformedURLException e) {
			e.printStackTrace();
		  } catch (IOException e) {
			e.printStackTrace();
		 }finally {
			 if(conn != null) {
				 conn.disconnect();
			 }
		 }

	}
	
	public static void getServiceDetailApi() {
		String API_END_POINT = BASE_URL + "/service-detail";
		HttpURLConnection conn = null;
	  	try {
			  	URL url = new URL(API_END_POINT);
				conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept", "application/json");
					
				if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED && conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
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
			 if(conn != null) {
				conn.disconnect();
			 }
		  }
	}	
	
	
	public static void updateServiceDetailsInLoop() {
		String API_END_POINT = BASE_URL + "/service-detail/test-sla-json";
		HttpURLConnection conn = null;
	  	while(true) {
	  		long beginTime = System.currentTimeMillis();
	  		try {
			  	URL url = new URL(API_END_POINT);
				conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept", "application/json");
					
				if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED && conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
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
			 if(conn != null) {
				conn.disconnect();
			 }
		  }
	  		long endTime = System.currentTimeMillis();
	  		long difference = endTime - beginTime;
	  		System.out.println("Time taken in minutes : "+(difference) / 1000 / 60);
	  		try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  	}
		
	}
	
	public static void main(String a[]) {
		//testGetApi();
//		testUpdateApi();
//		addServiceDetail();
//		updateSlaJson();
		updateServiceDetailsInLoop();
	}
}