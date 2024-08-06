package org.acme.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.acme.entity.Recommendation;
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
    public Response createRecomendation(Recommendation newRecomendation) {
        recommendations.add(newRecomendation);
        return Response.status(Response.Status.CREATED).entity(newRecomendation).build();
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
