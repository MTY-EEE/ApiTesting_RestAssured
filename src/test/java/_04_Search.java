import com.github.javafaker.Faker;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.Matchers.greaterThan;

public class _04_Search extends Utility{



    @Test
    public void TC14_SearchforMovies() {

        given()
                .spec(reqSpec)
                .queryParam("api_key", "6f28b1c6e99b76f1e69316fb5d7740d4")
                .queryParam("query", "snow white")

                .when()
                .get("https://api.themoviedb.org/3/search/movie")

                .then()
                .statusCode(200)
                .body("results.title", hasItem("Snow White"))
                .log().body();

    }

    @Test
    public void TC16_SearchforKeywords() {

        given()
                .spec(reqSpec)
                .queryParam("api_key", "ab2f3dc1bb33c3b438713c3f093b7112")
                .queryParam("query", "star wars")
                .queryParam("page", 1)
                .when()
                .get("https://api.themoviedb.org/3/search/keyword")
                .then()
                .statusCode(200)
                .body("results.size()", greaterThan(0))
                .body("results.name", hasItem("star wars"))
                .log().body();

    }

}
