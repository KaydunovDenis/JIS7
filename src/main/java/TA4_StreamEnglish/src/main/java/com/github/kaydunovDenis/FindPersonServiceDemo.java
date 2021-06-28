package com.github.kaydunovDenis;

import static com.github.kaydunovDenis.repository.PersonRepository.getPersons;
import static com.github.kaydunovDenis.repository.PersonRepository.initialize;
import static com.github.kaydunovDenis.service.FindPersonService.findPersonWithBestProficiencyRequiredSkill;
import static com.github.kaydunovDenis.service.FindPersonService.findPersonsWithRequiredSkillAndProficiency;

public class FindPersonServiceDemo {
    public static void main(String[] args) {
        initialize();
        getPersons().forEach(System.out::println);

        System.out.println("Persons has English > 50%");
        findPersonsWithRequiredSkillAndProficiency(getPersons(), "English", 50).
                forEach(System.out::println);

        System.out.println("Best Person has Kannada");
        System.out.println(findPersonWithBestProficiencyRequiredSkill(getPersons(), "Kannada"));
    }
}




