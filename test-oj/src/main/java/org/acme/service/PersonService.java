package org.acme.service;

import org.acme.dto.PersonDTO;

import jakarta.ws.rs.core.Response;

public interface PersonService {
    Response getPerson();

    Response createPerson(PersonDTO personDTO);

    Response deletePerson(Long id);
}
