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
public class ClassesForCharacter implements Serializable {
    @Inject
    private ClassesDAO classesDAO;
    @Inject
    private PlayerCharactersDAO playerCharactersDAO;

    @Getter @Setter
    private PlayerCharacter playerCharacter;

    @PostConstruct
    public void init(){
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer playerCharacterId = Integer.parseInt(requestParameters.get("playerCharacterId"));
        this.playerCharacter = playerCharactersDAO.findOne(playerCharacterId);
    }
}
