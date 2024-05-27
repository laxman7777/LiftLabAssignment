package com.Liftlabs.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ConfigReader {
    private Properties properties = new Properties();

    public ConfigReader() {
        try {
            FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
    
    public String getJsonPath(Response response,String key)
	{
		  String resp=response.asString();
		JsonPath   js = new JsonPath(resp);
		return js.get(key).toString();
	}
}