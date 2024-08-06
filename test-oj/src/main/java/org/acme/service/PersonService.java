package org.acme.service;

import org.acme.entity.Person;

import jakarta.ws.rs.core.Response;

public interface PersonService {
    Response getPerson();

    Response createPerson(Person newPerson);

    Response deletePerson(Long id);
}
