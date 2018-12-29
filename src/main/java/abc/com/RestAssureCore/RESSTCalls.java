package abc.com.RestAssureCore;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class RESSTCalls {
	/*
	 * This call will be resposible to fire requests
	 */
	private static Logger log = LogManager.getLogger(RESSTCalls.class.getName());

	public static Response GETRequest(String uRI) {
		log.info("Inside GETRequest call");
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType(ContentType.JSON);
		Response respone = requestSpecification.get(uRI);
		log.debug(requestSpecification.log().all());
		return (respone);

	}

	public static Response POSTRequest(String uRI, String strJSON) {
		log.info("Inside POSTRequest call");
		RequestSpecification requestSpecification = RestAssured.given().body(strJSON);
		requestSpecification.contentType(ContentType.JSON);
		Response respone = requestSpecification.post(uRI);
		log.debug(requestSpecification.log().all());
		return (respone);
		

	}

	public static Response PUTRequest(String uRI,String strJSON) {
		log.info("Inside PUTRequest call");
		RequestSpecification requestSpecification = RestAssured.given().body(strJSON);
		requestSpecification.contentType(ContentType.JSON);
		Response respone = requestSpecification.put(uRI);
		log.debug(requestSpecification.log().all());
		return (respone);

	}

	public static Response DELETERequest(String uRI,String strJSON) {
		log.info("Inside DELETERequest call");
		RequestSpecification requestSpecification = RestAssured.given().body(strJSON);
		requestSpecification.contentType(ContentType.JSON);
		Response respone = requestSpecification.delete(uRI);
		log.debug(requestSpecification.log().all());
		return (respone);

	}

}
