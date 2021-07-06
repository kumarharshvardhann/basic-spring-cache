package com.example.pathservice.service;

import com.example.pathservice.dao.PersonDao;
import com.example.pathservice.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames = {"Person"})
public class PersonService {

    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("fakeDao") PersonDao personDao) {
        this.personDao = personDao;
    }

    public int addPerson(Person person) {
        return personDao.addPerson(person);
    }

    public List<Person> getAllPeople()  {
        return personDao.selectAllPeople();
    }

    @Cacheable(key = "#name")
    public String getPersonByName(String name)  {
        return personDao.getPersonByName(name);
    }
}
