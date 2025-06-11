import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.github.javafaker.Faker;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.specification.ResponseSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;


public class _01_Account extends  Utility{


    int account_id = 0;


    @Test
    public void TC3_GetAccountDetails() {
        given()
                .spec(reqSpec)
                .when()
                .get("https://api.themoviedb.org/3/account")
                .then()
                .contentType(ContentType.JSON)
                .statusCode(200)
                .log().body();
    }

    @Test
    public void TC4_AddMovietoFavorites() {

    }

    @Test
    public void TC5_AddMovietoWatchlist() {

        String AccountID = "22040079";
        baseURI = "https://api.themoviedb.org/3/account/";

        Map<String, String> watchlistBody = new HashMap<>();
        watchlistBody.put("media_type", "movie");
        watchlistBody.put("media_id", "278");
        watchlistBody.put("watchlist", String.valueOf(true));

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(watchlistBody);

            System.out.println("Response Body  \n" + json);
        } catch (Exception e) {
            e.printStackTrace();
        }
        given()

                .spec(reqSpec)
                .when()
                .post(AccountID + "/watchlist")

                .then()
                .statusCode(204)
        ;
    }

    @Test
    public void TC6_GetFavoriteMovies() {

        account_id=
        given()
                .spec(reqSpec)
                .when()
                .get("/3/account")
                .then()
                .statusCode(200)
                .extract().path("id");


        given()
                .spec(reqSpec)
                .when()
                .get("/3/account/"+account_id+"/favorite/movies")
                .then()
                .log().body()
                .statusCode(200)
        ;


    }

    @Test
    public void TC7_GetRatedMovies() {
        given()
                .spec(reqSpec) // Json sectim,Token verdim
                .when()
                .get("https://api.themoviedb.org/3/account/22046102/rated/movies")
                .then()
                .statusCode(200)
                .log().body()

        ;

    }

    @Test
    public void TC8_GetWatchlistMovies() {

        given()
                .spec(reqSpec)
                .queryParam("api_key", "ab2f3dc1bb33c3b438713c3f093b7112")
                //.queryParam("session_id", "5f4012a68dfef8c81c808ee06a7cd744153ff228")
                .queryParam("language", "tr-TR")
                .queryParam("sort_by", "created_at.asc")
                .queryParam("page", 1)
                .when()
                .get("https://api.themoviedb.org/3/account/22043178/watchlist/movies")
                .then()
                .statusCode(200)
                .body("results.size()", greaterThan(0))
                .log().body();

    }
}
