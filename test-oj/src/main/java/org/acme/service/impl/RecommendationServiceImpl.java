package org.acme.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.acme.dto.RecommendationDTO;
import org.acme.model.Recommendation;
import org.acme.service.RecommendationService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class RecommendationServiceImpl implements RecommendationService {

    public List<Recommendation> recommendations = new ArrayList<>();

    @Override
    public Response getRecomendations() {
        return Response.ok(recommendations).build();
    }

    @Override
    public Response createRecomendation(RecommendationDTO recomendationDTO) {
        Recommendation recommendation = RecommendationDTO.createRecommendation(recomendationDTO);
        recommendations.add(recommendation);
        return Response.status(Response.Status.CREATED).entity(recommendation).build();
    }

    @Override
    public Response deleteRecomendation(Long id) {
        Optional<Recommendation> recomendationToDelete = recommendations.stream().filter(recommendations -> recommendations.getId().equals(id)).findFirst();

        boolean removed = false;
        if (recomendationToDelete.isPresent()) {
            removed = recommendations.remove(recomendationToDelete.get());
        }
        if (removed) {
            Response.noContent().build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
}
