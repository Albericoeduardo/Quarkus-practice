package org.acme.resource;

import org.acme.entity.Recommendation;
import org.acme.service.RecommendationService;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/recommendations")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
public class RecommendationResouce {

    RecommendationService recommendationService;

    @GET
    public Response getRecomendations(){
        return recommendationService.getRecomendations();
    }

    @POST
    public Response createRecomendation(Recommendation newRecommendation){
        return recommendationService.createRecomendation(newRecommendation);
    }

    @DELETE
    public Response deleteRecomendation(@PathParam("id") Long id){
        return recommendationService.deleteRecomendation(id);
    }
}
