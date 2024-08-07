package org.acme.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.acme.model.News;
import org.acme.service.NewsService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class NewsServiceImpl implements NewsService{

    public static List<News> news = new ArrayList<>();

    @Override
    public Response getNews(){
        return Response.ok(news).build();
    }

    @Override
    public Response createNews(News newNews){
        news.add(newNews);
        return Response.status(Response.Status.CREATED).entity(news).build();
    }

    @Override
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
