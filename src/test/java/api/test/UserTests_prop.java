package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;

import api.endpoints.Routes;
import api.endpoints.UserEndPoints;
import api.endpoints.UserEndPoints_prop;
import api.payload.User;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class UserTests_prop {

	Faker faker;
	User userPayload;
	
	@BeforeClass
	public void setUpData() {
		
		faker=new Faker();
		userPayload = new User();
		
		userPayload.setSortBy("rank");
		userPayload.setSortOrder("DESC");
		userPayload.setRankType("static");
		userPayload.setPageNo(1);
		userPayload.setPageSize(5);
		userPayload.setSearchId("PROPERTY_SR-31994");
		userPayload.setSearchText("so");


	}
	
	@Test
	public void testAdvanceSearch() {
		
		Response response= UserEndPoints_prop.advanceSearch(userPayload);
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 200);
		
		// Get the page size from response
		String ps_response = response.jsonPath().getString("pageSize");		

        // Convert the return page size from response to integer 
        int pageSize = Integer.parseInt(ps_response);
		
        //Assert page size from response equal page size in the request
		Assert.assertEquals(pageSize, this.userPayload.getPageSize());
		
		// Get the page number from response
		String pn_response = response.jsonPath().getString("pageNo");	
		
		// Convert the return page size from response to integer 
        int pageNumber = Integer.parseInt(pn_response);
        
        //Assert page number from response equal page number in the request
		Assert.assertEquals(pageNumber, this.userPayload.getPageNo());
	
		
		
	}
	
	@Test
	public void testGetCurrencyList() {
		Response response= UserEndPoints_prop.getCurrencyList();
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 200);

	}
	
}
