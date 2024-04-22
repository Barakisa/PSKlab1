package org.example.lab1.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class PlayerCharacter {
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    private String name;

    @Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String race;

    @Basic
    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    private List<Classes> chosenClasses;

    @ManyToMany
    public List<Classes> getChosenClasses() {
        return chosenClasses;
    }

    public void setChosenClasses(List<Classes> chosenClasses) {
        chosenClasses = chosenClasses;
    }

    private Person person;

    @ManyToOne
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
