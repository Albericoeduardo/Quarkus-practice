package org.acme.service.impl;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.acme.form.NewsForm;
import org.acme.model.News;
import org.acme.service.NewsService;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class NewsServiceImpl implements NewsService{

    public static List<News> newsList = new ArrayList<>();
    String apiKey = System.getenv("APIKEY");
    HttpClient httpClient = HttpClient.newHttpClient();

    @Override
    public Response getNews(){
        return Response.ok(newsList).build();
    }

    @Override
    public Response createNews(NewsForm newsForm){
        News news = new News();
        news.setTitle(newsForm.getName());

        try {
            String imageUrl = uploadImg(newsForm.getImage());
            news.setImage(imageUrl);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Failed to upload image").build();
        }

        newsList.add(news);
        return Response.status(Response.Status.CREATED).entity(news).build();
    }

    @Override
    public Response deleteNews(@PathParam("id") Long id) {
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

    public String uploadImg(byte[] imgBytes) throws IOException, InterruptedException{
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://pics.shade.cool/dashboard/upload-ui"))
            .header("Authorization", "Bearer " + apiKey)
            .header("Content-type", "application/octet-stream")
            .POST(HttpRequest.BodyPublishers.ofByteArray(imgBytes))
            .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            String responseBody = response.body();
            String imgUrl = parseImgUrlFromResponse(responseBody);
            return imgUrl;
        } else {
            throw new IOException("Failed to upload image: " + response.body());
        }
    }

    private String parseImgUrlFromResponse(String responseBody) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = mapper.readTree(responseBody);

            String imageUrl = jsonNode.get("url").asText();

            return imageUrl;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to parse image URL from response", e);
        }
    }
}
