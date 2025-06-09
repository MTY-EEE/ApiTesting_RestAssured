import com.github.javafaker.Faker;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class _05_Movies {

    RequestSpecification reqSpec;
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
    }

    @Test
    public void TC10_GetNowPlayingMovies(){


    }
    @Test
    public void TC11_GetPopularMovies(){


    }
    @Test
    public void TC12_GetTopRatedMovies(){


    }
    @Test
    public void TC13_GetUpcomingMovies(){


    }

    @Test
    public void TC15_GetMovieDetails(){


    }

    @Test
    public void TC17_AddMovieRating(){
        given()
                .spec(reqSpec)
                .body("{\"value\": 9.5}")
                .when()
                .post("https://api.themoviedb.org/3/movie/278/rating")
                .then()
                .statusCode(201)
                .log().body()
        ;

    }

    @Test(dependsOnMethods = "TC17_AddMovieRating")
    public void TC18_DeleteMovieRating(){
        given()
                .spec(reqSpec)
                .when()
                .delete("https://api.themoviedb.org/3/movie/278/rating")
                .then()
                .statusCode(204)
        ;

    }
}
