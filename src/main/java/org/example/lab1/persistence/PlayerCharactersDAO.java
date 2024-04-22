package org.example.lab1.persistence;

import org.example.lab1.entities.PlayerCharacter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class PlayerCharactersDAO {
    @Inject
    private EntityManager em;
    public void persist(PlayerCharacter playerCharacter) { this.em.persist(playerCharacter);}
    public PlayerCharacter findOne(Integer id) { return em.find(PlayerCharacter.class, id);}
    public PlayerCharacter update(PlayerCharacter classes) { return em.merge(classes);}
}
