package abc.com.RestAssureCore;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.annotations.Test;
import Utils.PayloadConverter;
import Utils.URL;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import abc.com.RestAssureCore.RESSTCalls;

public class LoginTest {
	Response reponse;
	private static Logger log = LogManager.getLogger(LoginTest.class.getName());

@Test
	public void doLogin() throws IOException {
	log.info("Starting Test Case : doLogin");
		String loginPayload = PayloadConverter.generatePayloadString("Login.json");
		
		String endPointURI = URL.getEndPoint("/login.jsp");
		reponse = RESSTCalls.POSTRequest(endPointURI, loginPayload);
	
		String strResponse = reponse.getBody().asString();
		System.out.println("********* Response JSON *********");
		System.out.println(strResponse);
		
		JsonPath jsonRes = new JsonPath(reponse);
		String sessionID = jsonRes.getString("session.value");
		
		log.info("JIRA JSession ID: " + sessionID );
	}

}
