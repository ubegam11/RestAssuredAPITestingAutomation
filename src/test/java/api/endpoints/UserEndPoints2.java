package api.endpoints;


import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*; //Static package required for given ,when & then

import java.util.ResourceBundle;

import api.payloads.User;

public class UserEndPoints2 {
	//It run from the routes.properties file
	//purpose is to perform CRUD Operation
	//on here we define given & when NOT then
	//methods parameter depend upon the whether url needs to pass parameter or not or task type
	static ResourceBundle getURLs() {
		ResourceBundle routes=ResourceBundle.getBundle("Routes");//it default read from resource folder
		return routes;
	}
	public static Response createUser(User payload) {
		String postURL=getURLs().getString("postURL");
		Response response=given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.body(payload)
		
		.when()
		.post(postURL);
		
		return response;
		}
	public static Response getUser(String userName) {
		String getURL=getURLs().getString("getURL");

		Response response=given()
		.accept(ContentType.JSON)
		.pathParam("username", userName)
		
		.when()
		.get(getURL);
		
		return response;
		}
	
	public static Response updateUser(User payload,String userName) {
		String updateURL=getURLs().getString("updateURL");

		Response response=given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.pathParam("username", userName) //as in the url parameter needs to be passed
		.body(payload)

		.when()
		.put(updateURL);
		
		return response;
		}
	
	public static Response deleteUser(String userName) {
		String deleteURL=getURLs().getString("deleteURL");

		Response response=given()
		.accept(ContentType.JSON)
		.pathParam("username", userName) //as in the url parameter needs to be passed

		.when()
		.delete(deleteURL);
		
		return response;
		}

}
