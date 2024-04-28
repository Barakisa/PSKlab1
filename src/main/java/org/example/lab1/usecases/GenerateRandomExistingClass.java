package org.example.lab1.usecases;

import org.example.lab1.entities.Classes;
import org.example.lab1.interceptors.LoggedInvocation;
import org.example.lab1.persistence.ClassesDAO;
import org.example.lab1.services.RandomClassPicker;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@SessionScoped
@Named
public class GenerateRandomExistingClass implements Serializable {
    @Inject
    RandomClassPicker randomClassPicker;
    @Inject
    ClassesDAO classesDAO;

    private Classes randomClass = new Classes();

    @LoggedInvocation
    public String generateRandomClass() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        this.randomClass = randomClassPicker.pickRandomClass(classesDAO.loadAll());

        return "/playerCharacterDetails?faces-redirect=true&playerCharacterId=" + requestParameters.get("playerCharacterId");
    }

//    public boolean isClassGenerationRunning() {
//        return classGenerationTask != null && !classGenerationTask.isDone();
//    }

    public String getClassGenerationStatus() throws ExecutionException, InterruptedException {
//        if (classGenerationTask == null) {
//            return null;
//        } else if (isClassGenerationRunning()) {
//            return "Class is being chosen...";
//        }
        return "Definitely not randomly picked class: " + this.randomClass.getTitle();
    }
}
