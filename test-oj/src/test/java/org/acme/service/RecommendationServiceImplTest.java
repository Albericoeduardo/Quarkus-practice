package org.acme.service;

import org.acme.dto.RecommendationDTO;
import org.acme.model.Recommendation;
import org.acme.service.impl.RecommendationServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jakarta.ws.rs.core.Response;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RecommendationServiceImplTest {

    private RecommendationServiceImpl recommendationService;

    @BeforeEach
    public void setUp() {
        recommendationService = new RecommendationServiceImpl();
    }

    @Test
    public void testGetRecommendations() {
        // Given
        RecommendationDTO dto = null;
        try {
            dto = createRecommendationDTO();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        recommendationService.createRecomendation(dto);

        // When
        var response = recommendationService.getRecomendations();
        @SuppressWarnings("unchecked")
        List<Recommendation> recommendations = (List<Recommendation>) response.getEntity();

        // Then
        assertEquals(1, recommendations.size());
    }

    @Test
    public void testCreateRecommendation() throws MalformedURLException {
        // Given
        RecommendationDTO dto = createRecommendationDTO();

        // When
        var response = recommendationService.createRecomendation(dto);
        var createdRecommendation = (Recommendation) response.getEntity();

        // Then
        assertEquals(Response.Status.CREATED.getStatusCode(), response.getStatus());
        assertNotNull(createdRecommendation);
        assertEquals(dto.id(), createdRecommendation.getId());
        assertEquals(dto.type(), createdRecommendation.getType());
        assertEquals(dto.title(), createdRecommendation.getTitle());
        assertEquals(dto.description(), createdRecommendation.getDescription());
        assertEquals(dto.url(), createdRecommendation.getUrl());
    }

    @Test
    public void testDeleteRecommendation() throws MalformedURLException {
        // Given
        RecommendationDTO dto = createRecommendationDTO();
        recommendationService.createRecomendation(dto);
        Long id = dto.id();

        // When
        var response = recommendationService.deleteRecomendation(id);

        // Then
        assertEquals(Response.Status.NO_CONTENT.getStatusCode(), response.getStatus());
    }

    @Test
    public void testDeleteRecommendationNotFound() {
        // Given
        Long id = 999L;

        // When
        var response = recommendationService.deleteRecomendation(id);

        // Then
        assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), response.getStatus());
    }

    private RecommendationDTO createRecommendationDTO() throws MalformedURLException {
        URL url = new URL("http://example.com");
        String image = Base64.getEncoder().encodeToString("imageData".getBytes());
        return new RecommendationDTO(1L, "type", image, "title", "description", url);
    }
}
