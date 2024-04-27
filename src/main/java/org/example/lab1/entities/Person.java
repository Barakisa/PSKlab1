package org.example.lab1.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Person.findAll", query = "select p from Person as p")
})
@Table(name = "PERSON")
public class Person {
    public Person(){
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    @OneToMany(mappedBy = "dungeonMaster")
    private List<Campaign> campaigns;

    @OneToMany(mappedBy = "person", fetch = FetchType.EAGER)
    private List<PlayerCharacter> characters;

    public String toString(){
        return "Person:: name: " + this.name + " | surname: " + this.surname;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public List<Campaign> getCampaigns() {
        return campaigns;
    }

    public List<PlayerCharacter> getCharacters() {
        return characters;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setCampaigns(List<Campaign> campaigns) {
        this.campaigns = campaigns;
    }

    public void setCharacters(List<PlayerCharacter> characters) {
        this.characters = characters;
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }

}
