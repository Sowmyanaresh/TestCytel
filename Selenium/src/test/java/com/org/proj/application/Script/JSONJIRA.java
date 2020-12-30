package com.org.proj.application.Script;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.json.CDL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import static io.restassured.RestAssured.given;

public class JSONJIRA {
	

	GlobalVariables gVar = new GlobalVariables();
	
	    public static void main(String myHelpers[]){
	      //  String jsonString = "{\"infile\": [{\"field1\": 11,\"field2\": 12,\"field3\": 13},{\"field1\": 21,\"field2\": 22,\"field3\": 23},{\"field1\": 31,\"field2\": 32,\"field3\": 33}]}";

	        JSONObject output;
	        try {
	            output = new JSONObject();


	            JSONArray docs = output.getJSONArray("infile");

	            File file=new File("/tmp2/fromJSON.csv");
	            String csv = CDL.toString(docs);
	            FileUtils.writeStringToFile(file, csv);
	        } catch (JSONException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }        
	    }

	

   /* public static Response doGetRequest(String endpoint) {
        RestAssured.defaultParser = Parser.JSON;

        return
                given().headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON).
                        when().get(endpoint).
                        then().contentType(ContentType.JSON).extract().response();
    }

    public static void main(String[] args) {
        Response response = doGetRequest("https://jsonplaceholder.typicode.com/users");

        List<String> jsonResponse = response.jsonPath().getList("$");

        System.out.println(jsonResponse.size());

    }*/
}