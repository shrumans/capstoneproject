package apiTestingCapstone;

import static org.testng.Assert.assertTrue;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class ApiTests {
	@Test
	public void getApiStatusValidation() {
	
		RestAssured.baseURI="http://localhost:8080/medicare";
		RestAssured.given().accept(ContentType.HTML).
		header("Content-Type","text/html;charset=ISO-8859-1").
		when().get("/show/all/products").
		then().assertThat().statusCode(200);
	}
	
	@Test
	public void getApiResponseValidation() {
		RestAssured.baseURI="http://localhost:8080/medicare";
		RestAssured.given().accept(ContentType.HTML).
		header("Content-Type","text/html;charset=ISO-8859-1").
		when().get("/show/category/2/products").
		then().assertThat().statusCode(200);
		
		Response res=RestAssured.given().accept(ContentType.HTML).
				when().get("/show/category/2/products");
		String x=res.getBody().asPrettyString();
		Assert.assertTrue(x.contains("Analgesics"));
	}
	
	
	
}
