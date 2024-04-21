package org.example.lab1.entities;

import javax.persistence.*;

@Entity
public class Campaign {
    private Long id;

    @GeneratedValue
    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String length;


    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    private Person dungeonMaster;

    @ManyToOne(fetch = FetchType.EAGER)
    public Person getDungeonMaster() {
        return dungeonMaster;
    }

    public void setDungeonMaster(Person dungeonMaster) {
        this.dungeonMaster = dungeonMaster;
    }
}
