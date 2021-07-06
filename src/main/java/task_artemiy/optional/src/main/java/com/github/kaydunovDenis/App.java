package com.github.kaydunovDenis;

import com.github.kaydunovDenis.model.Lecturer;
import com.github.kaydunovDenis.model.Student;
import com.github.kaydunovDenis.service.LecturerServiceImpl;
import com.github.kaydunovDenis.service.PersonService;
import com.github.kaydunovDenis.service.PersonServiceImpl;
import lombok.extern.log4j.Log4j;

@Log4j
public class App {
    public static void main(String[] args) {
        LecturerServiceImpl lecturerService = new LecturerServiceImpl();

        Lecturer lecturer1 = new Lecturer("Artemiy", "Stankevich", 33);
        Lecturer lecturer2 = new Lecturer("Maksim", "Shelkovich", 35);

        Student student1 = new Student("Denis", "Kaydunov", 31);
        Student student2 = new Student("Katya", "Bulova", 19);
        Student student3 = new Student("Artemiy", "Stankevich", 33);
        Student student4 = new Student("Alex", "Matukevich", 27);
        Student student5 = new Student("Vlad", "Dragon", 29);
        Student student6 = new Student("Alexander", "Matckevich", 33);
        Student studentError1 = new Student(null, "Marro", 27);
        Student studentError2 = new Student("Andrey", "Marro", 0);
        Student studentError3 = new Student("Alex", "Marro", null);

        lecturerService.addStudent(lecturer1, student1);
        lecturerService.addStudent(lecturer1, student2);
        lecturerService.addStudent(lecturer1, studentError1);//Почему программа стопится ведь
        //runtimeexeption  можно не отлавливать...?????????
        //lecturerService.addStudent(lecturer1, studentError2);
        //lecturerService.addStudent(lecturer1, studentError3);
        lecturerService.addStudent(lecturer1, student5);
        lecturerService.addStudent(lecturer1, student6);

        lecturerService.addStudent(lecturer2, student1);
        lecturerService.addStudent(lecturer2, student2);
        lecturerService.addStudent(lecturer2, student3);
        lecturerService.addStudent(lecturer2, student5);
        lecturerService.addStudent(lecturer2, student6);
        lecturerService.addStudent(lecturer2, student4);

        lecturerService.showAllStudents(lecturer1);//почему не работает???!!!
        lecturerService.showAllStudents(lecturer2);

        PersonService updateService = new PersonServiceImpl();
        updateService.updatePerson(lecturer1, "Artemiy", "Stankevich", 34);
        updateService.updatePerson(student3, "Artemiy", "Stankevich", 34);
        //updateService.updatePerson(student2, "null", "Stanevich", 34);


    }
}

