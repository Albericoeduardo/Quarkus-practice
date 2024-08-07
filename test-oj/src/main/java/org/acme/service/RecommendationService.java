package org.acme.service;

import org.acme.model.Recommendation;

import jakarta.ws.rs.core.Response;

public interface RecommendationService {
    Response getRecomendations();

    Response createRecomendation(Recommendation newRecomendation);

    Response deleteRecomendation(Long id);
}