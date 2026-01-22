import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class AuthIntegrationTest {

    @BeforeAll
    static void setUp(){
        RestAssured.baseURI = "http://localhost:4004";
    }

    @Test
    public void shouldReturnOkWithValidToken(){
        // 1. arrange
        // 2. act
        // 3. assert

        String loginPayload = """
                    {
                        "email": "testuser@test.com",
                        "password": "password123"
                    }
                """;

        Response response = given()     // arrange
                .contentType("application/json")
                .body(loginPayload)
                .when()                             // act
                .post("/auth/login")
                .then()                             // assert
                .statusCode(200)
                .body("token", notNullValue())
                .extract()
                .response();

        System.out.println("Generated Token: " + response.jsonPath().getString("token"));
    }

    @Test
    public void shouldReturnUnauthorizedWithInvalidToken(){
        String loginPayload = """
                    {
                        "email": "invalid_user@test.com",
                        "password": "invalid_password123"
                    }
                """;

        given()     // arrange
                .contentType("application/json")
                .body(loginPayload)
                .when()                             // act
                .post("/auth/login")
                .then()                             // assert
                .statusCode(401);

    }
}
