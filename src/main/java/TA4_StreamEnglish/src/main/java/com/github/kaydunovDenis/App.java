package com.github.kaydunovDenis;

import com.github.kaydunovDenis.model.Person;
import com.github.kaydunovDenis.repository.PersonRepository;
import com.github.kaydunovDenis.service.PersonService;
import com.github.kaydunovDenis.service.PersonServiceImpl;
import lombok.extern.java.Log;

@Log
public class App {
    public static void main(String[] args) {
        PersonService personService = new PersonServiceImpl();
        PersonRepository.initialize();
        PersonRepository.getPersons().forEach(it -> log.info(it.toString()));

        log.info("Persons has English > 50%");
        personService.findBestMatchingPersons(
                PersonRepository.getPersons(), "English", 50).forEach(it->log.info(it.toString()));

        log.info("Best Person has Kannada");
        Person person = personService.findBestMatchingPerson(PersonRepository.getPersons(), "Kannada");
        log.info(person.toString());
    }
}




