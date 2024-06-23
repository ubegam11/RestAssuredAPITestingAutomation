package api.testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payloads.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class UserTest_DD {
	
	
	@Test(priority = 1,dataProvider = "AllData",dataProviderClass = DataProviders.class)
	public void createUser(String userID,String userName,String fName,String lName,String email,String password,String phone) {
		User userPayload=new User();
		userPayload.setId(Integer.parseInt(userID));
		userPayload.setUsername(userName);
		userPayload.setFirstName(fName);
		userPayload.setLastName(lName);
		userPayload.setEmail(email);
		userPayload.setPassword(password);
		userPayload.setPhone(phone);

		
		Response response = UserEndPoints.createUser(userPayload);
		
		response.then().log().all();
		
		Assert.assertEquals(response.statusCode(), 200);
	}
	
	@Test(priority=2,dataProvider = "UserNameData", dataProviderClass = DataProviders.class)
	public void getUser(String username)
	{

		Response response = UserEndPoints.getUser(username);

		response.then().log().all();
		
		//validation
		Assert.assertEquals(response.getStatusCode(),200);


	}
	


	@Test(priority = 3,dataProvider = "UserNameData",dataProviderClass = DataProviders.class)
	public void deleteUser(String userName) {
		Response response = UserEndPoints.deleteUser(userName);
		
		response.then().log().all();
		
		Assert.assertEquals(response.statusCode(), 200);
	}
	

}
