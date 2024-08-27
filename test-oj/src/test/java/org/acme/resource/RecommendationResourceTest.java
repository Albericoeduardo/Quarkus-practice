package org.acme.resource;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.acme.dto.RecommendationDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class RecommendationResourceTest {

    @BeforeEach
    public void setUp() {
        RestAssured.basePath = "/recommendations";
    }

    @Test
    public void testGetRecommendations() {
        given()
            .when().get()
            .then()
            .statusCode(200);
    }

    @Test
    public void testCreateRecommendation() throws MalformedURLException {
        RecommendationDTO dto = createRecommendationDTO();

        given()
            .contentType(ContentType.JSON)
            .body(dto)
            .when().post()
            .then()
            .statusCode(201)
            .body("id", is(dto.id().intValue()))
            .body("type", is(dto.type()))
            .body("title", is(dto.title()))
            .body("description", is(dto.description()))
            .body("url", is(dto.url().toString()));
    }

    @Test
    public void testDeleteRecommendation() throws MalformedURLException {
        RecommendationDTO dto = createRecommendationDTO();
        given()
            .contentType(ContentType.JSON)
            .body(dto)
            .when().post()
            .then()
            .statusCode(201);

        given()
            .when().delete("/{id}", dto.id())
            .then()
            .statusCode(204);
    }

    @Test
    public void testDeleteRecommendationNotFound() {
        given()
            .when().delete("/{id}", 999L)
            .then()
            .statusCode(400);
    }

    private RecommendationDTO createRecommendationDTO() throws MalformedURLException {
        URL url = new URL("http://example.com");
        String image = Base64.getEncoder().encodeToString("imageData".getBytes());
        return new RecommendationDTO(1L, "type", image, "title", "description", url);
    }
}
