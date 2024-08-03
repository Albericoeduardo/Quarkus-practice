package org.dfd;

import java.util.ArrayList;
import java.util.List;

import org.dfd.model.Episode;
import org.dfd.model.TvSerie;
import org.dfd.proxy.EpisodeProxy;
import org.dfd.proxy.TvSeriesProxy;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/tvseries")
public class TvSeriesResource {

    @RestClient
    TvSeriesProxy tvSeriesProxy;

    @RestClient
    EpisodeProxy episodeProxy;

    private List<TvSerie> tvSeries = new ArrayList<>();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTvSerie(@QueryParam("title") String title) {
        TvSerie tvSerie = tvSeriesProxy.get(title);
        List<Episode> episodes = episodeProxy.get(tvSerie.getId());
        return Response.ok(episodes).build();
    }
}
