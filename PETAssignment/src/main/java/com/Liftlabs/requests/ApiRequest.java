package com.Liftlabs.requests;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import com.Liftlabs.utils.ConfigReader;






public class ApiRequest {
    private ConfigReader configReader = new ConfigReader();
    private RequestSpecification res;

    public ApiRequest() {
        RestAssured.baseURI = configReader.getProperty("baseURL");
        res = RestAssured.given().header("Content-Type", "application/json");
    }

    public RequestSpecification getRequest() {
        return res;
    }
} 

