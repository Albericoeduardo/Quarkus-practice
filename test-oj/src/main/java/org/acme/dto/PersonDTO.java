package org.acme.dto;

import org.acme.model.Person;

public record PersonDTO (
    String name,
    String role,
    String description,
    String image
) {
    public static Person createPerson(PersonDTO personDTO) {
        Person person = new Person();

        person.setName(personDTO.name());
        person.setRole(personDTO.role());
        person.setDescription(personDTO.description());
        person.setImage(personDTO.image());

        return person;
    }
}
