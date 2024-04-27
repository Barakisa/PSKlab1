package org.example.lab1.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Campaign.findAll", query = "select c from Campaign as c")
})
@Table(name = "CAMPAIGN")
public class Campaign {
    public Campaign(){
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "LENGTH")
    private Integer length;

    @Size(max = 50)
    @Column(name = "NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name="DUNGEON_MASTER_ID")
    private Person dungeonMaster;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getDungeonMaster() {
        return dungeonMaster;
    }

    public void setDungeonMaster(Person dungeonMaster) {
        this.dungeonMaster = dungeonMaster;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Campaign campaing = (Campaign) o;
        return Objects.equals(id, campaing.id) &&
                Objects.equals(name, campaing.name);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
