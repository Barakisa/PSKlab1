package org.example.lab1.usecases;

import lombok.Getter;
import lombok.Setter;
import org.example.lab1.mybatis.model.Person;
import org.example.lab1.mybatis.dao.PersonMapper;
import org.example.lab1.persistence.PeopleDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Model
public class PeopleMyBatis implements Serializable {
    @Inject
    private PersonMapper personMapper;

    @Getter @Setter
    private Person personToCreate = new Person();

    @Getter
    private List<Person> allPeople;

    @PostConstruct
    public void init(){ loadAllPeople(); }

    @Transactional
    public void createPerson(){
        this.personMapper.insert(personToCreate);
    }

    private void loadAllPeople(){
        this.allPeople = personMapper.selectAll();
    }
}
