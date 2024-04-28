package org.example.lab1.usecases;

import lombok.Getter;
import lombok.Setter;
import org.example.lab1.entities.Person;
import org.example.lab1.persistence.PeopleDAO;
import javax.transaction.Transactional;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

@Model
public class People implements Serializable {
    @Inject
    private PeopleDAO peopleDAO;

    @Getter @Setter
    private Person personToCreate = new Person();

    @Getter
    private List<Person> allPeople;

    @PostConstruct
    public void init(){ loadAllPeople(); }

    @Transactional
    public void createPerson(){
        System.out.println("Creating person: " + personToCreate.toString());
        this.peopleDAO.persist(personToCreate);
    }

    private void loadAllPeople(){
        this.allPeople = peopleDAO.loadAll();
    }
}
