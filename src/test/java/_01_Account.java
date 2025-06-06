import com.github.javafaker.Faker;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class _01_Account {

    RequestSpecification reqSpec;
    Faker randomUreteci = new Faker();
    int account_id = 0;


    @BeforeClass
    public void Setup() // başlangıç işlemleri
    {
        baseURI ="https://api.themoviedb.org";
        // token ve başlangıç set ayarları için spec oluşturuluyor
        reqSpec = new RequestSpecBuilder()   // istek paketi setlenmesi
                .setContentType(ContentType.JSON)  // giden body cinsi
                .addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI3MmVlNGY2ZDNiNzE0MjZjOWFjMGI1NTFkMGMyMDFlZiIsIm5iZiI6MTc0ODcwNDA5OS4yNjMsInN1YiI6IjY4M2IxYjYzYzY3YmIzNzFhMWFkNzc4NSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.gWO87CUEXEwUeKdxG-Ytzpt5BY3KGdDReUp5i5_6hTA")
                .log(LogDetail.URI)  // log.uri
                .build();
    }

    @Test
    public void TC3_GetAccountDetails(){


    }
    @Test
    public void TC4_AddMovietoFavorites(){


    }
    @Test
    public void TC5_AddMovietoWatchlist(){


    }
    @Test
    public void TC6_GetFavoriteMovies(){

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
    public void TC7_GetRatedMovies(){


    }
    @Test
    public void TC8_GetWatchlistMovies(){


    }

}
