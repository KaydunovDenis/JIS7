package com.github.kaydunovDenis;

import com.github.kaydunovDenis.model.Person;
import com.github.kaydunovDenis.repository.PersonRepository;
import com.github.kaydunovDenis.service.PersonService;
import com.github.kaydunovDenis.service.PersonServiceImpl;
import lombok.extern.java.Log;

@Log
public class FindPersonServiceDemo {
    public static void main(String[] args) {
        PersonService personService = new PersonServiceImpl();
        PersonRepository.initialize();
        PersonRepository.getPersons().forEach(System.out::println);

        log.info("Persons has English > 50%");
        personService.findBestMatchingPersons(
                PersonRepository.getPersons(), "English", 50).forEach(System.out::println);

        log.info("Best Person has Kannada");
        Person person = personService.findBestMatchingPerson(PersonRepository.getPersons(), "Kannada");
        log.info(person.toString());
    }
}




