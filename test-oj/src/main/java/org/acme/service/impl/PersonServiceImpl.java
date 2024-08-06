package org.acme.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.acme.entity.Person;
import org.acme.service.PersonService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class PersonServiceImpl implements PersonService{

    public List<Person> team = new ArrayList<>();

    @Override
    public Response getPerson() {
        return Response.ok(team).build();
    }

    @Override
    public Response createPerson(Person newTeam) {
        team.add(newTeam);
        return Response.status(Response.Status.CREATED).entity(newTeam).build();
    }

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
