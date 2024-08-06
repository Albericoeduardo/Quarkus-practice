package org.acme.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.acme.entity.Team;
import org.acme.service.TeamService;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/team")
public class TeamServiceImpl implements TeamService{

    public List<Team> teams = new ArrayList<>();

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Override
    public Response getTeam() {
        return Response.ok(teams).build();
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    @Override
    public Response createTeam(Team newTeam) {
        teams.add(newTeam);
        return Response.status(Response.Status.CREATED).entity(newTeam).build();
    }

    @DELETE
    @Consumes(MediaType.TEXT_PLAIN)
    @Override
    public Response deleteTeam(Long id) {
        Optional<Team> teamToDelete = teams.stream().filter(teams -> teams.getId().equals(id)).findFirst();

        boolean removed = false;
        if(teamToDelete.isPresent()){
            removed = teams.remove(teamToDelete.get());
        }
        if (removed) {
            Response.noContent().build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
    
}
