package org.example.lab1.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Classes {
    public Classes(){
    }

    @Basic
    private String Title;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "chosenClasses")
    private List<PlayerCharacter> Characters;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<PlayerCharacter> getCharacters() {
        return Characters;
    }

    public void setCharacters(List<PlayerCharacter> characters) {
        Characters = characters;
    }

    @Override
    public int hashCode() {

        return Objects.hash(Title);
    }
}
