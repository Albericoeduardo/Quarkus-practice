package org.acme.dto;

import java.net.URL;
import java.util.Base64;

import org.acme.model.Recommendation;

public record RecommendationDTO(
    Long id,
    String type,
    String image,
    String title,
    String description,
    URL url
) {
    public static Recommendation createRecommendation(RecommendationDTO recommendationDTO){
        Recommendation recommendation = new Recommendation();

        recommendation.setId(recommendationDTO.id());
        recommendation.setType(recommendationDTO.type());
        recommendation.setTitle(recommendationDTO.title());
        recommendation.setDescription(recommendationDTO.description());
        recommendation.setUrl(recommendationDTO.url());

        byte[] imageBytes = Base64.getDecoder().decode(recommendationDTO.image());
        String imageString = Base64.getEncoder().encodeToString(imageBytes);
        recommendation.setImage(imageString);

        return recommendation;
    }
}