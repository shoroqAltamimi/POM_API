package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

// Class to perform create, update, delete user API. 
public class UserEndPoints_prop {

	// > get the URLs from properties file
	
	 static ResourceBundle getURL(){
		ResourceBundle routes= ResourceBundle.getBundle("routes"); //Load properties file
		return routes;
	}
	
    
    public static Response advanceSearch(User payload) {
    	
    	String advSearch_URL= getURL().getString("advanceSearch_URL");
    	
        Response response = given()
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
            .body(payload)
            .when()
            .post(advSearch_URL);
        return response;
    }
    
    public static Response getCurrencyList() {
    	
    	String currList_URL= getURL().getString("currencyList_URL");

        Response response = given()
        .when()
        .get(currList_URL);
        return response;
    }
    
    

}
