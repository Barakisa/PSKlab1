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

    private int length;


    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    private String name;
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    private Person dungeonMaster;

    @ManyToOne(fetch = FetchType.EAGER)
    public Person getDungeonMaster() {
        return dungeonMaster;
    }

    public void setDungeonMaster(Person dungeonMaster) {
        this.dungeonMaster = dungeonMaster;
    }
}
