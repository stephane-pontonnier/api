package fr.afpa.brive.cda.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afpa.brive.cda.api.model.Person;
import fr.afpa.brive.cda.api.repository.PersonRepository;
import lombok.Data;

@Data
@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public Optional<Person> getPerson (int id){
        return personRepository.findById(id);
    }

    public Iterable<Person> getPersons(){
        return personRepository.findAll();
    }

    public void deletePerson(int id){
        personRepository.deleteById(id);
    }

    public Person savePerson(Person person){
        Person savedPerson = personRepository.save(person);
        return savedPerson;

    }

}
