import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class PatientIntegrationTest {

    @BeforeAll
    static void setUp(){
        RestAssured.baseURI = "http://localhost:4004";
    }

    @Test
    public void shouldReturnPatientsWithValidToken(){
        String loginPayload = """
                    {
                        "email": "testuser@test.com",
                        "password": "password123"
                    }
                """;

        String token = given()     // arrange
                .contentType("application/json")
                .body(loginPayload)
                .when()                             // act
                .post("/auth/login")
                .then()                             // assert
                .statusCode(200)
                .extract()
                .jsonPath()
                .get("token");

        List patients = given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get("/api/patients")
                .then()
                .statusCode(200)
                .body("data", notNullValue())
                .extract()
                .jsonPath()
                .get("data");
        System.out.println(patients);
    }

}
