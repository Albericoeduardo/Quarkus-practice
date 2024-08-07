package org.acme.service;

import org.acme.model.News;

import jakarta.ws.rs.core.Response;

public interface NewsService {
    Response getNews();

    Response createNews(News newNews);

    Response deleteNews(Long id);
}
