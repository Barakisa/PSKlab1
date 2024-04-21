package org.example.lab1.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Person {
    private Long id;

    @GeneratedValue
    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String Name;

    @Basic(optional = false)
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    private String Surname;

    @Basic(optional = false)
    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    private List<Campaign> Campaigns;

    @OneToMany(mappedBy = "dungeonMaster", fetch = FetchType.EAGER)
    public List<Campaign> getCampaigns() {
        return Campaigns;
    }

    public void setCampaigns(List<Campaign> campaigns) {
        Campaigns = campaigns;
    }
}
