package oscar.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITests {

    //RELhLHbZYF3VfH6100kvXo2WcNMl08eLMxRBmpv90HlZ8b8oKV3H7VLjgfmAW9dM
    //http://selenium1py.pythonanywhere.com/de/accounts/login/

    @Test
    public void loginPositiveTest() {
        RequestSpecification requestSpecification = io.restassured.RestAssured.given();

        Response response = requestSpecification.contentType(ContentType.HTML)
                .given().header("Authorization","RELhLHbZYF3VfH6100kvXo2WcNMl08eLMxRBmpv90HlZ8b8oKV3H7VLjgfmAW9dM")
                .given().body("{\n" +
                        "    \"username\": \"Sidorov@mail.ru\",\n" +
                        "    \"password\": \"Sidor12345$\"\n" +
                        "}")
                .when().post("http://selenium1py.pythonanywhere.com/de/accounts/login/");

        String responseBody = response.getBody().asString();
        System.out.println(responseBody);
        int statusCode = response.getStatusCode();
        System.out.println(statusCode);
    }
}
