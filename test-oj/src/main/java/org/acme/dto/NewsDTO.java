package org.acme.dto;

import org.acme.model.News;

public record NewsDTO (
    Long id,
    String title,
    String description,
    byte[] image
) {
    public static News creatNews(NewsDTO newsDTO) {
        News news = new News();

        news.setId(newsDTO.id());
        news.setTitle(newsDTO.title());
        news.setDescription(newsDTO.description());
        news.setImage(newsDTO.image());

        return news;
    }
}
