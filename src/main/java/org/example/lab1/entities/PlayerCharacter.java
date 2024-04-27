package org.example.lab1.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class PlayerCharacter {
    public PlayerCharacter(){
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String race;

    @ManyToMany
    @JoinTable(
            name = "CHARACTER_CLASSES",
            joinColumns = @JoinColumn(name = "CLASS_ID"),
            inverseJoinColumns = @JoinColumn(name = "CHARACTER_ID"))
    private List<Classes> chosenClasses;


    @ManyToOne
    private Person person;

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public List<Classes> getChosenClasses() {
        return chosenClasses;
    }

    public void setChosenClasses(List<Classes> chosenClasses) {
        this.chosenClasses = chosenClasses;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }
}
