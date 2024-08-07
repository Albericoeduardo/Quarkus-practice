package org.acme.resource;

import org.acme.model.Person;
import org.acme.service.PersonService;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/team")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
public class PersonResource {
    
    @Inject
    PersonService personService;

    @GET
    public Response getPerson(){
        return personService.getPerson();
    }

    @POST
    public Response createPerson(Person newPerson){
        return personService.createPerson(newPerson);
    }

    @DELETE
    @Path("/{id}")
    public Response deletePerson(@PathParam("id") Long id){
        return personService.deletePerson(id);
    }
}
