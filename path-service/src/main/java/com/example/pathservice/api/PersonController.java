package com.example.pathservice.api;

import com.example.pathservice.model.Person;
import com.example.pathservice.service.PersonService;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@RequestBody Person person)    {
        personService.addPerson(person);
    }

    @GetMapping("/all")
    public List<Person> getAllPeople()  {
        return personService.getAllPeople();
    }

    @GetMapping("/{name}")
    public String getPersonByName(@PathVariable(value = "name") String name) {
        return personService.getPersonByName(name);
    }
}
