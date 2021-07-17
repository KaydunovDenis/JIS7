package com.github.kaydunovDenis;

import com.github.kaydunovDenis.repository.PersonRepository;
import com.github.kaydunovDenis.service.PersonService;
import com.github.kaydunovDenis.service.PersonServiceImpl;
import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "App")
public class App {
    public static void main(String[] args) {
        PersonService personService = new PersonServiceImpl();
        PersonRepository.initialize();
        PersonRepository.getPersons().forEach(it -> log.info(it.toString()));

        personService.findBestMatchingPersons(
                PersonRepository.getPersons(), "English", 50);//.forEach(it->log.info(it.toString()));

        personService.findBestMatchingPerson(PersonRepository.getPersons(), "Kannada");
    }
}




