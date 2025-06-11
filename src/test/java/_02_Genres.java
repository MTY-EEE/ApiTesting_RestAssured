import com.github.javafaker.Faker;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class _02_Genres extends Utility {

    @Test
    public void TC9_GetMovieGenres(){

        given()
                .spec(reqSpec)
                .when()
                .get("https://api.themoviedb.org/3/genre/movie/list")
                .then()
                .statusCode(200)
                .log().body()
        ;


    }

}
