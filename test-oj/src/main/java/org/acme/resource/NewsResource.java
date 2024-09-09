package org.acme.resource;

import java.util.UUID;

import org.acme.form.NewsForm;
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
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class NewsResource {
    
    @Inject
    NewsService newsService;

    @GET
    public Response getNews(){
        return newsService.getNews();
    }

    @POST
    public Response createNews(NewsForm form){
        return newsService.createNews(form);
    }

    @DELETE
    @Path("/{id}")
    public Response deleteNews(@PathParam("id") UUID id){
        return newsService.deleteNews(id);
    }
}
