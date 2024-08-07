package org.acme.resource;

import org.acme.model.News;
import org.acme.service.NewsService;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/news")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
public class NewsResource {
    
    @Inject
    NewsService newsService;

    @GET
    public Response getNews(){
        return newsService.getNews();
    }

    @POST
    public Response createNews(News newNews){
        return newsService.createNews(newNews);
    }

    @DELETE
    @Path("/{id}")
    public Response deleteNews(@PathParam("id") Long id){
        return newsService.deleteNews(id);
    }
}
