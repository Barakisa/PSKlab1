package org.example.lab1.persistence;

import org.example.lab1.entities.Campaign;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class CampaignsDAO {
    @Inject
    private EntityManager em;
    public void persist(Campaign campaign) { this.em.persist(campaign);}
    public Campaign findOne(Integer id) { return em.find(Campaign.class, id);}
    public Campaign update(Campaign campaign) { return em.merge(campaign);}
}
