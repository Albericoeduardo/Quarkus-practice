package org.acme.dto;

import java.net.URL;

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
        recommendation.setImage(recommendationDTO.image());
        recommendation.setTitle(recommendationDTO.title());
        recommendation.setDescription(recommendationDTO.description());
        recommendation.setUrl(recommendationDTO.url());
        return recommendation;
    }
}