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

public class _01_Account {

    RequestSpecification reqSpec;
    ResponseSpecification resSpec;
    Faker randomUreteci = new Faker();


    @BeforeClass
    public void Setup() // başlangıç işlemleri
    {
        // token ve başlangıç set ayarları için spec oluşturuluyor
        reqSpec = new RequestSpecBuilder()   // istek paketi setlenmesi
                .setContentType(ContentType.JSON)  // giden body cinsi
                .addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI3MmVlNGY2ZDNiNzE0MjZjOWFjMGI1NTFkMGMyMDFlZiIsIm5iZiI6MTc0ODcwNDA5OS4yNjMsInN1YiI6IjY4M2IxYjYzYzY3YmIzNzFhMWFkNzc4NSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.gWO87CUEXEwUeKdxG-Ytzpt5BY3KGdDReUp5i5_6hTA")
                .log(LogDetail.URI)  // log.uri
                .build();
        resSpec = new ResponseSpecBuilder()
                .log(LogDetail.BODY)
                .expectContentType(ContentType.JSON)
                .build();
    }

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
                .statusCode(403)
        ;
    }

    @Test
    public void TC6_GetFavoriteMovies() {


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


    }

}
