package api.endpoints;

import static io.restassured.RestAssured.given;
import api.payload.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

// Class to perform create, update, delete user API. 
public class UserEndPoints {

    
    public static Response advanceSearch(User payload) {
        Response response = given()
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
            .body(payload)
            .when()
            .post(Routes.advanceSearch_URL);
        return response;
    }
    
    public static Response getCurrencyList() {
        Response response = given()
        .when()
        .get(Routes.currencyList_URL);
        return response;
    }
    
    

}
