package org.acme.dto;

import java.util.UUID;

import org.acme.model.News;

public record NewsDTO (
    UUID id,
    String title,
    String description,
    String image
) {
    public static News creatNews(NewsDTO newsDTO) {
        News news = new News();

        news.setId(UUID.randomUUID());
        news.setTitle(newsDTO.title());
        news.setDescription(newsDTO.description());
        news.setImage(newsDTO.image());

        return news;
    }
}
