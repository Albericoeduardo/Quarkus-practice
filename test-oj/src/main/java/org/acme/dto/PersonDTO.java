package org.acme.dto;

import org.acme.model.Person;

public record PersonDTO (
    Long id,
    String name,
    String role,
    String description,
    String imageUrl
) {


    public static Person createPerson(PersonDTO personDTO) {
        Person person = new Person();

        person.setId(personDTO.id());
        person.setName(personDTO.name());
        person.setRole(personDTO.role());
        person.setDescription(personDTO.description());
        person.setImage(personDTO.imageUrl());

        return person;
    }
}
