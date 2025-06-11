import com.github.javafaker.Faker;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class _03_MovieList extends Utility{

    String listId = "8535281";
    String invalidSessionId = "this_is_an_invalid_session_id";
    String apiKey = "607ae4b77a41cb68f9cfc37388f60144";


    @Test
    public void TC_19_UnauthorizedAddItemTest() {
        given()
                .spec(reqSpec)
                .pathParam("list_id", listId)
                .queryParam("api_key", apiKey)
                .queryParam("session_id", invalidSessionId)
                .body("{\"media_id\": 18}")
                .when()
                .post("/list/{list_id}/add_item")
                .then()
                .statusCode(401)
                .body("status_code", equalTo(3))
                .body("status_message", equalTo("Authentication failed: You do not have permissions to access the service."))
                .log().body();
    }
}

