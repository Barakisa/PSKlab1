package org.example.lab1.rest.contracts;

import java.util.List;
public class PersonDto {
    private String name;
    private String surname;
    private List<String> characters;
    private List<String> campaigns;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<String> getCharacters() {
        return characters;
    }

    public void setCharacters(List<String> characters) {
        this.characters = characters;
    }

    public List<String> getCampaigns() {
        return campaigns;
    }

    public void setCampaigns(List<String> campaigns) {
        this.campaigns = campaigns;
    }
}
