package org.example.lab1.usecases;

import lombok.Getter;
import lombok.Setter;
import org.example.lab1.entities.Classes;
import org.example.lab1.entities.Person;
import org.example.lab1.interceptors.LoggedInvocation;
import org.example.lab1.persistence.ClassesDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Model
public class AllClasses implements Serializable {
    @Inject
    private ClassesDAO classesDAO;

    @Getter @Setter
    private Classes classToCreate = new Classes();

    @Getter
    private List<Classes> allClasses;

    @PostConstruct
    public void init(){ loadAllClasses(); }

    @Transactional
    public void createClass(){
        this.classesDAO.persist(classToCreate);
    }

    private void loadAllClasses(){
        this.allClasses = classesDAO.loadAll();
    }

}
