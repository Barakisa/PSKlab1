package org.example.lab1.persistence;

import org.example.lab1.entities.Person;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TransactionRequiredException;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class PeopleDAO {
    @Inject
    private EntityManager em;
    public List<Person> loadAll() { return em.createNamedQuery("Person.findAll", Person.class).getResultList();}
    public void setEm(EntityManager em) { this.em = em;}
    @Transactional
    public void persist(Person person) {
        try {
            System.out.println("Persist and flush person: " + person.toString());
            this.em.persist(person);
            this.em.flush();
            System.out.println("Person persisted successfully.");
        } catch (EntityExistsException ex) {
            System.out.println("Error: The person already exists in the database.");
        } catch (IllegalArgumentException ex) {
            System.out.println("Error: Invalid entity instance provided for persistence.");
        } catch (TransactionRequiredException ex) {
            System.out.println("Error: No transaction is in progress.");
        } catch (PersistenceException ex) {
            System.out.println("Error: Persistence operation failed. Message: " + ex.getMessage());
        } catch (Exception e) {
            System.out.println("Error: An unexpected error occurred during persistence. Message: " + e.getMessage());
        }

    }
    public Person findOne(Integer id) { return em.find(Person.class, id);}
}
