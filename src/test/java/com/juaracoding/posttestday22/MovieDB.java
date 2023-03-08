package com.juaracoding.posttestday22;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
//import static sun.security.util.KnownOIDs.ContentType;

public class MovieDB {

    String endpoint = "https://api.themoviedb.org/3/movie/now_playing?api_key=cf95843f7b6bdfd9b18f5d41bf2145d2&language=en-US&page=1";
    String endpoint2 = "https://api.themoviedb.org/3/movie/popular?api_key=cf95843f7b6bdfd9b18f5d41bf2145d2&language=en-US&page=1";
    String endpoint3 = "https://api.themoviedb.org/3/movie/646389/rating?api_key=eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJjZjk1ODQzZjdiNmJkZmQ5YjE4ZjVkNDFiZjIxNDVkMiIsInN1YiI6IjY0MDcyZGEyOTcxNWFlMDA3ZGMxYTI4NyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.Qe4gy9hZmLEmw3lS_pzpRfFmgWm9ahz0gAJlny7G5V8";

    @Test
    public void getMovieNowPlaying() {
        Response response = RestAssured.get(endpoint);

        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusCode());
        System.out.println(response.getTime());
        System.out.println(response.getHeader("content_type"));
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void getMoviePopular() {
        Response movieP = RestAssured.get(endpoint2);

        System.out.println(movieP.getBody().asString());
        System.out.println(movieP.getStatusCode());
        System.out.println(movieP.getTime());
        System.out.println(movieP.getHeader("content_type"));
        Assert.assertEquals(movieP.getStatusCode(), 200);
    }
    @Test
    public void getMovieRating() {
        Response response = RestAssured.get(endpoint3);

        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusCode());
        System.out.println(response.getTime());
        System.out.println(response.getHeader("content_type"));
        Assert.assertEquals(response.getStatusCode(), 401);
    }

}
//        JSONObject request = new JSONObject();
//        request.put("name", "John");
//        System.out.println(request.toJSONString());
//        given()
//                .header("Content-Type", "application/json")
////                    .contentType(ContentType.JSON)
////                    .accept(ContentType.JSON)
//                .body(request.toJSONString())
//                .when()
//                .post("https://api.themoviedb.org/3/movie/{movie_id}/rating?api_key=<<api_key>>")
//                .then()
//                .statusCode(201)
//                .log().all();
//    }