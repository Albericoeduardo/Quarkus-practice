package org.acme.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.acme.form.NewsForm;
import org.acme.model.News;
import org.acme.service.NewsService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class NewsServiceImpl implements NewsService{

    public static List<News> newsList = new ArrayList<>();

    @Override
    public Response getNews(){
        return Response.ok(newsList).build();
    }

    @Override
    public Response createNews(NewsForm newsForm){
        News news = new News();

        news.setId(UUID.randomUUID());
        news.setTitle(newsForm.getTitle());
        news.setDescription(newsForm.getDescription());
        news.setImage(newsForm.getImageUrl());

        newsList.add(news);
        return Response.status(Response.Status.CREATED).entity(news).build();
    }

    @Override
    public Response deleteNews(@PathParam("id") UUID id) {
        Optional<News> newsToDelete = newsList.stream().filter(newsList -> newsList.getId().equals(id)).findFirst();

        boolean removed = false;
        if(newsToDelete.isPresent()) {
            removed = newsList.remove(newsToDelete.get());
        }
        if (removed) {
            return Response.noContent().build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
}
