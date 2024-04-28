package org.example.lab1.usecases;

import lombok.Getter;
import lombok.Setter;
import org.example.lab1.entities.Campaign;
import org.example.lab1.interceptors.LoggedInvocation;
import org.example.lab1.persistence.CampaignsDAO;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@ViewScoped
@Named
@Getter @Setter
public class UpdateCampaignDetails implements Serializable {
    @Inject
    private CampaignsDAO campaignsDAO;

    private Campaign campaign;

    @PostConstruct
    public void init(){
        System.out.println("SpecificCampaignDetails INIT CALLED");
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer campaignId = Integer.parseInt(requestParameters.get("campaignId"));
        this.campaign = campaignsDAO.findOne(campaignId);
    }
    @Transactional
    @LoggedInvocation
    public String updateCampaign(){
        try{
            campaignsDAO.update(this.campaign);
        } catch (OptimisticLockException e) {
            return "/campaignDetails.xhtml?faces-redirect=true&campaignId=" + this.campaign.getId() + "&error=optimistic-lock-exception";
        }
        return "personDetails.xhtml?personId=" + this.campaign.getDungeonMaster().getId() + "&faces-redirect=true";
    }
}
