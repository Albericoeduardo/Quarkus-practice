package org.acme.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.acme.entity.News;
import org.acme.service.NewsService;

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
public class NewsServiceImpl implements NewsService{

    public static List<News> news = new ArrayList<>();

    @Override
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response getNews(){
        return Response.ok(news).build();
    }

    @Override
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    public Response createNews(News newNews){
        news.add(newNews);
        return Response.status(Response.Status.CREATED).entity(news).build();
    }

    @Override
    @DELETE
    @Path("{id}")
    @Consumes(MediaType.TEXT_PLAIN)
    public Response deleteNews(@PathParam("id") Long id) {
        Optional<News> newsToDelete = news.stream().filter(news -> news.getId().equals(id)).findFirst();

        boolean removed = false;
        if(newsToDelete.isPresent()) {
            removed = news.remove(newsToDelete.get());
        }
        if (removed) {
            Response.noContent().build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
}
