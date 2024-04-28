package org.example.lab1.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Person.findAll", query = "select p from Person as p")
})
@Table(name = "PERSON")
@Getter @Setter
public class Person {
    public Person(){
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String surname;

    @OneToMany(mappedBy = "dungeonMaster")
    private List<Campaign> campaigns;

    @OneToMany(mappedBy = "person", fetch = FetchType.EAGER)
    private List<PlayerCharacter> characters;

    public String toString(){
        return "Person:: name: " + this.name + " | surname: " + this.surname;
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }

}
