package fr.afpa.brive.cda.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.afpa.brive.cda.api.model.Person;

@Repository
public interface PersonRepository extends CrudRepository <Person, Integer> {

}
