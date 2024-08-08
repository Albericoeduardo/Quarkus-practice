package org.acme.resource;

import org.acme.dto.PersonDTO;
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
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonResource {
    
    @Inject
    PersonService personService;

    @GET
    public Response getPerson(){
        return personService.getPerson();
    }

    @POST
    public Response createPerson(PersonDTO dto){
        return personService.createPerson(dto);
    }

    @DELETE
    @Path("/{id}")
    public Response deletePerson(@PathParam("id") Long id){
        return personService.deletePerson(id);
    }
}
