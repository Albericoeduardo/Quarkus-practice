package org.acme.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.acme.entity.Person;
import org.acme.service.PersonService;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/team")
public class PersonServiceImpl implements PersonService{

    public List<Person> team = new ArrayList<>();

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Override
    public Response getPerson() {
        return Response.ok(team).build();
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    @Override
    public Response createPerson(Person newTeam) {
        team.add(newTeam);
        return Response.status(Response.Status.CREATED).entity(newTeam).build();
    }

    @DELETE
    @Consumes(MediaType.TEXT_PLAIN)
    @Override
    public Response deletePerson(Long id) {
        Optional<Person> teamToDelete = team.stream().filter(team -> team.getId().equals(id)).findFirst();

        boolean removed = false;
        if(teamToDelete.isPresent()){
            removed = team.remove(teamToDelete.get());
        }
        if (removed) {
            Response.noContent().build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
    
}
