package org.example.lab1.usecases;

import lombok.Getter;
import lombok.Setter;
import org.example.lab1.entities.Classes;
import org.example.lab1.entities.PlayerCharacter;
import org.example.lab1.interceptors.LoggedInvocation;
import org.example.lab1.persistence.ClassesDAO;
import org.example.lab1.persistence.PlayerCharactersDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Model
public class UpdatePlayerCharacterDetails implements Serializable {
    @Inject
    private ClassesDAO classesDAO;
    @Inject
    private PlayerCharactersDAO playerCharactersDAO;

    @Getter @Setter
    private PlayerCharacter playerCharacter;
    @Getter @Setter
    private Integer classToAddId;
    @Getter @Setter
    private Classes classToAdd = new Classes();
    @Getter @Setter
    private Classes classToRemove = new Classes();

    @PostConstruct
    public void init(){
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer playerCharacterId = Integer.parseInt(requestParameters.get("playerCharacterId"));

        this.playerCharacter = playerCharactersDAO.findOne(playerCharacterId);
    }

    @Transactional
    @LoggedInvocation
    public String updatePlayerCharacter(){
        try{
            playerCharactersDAO.update(this.playerCharacter);
        } catch (OptimisticLockException e) {
            return "/playerCharacterDetails.xhtml?faces-redirect=true&campaignId=" + this.playerCharacter.getId() + "&error=optimistic-lock-exception";
        }
        return "personDetails.xhtml?personId=" + this.playerCharacter.getPerson().getId() + "&faces-redirect=true";
    }

    @Transactional
    @LoggedInvocation
    public String addClass(){
        this.classToAdd = classesDAO.findOne(classToAddId);
        List<Classes> classes = this.playerCharacter.getChosenClasses();
        classes.add(this.classToAdd);
        this.playerCharacter.setChosenClasses(classes);
        //DRY: it would be the same as updatePlayerCharacter() method
        return updatePlayerCharacter();
    }

    @Transactional
    @LoggedInvocation
    public String removeClass(){
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer classToRemoveId = Integer.parseInt(requestParameters.get("classToRemoveId"));
        this.classToRemove = classesDAO.findOne(classToRemoveId);

        List<Classes> classes = this.playerCharacter.getChosenClasses();
        classes.remove(classToRemove);
        this.playerCharacter.setChosenClasses(classes);
        //DRY: it would be the same as updatePlayerCharacter() method
        return updatePlayerCharacter();
    }
}
