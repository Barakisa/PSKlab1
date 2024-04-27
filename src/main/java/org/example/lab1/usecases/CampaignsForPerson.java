package org.example.lab1.usecases;

import lombok.Getter;
import lombok.Setter;
import org.example.lab1.entities.Campaign;
import org.example.lab1.entities.Person;
import org.example.lab1.interceptors.LoggedInvocation;
import org.example.lab1.persistence.CampaignsDAO;
import org.example.lab1.persistence.PeopleDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Model
public class CampaignsForPerson implements Serializable {
    @Inject
    private PeopleDAO peopleDAO;
    @Inject
    private CampaignsDAO campaignsDAO;

    @Getter @Setter
    private Person person;

    @Getter @Setter
    private Campaign campaignToCreate = new Campaign();
    @Getter
    private List<Campaign> allCampaigns;

    @PostConstruct
    public void init(){
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer teamId = Integer.parseInt(requestParameters.get("personId"));
        this.person = peopleDAO.findOne(teamId);
    }
    @Transactional
    @LoggedInvocation
    public void createCampaign(){
        campaignToCreate.setDungeonMaster(this.person);
        this.campaignsDAO.persist(campaignToCreate);
    }
}
