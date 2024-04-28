package org.example.lab1.usecases;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;
import org.example.lab1.entities.Campaign;
import org.example.lab1.entities.Person;
import org.example.lab1.entities.PlayerCharacter;
import org.example.lab1.interceptors.LoggedInvocation;
import org.example.lab1.persistence.CampaignsDAO;
import org.example.lab1.persistence.PeopleDAO;
import org.example.lab1.persistence.PlayerCharactersDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
@Model
public class PlayerCharactersForPerson implements Serializable {
    @Inject
    private PeopleDAO peopleDAO;
    @Inject
    private PlayerCharactersDAO playerCharactersDAO;

    @Getter @Setter
    private Person person;

    @Getter @Setter
    private PlayerCharacter playerCharacterToCreate = new PlayerCharacter();
    @Getter
    private List<Campaign> allCampaigns;

    @PostConstruct
    public void init(){
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer personId = Integer.parseInt(requestParameters.get("personId"));
        this.person = peopleDAO.findOne(personId);
    }
    @Transactional
    @LoggedInvocation
    public void createPlayerCharacter(){
        playerCharacterToCreate.setPerson(this.person);
        this.playerCharactersDAO.persist(playerCharacterToCreate);
    }
}
