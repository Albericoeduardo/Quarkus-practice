package org.acme.service;

import org.acme.form.NewsForm;

import jakarta.ws.rs.core.Response;

public interface NewsService {
    Response getNews();

    Response createNews(NewsForm newsForm);

    Response deleteNews(Long id);
}
