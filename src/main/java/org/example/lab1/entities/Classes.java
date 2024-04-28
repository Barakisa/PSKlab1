package org.example.lab1.entities;

import lombok.Getter;
import lombok.Setter;

import javax.naming.Name;
import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Classes.findAll", query = "select c from Classes as c")
})
@Getter @Setter
public class Classes {
    public Classes(){
    }

    private String Title;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @ManyToMany(mappedBy = "chosenClasses")
    private List<PlayerCharacter> Characters;


    @Override
    public int hashCode() {

        return Objects.hash(Title);
    }
}
