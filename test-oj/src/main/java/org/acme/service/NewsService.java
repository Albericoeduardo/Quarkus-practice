package org.acme.service;

import org.acme.dto.NewsDTO;

import jakarta.ws.rs.core.Response;

public interface NewsService {
    Response getNews();

    Response createNews(NewsDTO recommendationDto);

    Response deleteNews(Long id);
}
