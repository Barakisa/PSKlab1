package org.example.lab1.persistence;

import org.example.lab1.entities.Classes;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class ClassesDAO {
    @Inject
    private EntityManager em;
    public void persist(Classes classes) { this.em.persist(classes);}
    public Classes findOne(Integer id) { return em.find(Classes.class, id);}
    public Classes update(Classes classes) { return em.merge(classes);}
}
