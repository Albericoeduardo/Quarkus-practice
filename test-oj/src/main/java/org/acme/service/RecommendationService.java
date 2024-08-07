package org.acme.service;

import org.acme.dto.RecommendationDTO;

import jakarta.ws.rs.core.Response;

public interface RecommendationService {
    Response getRecomendations();

    Response createRecomendation(RecommendationDTO recomendationDTO);

    Response deleteRecomendation(Long id);
}