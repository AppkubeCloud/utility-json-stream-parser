package com.synectiks.json.filter;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonFileLoader {

	public static String load(String fileName) {
		String text = null;
		try{
			text = new String(Files.readAllBytes(Paths.get(fileName)), StandardCharsets.UTF_8);
//			System.out.println(text);
		}catch(Exception ex){
            ex.printStackTrace();
        }
		return text;
	}
	
//	public static void main(String a[]) {
//		String filePath = "D:\\mycode\\json-data\\Catalogue\\dummy_catalogue.json";
//		load(filePath);
//	}
}
