package org.acme;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/movies")
@Tag(name = "Movie Resource", description="Movie REST API")
public class MovieResource {
    
    public static List<Movie> movies = new ArrayList<>();

    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/size")
    @Operation(
        operationId = "countMovies",
        summary = "Count Movies",
        description = "Size of the list movies"
    )
    @APIResponse(
        responseCode = "200",
        description = "Operation completed",
        content = @Content(mediaType = MediaType.TEXT_PLAIN)
    )
    public Integer countMovies() {
        return movies.size();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
        operationId = "getMovies",
        summary = "Get Movies",
        description = "Get all movies inside the list"
    )
    @APIResponse(
        responseCode = "200",
        description = "Operation completed",
        content = @Content(mediaType = MediaType.APPLICATION_JSON)
    )
    public Response getMovies() {
        return Response.ok(movies).build();
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(
        operationId = "createMovie",
        summary = "Create a new Movie",
        description = "Create a new movie to add inside the list"
    )
    @APIResponse(
        responseCode = "201",
        description = "Movie created",
        content = @Content(mediaType = MediaType.APPLICATION_JSON)
    )
    public Response createMovie(
            @RequestBody(
                description = "Movie to create",
                required = true,
                content = @Content(schema = @Schema(implementation = Movie.class))
            )
            Movie newMovie) {
        movies.add(newMovie);
        return Response.status(Response.Status.CREATED).entity(movies).build();
    }


    @PUT
    @Path("{id}/{title}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(
        operationId = "updateMovie",
        summary = "Update a existing Movie",
        description = "Update a movie inside the list"
    )
    @APIResponse(
        responseCode = "200",
        description = "Movie updated",
        content = @Content(mediaType = MediaType.APPLICATION_JSON)
    )
    public Response updateMovie(
            @Parameter(
                description = "Movie id",
                required = true
            )
            @PathParam("id")Long id, 
            
            @Parameter(
                description = "Movie title",
                required = true
            )
            @PathParam("title")String title) {
        movies = movies.stream().map(movie -> {
            if (movie.getId().equals(id)) {
                movie.setTitle(title);
            }
            return movie;
        }).collect(Collectors.toList());

        return Response.ok(movies).build();
    }

    @DELETE
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(
        operationId = "deleteMovie",
        summary = "Delete a existing Movie",
        description = "Delete a movie inside the list"
    )
    @APIResponse(
        responseCode = "204",
        description = "Movie deleted",
        content = @Content(mediaType = MediaType.APPLICATION_JSON)
    )
    @APIResponse(
        responseCode = "400",
        description = "Movie not valid",
        content = @Content(mediaType = MediaType.APPLICATION_JSON)
    )
    public Response deleteMovie(@PathParam("id") Long id) {
        Optional<Movie> movieToDelete = movies.stream().filter(movie -> movie.getId().equals(id))
            .findFirst();

        boolean removed = false;
        if (movieToDelete.isPresent()) {
            removed = movies.remove(movieToDelete.get());
        }
        if (removed) {
            Response.noContent().build();
        } 
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

}
