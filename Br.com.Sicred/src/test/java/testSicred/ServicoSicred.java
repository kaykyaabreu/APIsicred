package testSicred;

import org.junit.Test;
import org.junit.runner.Request;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import junit.*;
import org.hamcrest.*;
import static io.restassured.RestAssured.given;

public class ServicoSicred {
	
	private Response response;
	private Request request;
	
	//@Test
	public void consultaCPFGET() {
		String get ="http://localhost:8080/api/v1/restricoes/97093236014";
		response = RestAssured.request(Method.GET,get);
		System.out.println("esse e o status code do servico " + response.statusCode());
		System.out.println(response.asString());
		System.out.println(response.statusCode() == 200);
		
	}
	@Test
	public void criarRestricao(){
		
		given().log().all().contentType("application/json")
		.body("{\r\n"
				+ "    \"nome\": \"Fulano de Tal\",\r\n"
				+ "    \"cpf\": 97093236014,\r\n"
				+ "    \"email\": \"email@email.com\",\r\n"
				+ "    \"valor\": 1200,\r\n"
				+ "    \"parcelas\": 3,\r\n"
				+ "    \"seguro\": true\r\n"
				+ "  }").when().post("http://localhost:8080/api/v1/simulacoes").then().log().all().statusCode(201);
	}
	

}
