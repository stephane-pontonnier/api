package fr.afpa.brive.cda.api.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.afpa.brive.cda.api.model.Person;
import fr.afpa.brive.cda.api.service.PersonService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
public class PersonController {
    @Autowired
    private PersonService personService;

    @PostMapping("/person")
    public Person createPerson(@RequestBody Person person) {
        return personService.savePerson(person);
    }

    @GetMapping("/persons")
    public Iterable<Person> getPersons() {
        return personService.getPersons();
    }

    @GetMapping("/persons/{id}")
    public Person getPerson(@PathVariable("id") int id) {
        Optional<Person> person = personService.getPerson(id);
        if (person.isPresent()) {
            return person.get();
        } else {
            return null;
        }
        
    }

    @PutMapping("/person/{id}")
    public Person updatePerson(@PathVariable int id, @RequestBody Person person) {
        
        Optional<Person> e = personService.getPerson(id);

        if (e.isPresent()) {
            Person current = e.get();
            String firstname = person.getFirstname();
            if (firstname != null) {
                current.setFirstname(firstname);
            }

            String lastName = person.getLastname();
            if (lastName != null) {
                current.setLastname(lastName);
            }

            personService.savePerson(current);
            return current;

        } else {
            return null;
        }

    }
    
    @DeleteMapping("/person/{id}")
    public void deletePerson(@PathVariable("id") int id){
        personService.deletePerson(id);
    }
    
}
