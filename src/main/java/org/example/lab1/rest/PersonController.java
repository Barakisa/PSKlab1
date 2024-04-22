package org.example.lab1.rest;

import lombok.Getter;
import lombok.Setter;
import org.example.lab1.entities.Person;
import org.example.lab1.entities.PlayerCharacter;
import org.example.lab1.persistence.PeopleDAO;
import org.example.lab1.rest.contracts.PersonDto;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@Path("/person")
public class PersonController {

    @Inject
    @Setter @Getter
    private PeopleDAO peopleDAO;

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") final Integer id) {
        Person person = peopleDAO.findOne(id);
        if (person == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        PersonDto personDto = new PersonDto();
        personDto.setName(person.getName());
        personDto.setSurname(person.getSurname());

        List<String> characterNames = new ArrayList<>();
        for (PlayerCharacter character : person.getCharacters()) {
            characterNames.add(character.getName());
        }
        personDto.setCharacters(characterNames);

        return Response.ok(personDto).build();
    }

    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(
            @PathParam("id") final Integer personId,
            PersonDto personData) {
        try {
            Person existingPerson = peopleDAO.findOne(personId);
            if (existingPerson == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            existingPerson.setName(personData.getName());
            existingPerson.setSurname(personData.getSurname());

            peopleDAO.update(existingPerson);
            return Response.ok().build();
        } catch (OptimisticLockException ole) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }
}
