package org.example.lab1.services;

import lombok.Getter;
import lombok.Setter;
import org.example.lab1.entities.Classes;
import org.example.lab1.persistence.ClassesDAO;
import org.example.lab1.usecases.AllClasses;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;
import java.util.Random;
@ApplicationScoped
public class RandomClassPicker implements Serializable {
    public Classes pickRandomClass(List<Classes> allClasses) {

        Random random = new Random();
        int randomIndex = random.nextInt(allClasses.size());

        return allClasses.get(randomIndex);
    }
}
