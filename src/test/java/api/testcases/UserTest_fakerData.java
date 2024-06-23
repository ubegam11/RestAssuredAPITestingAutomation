package api.testcases;

import org.testng.annotations.BeforeClass;

import org.apache.logging.log4j.*;
import org.testng.Assert;
import org.testng.annotations.*;
import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payloads.User;
import io.restassured.response.Response;

//on this test class we will perform first the request operation by calling the userEndpoint pass (CRUD operation) then validation part by using then()
public class UserTest_fakerData {
	Faker faker;
	User userPayload;
	public  static Logger logger;

	@BeforeClass
	public void generateTestData() {
		faker = new Faker();
		userPayload=new User();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5, 10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
		//obtain logger
		logger=LogManager.getLogger("RestAssuredAPITestingAutomation");
	}

	@Test(priority = 1)
	public void createUser() {
		Response response = UserEndPoints.createUser(userPayload);
		
		response.then().log().all();
		
		Assert.assertEquals(response.statusCode(), 200);
		logger.info("User gets created");
	}
	

	@Test(priority = 2)
	public void getUser() {
		Response response = UserEndPoints.getUser(this.userPayload.getUsername());
		
		response.then().log().all();
		
		Assert.assertEquals(response.statusCode(), 200);
		logger.info("get User  detail");

	}
	@Test(priority = 3)
	public void updateUser() {
		userPayload.setFirstName(faker.name().firstName());

		Response response = UserEndPoints.updateUser(userPayload,this.userPayload.getUsername());
		
		response.then().log().all();
		
		Assert.assertEquals(response.statusCode(), 200);
		logger.info("User gets updated");

		
	}
	@Test(priority = 4)
	public void deleteUser() {
		Response response = UserEndPoints.deleteUser(this.userPayload.getUsername());
		
		response.then().log().all();
		
		Assert.assertEquals(response.statusCode(), 200);
		logger.info("User gets deleted");
		
	}
	

}
