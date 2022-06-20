package com.synectiks.json.filter;

import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.synectiks.json.filter.db.DbOperation;

public class JsonFilter {

	static String filePath = "D:\\mycode\\json-data\\Catalogue\\catalogue.json";
	
	public static String loadJson(String filePath) {
		return JsonFileLoader.load(filePath);
	}
	
	public static JSONObject parseJson(String jsonText) {
		JSONParser parser = new JSONParser();
		try {
			return (JSONObject)parser.parse(jsonText);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void filterCloudDashboards(JSONObject jsonObj, String key, String value) {
		JSONObject opsObj = (JSONObject)jsonObj.get("ops");
		JSONArray jsonArray = (JSONArray) opsObj.get("cloudDashBoards");
		Object filteredList  = jsonArray.stream()
				.filter(x -> {
                    if (((JSONObject) x).get(key).equals(value)) {
                        return true;
                    }
                    return false;
                })
	            .collect(Collectors.toList());
		System.out.println(filteredList); 
	}
	
	public static void testFilter() {
		String jsonText = loadJson(filePath);
		if(StringUtils.isBlank(jsonText)) {
			System.out.println("Json file could not be loaded successfully. Exit code: 1. Exiting");
			System.exit(1);
		}
		JSONObject jsonObjct = parseJson(jsonText);
		filterCloudDashboards(jsonObjct, "associatedDataSourceType", "AWS-PullLog-Api");
	}
	
	public static void mergeJsonInCloudDashboards(JSONObject jsonObj, String newJsonText) {
		JSONObject opsObj = (JSONObject)jsonObj.get("ops");
		JSONArray jsonArray = (JSONArray) opsObj.get("cloudDashBoards");
		JSONObject obj = JsonFilter.parseJson(newJsonText);
		jsonArray.add(obj);
		opsObj.put("cloudDashBoards", jsonArray);
		jsonObj.put("ops", opsObj);
		System.out.println(jsonObj); 
	}
	
	public static void testMergeAndUpdateJson() {
		String newJson = "{\"test\":\"app\"}";
		String jsonText = loadJson(filePath);
		if(StringUtils.isBlank(jsonText)) {
			System.out.println("Json file could not be loaded successfully. Exit code: 1. Exiting");
			System.exit(1);
		}
		JSONObject jsonObjct = parseJson(jsonText);
		mergeJsonInCloudDashboards(jsonObjct,newJson);
		DbOperation.getData();
		DbOperation.updateData(jsonObjct.toJSONString());
		DbOperation.getData();
	}
}
