package org.example.lab1.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Classes {

    @Basic
    private String Title;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    @GeneratedValue
    @Id
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToMany(mappedBy = "chosenClasses", fetch = FetchType.EAGER)
    private List<PlayerCharacter> Characters;

    public List<PlayerCharacter> getCharacters() {
        return Characters;
    }

    public void setCharacters(List<PlayerCharacter> characters) {
        Characters = characters;
    }
}
