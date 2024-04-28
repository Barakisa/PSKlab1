package org.example.lab1.persistence;

import org.example.lab1.entities.Person;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class PeopleDAO {
    @Inject
    private EntityManager em;
    public List<Person> loadAll() { return em.createNamedQuery("Person.findAll", Person.class).getResultList();}
    public void setEm(EntityManager em) { this.em = em;}
    public void persist(Person person) { this.em.persist(person); }
    public Person findOne(Integer id) { return em.find(Person.class, id);}
}
