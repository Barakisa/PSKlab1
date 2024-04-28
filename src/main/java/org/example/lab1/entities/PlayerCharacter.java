package org.example.lab1.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "PlayerCharacter.findAll", query = "select p from PlayerCharacter as p")
})
@Getter @Setter
public class PlayerCharacter {
    public PlayerCharacter(){
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String race;

    @ManyToMany
    private List<Classes> chosenClasses;

    @ManyToOne
    private Person person;

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }
}
