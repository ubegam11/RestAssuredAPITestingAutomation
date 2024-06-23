package api.endpoints;


import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*; //Static package required for given ,when & then

import api.payloads.User;

public class UserEndPoints {
	//purpose is to perform CRUD Operation
	//on here we define given & when NOT then
	//methods parameter depend upon the whether url needs to pass parameter or not or task type
	public static Response createUser(User payload) {
		Response response=given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.body(payload)
		
		.when()
		.post(Routes.postURL);
		
		return response;
		}
	public static Response getUser(String userName) {
		Response response=given()
		.accept(ContentType.JSON)
		.pathParam("username", userName)
		
		.when()
		.get(Routes.getURL);
		
		return response;
		}
	
	public static Response updateUser(User payload,String userName) {
		Response response=given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.pathParam("username", userName) //as in the url parameter needs to be passed
		.body(payload)

		.when()
		.put(Routes.updateURL);
		
		return response;
		}
	
	public static Response deleteUser(String userName) {
		Response response=given()
		.accept(ContentType.JSON)
		.pathParam("username", userName) //as in the url parameter needs to be passed

		.when()
		.delete(Routes.deleteURL);
		
		return response;
		}

}
