package org.acme.dto;

import org.acme.model.Recommendation;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RecommendationDTOTest {

    @Test
    public void testCreateRecommendation() throws MalformedURLException {
        // Given
        URL url = new URL("http://example.com");
        String image = Base64.getEncoder().encodeToString("imageData".getBytes());
        RecommendationDTO dto = new RecommendationDTO(1L, "type", image, "title", "description", url);

        // When
        Recommendation recommendation = RecommendationDTO.createRecommendation(dto);

        // Then
        assertNotNull(recommendation);
        assertEquals(dto.id(), recommendation.getId());
        assertEquals(dto.type(), recommendation.getType());
        assertEquals(dto.title(), recommendation.getTitle());
        assertEquals(dto.description(), recommendation.getDescription());
        assertEquals(dto.url(), recommendation.getUrl());
    }
}
