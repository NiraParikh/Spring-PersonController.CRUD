package io.zipcoder.crudapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leon on 08/01/2019.
 */
@RestController
public class PersonController {
    @Autowired
    private PersonRepository repository;

    @PostMapping("/people")
    Person createPerson(@RequestBody Person p) {
        repository.save(p);
        return p;
    }

    @GetMapping("/people")
    Iterable<Person> getPersonList() {
        return repository.findAll();
    }

    @GetMapping("/people/{id}")
    Person getPerson(@PathVariable int id) {
        return repository.findOne(id);
    }

    @PutMapping("/people/{id}")
    Person updatePerson(@PathVariable int id, @RequestBody Person p) {
        Person personToBeUpdated = getPerson(id);
        personToBeUpdated.setFirstName(p.getFirstName());
        personToBeUpdated.setLastName(p.getLastName());
        repository.save(personToBeUpdated);
        return personToBeUpdated;
    }

    @DeleteMapping("/people/{id}")
    void DeletePerson(@PathVariable int id) {
        repository.delete(id);
    }
}
