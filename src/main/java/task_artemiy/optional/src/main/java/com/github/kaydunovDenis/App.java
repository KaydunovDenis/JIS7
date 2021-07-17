package com.github.kaydunovDenis;

import com.github.kaydunovDenis.model.Lecturer;
import com.github.kaydunovDenis.model.Student;
import com.github.kaydunovDenis.service.LecturerServiceImpl;
import com.github.kaydunovDenis.service.PersonService;
import com.github.kaydunovDenis.service.PersonServiceImpl;
import lombok.extern.log4j.Log4j;

@Log4j
public class App {
    private static final LecturerServiceImpl lecturerService = new LecturerServiceImpl();
    private static final PersonService updateService = new PersonServiceImpl();

    public static void main(String[] args) {
        Lecturer lecturer = new Lecturer("Leonid", "Borda", 33);

        Student student1 = new Student("Denis", "Kaydunov", 31);
        Student student2 = new Student("Katya", "Belva", 19);
        Student student3 = new Student("Artemiy", "Stankevich", 33);

        Student studentError1 = new Student(null, "Marrow", 27);
        Student studentError2 = new Student("Andrey", "Marrow", 0);
        Student studentError3 = new Student("Alex", "Marrow", null);

        //1
        lecturerService.addStudent(lecturer, student1);
        lecturerService.addStudents(lecturer, student2, student3, studentError1, studentError2, studentError3);
        log.info(lecturer);

        //2
        updateService.updatePerson(lecturer, "Amity", "Sketch", 34);
        updateService.updatePerson(student2, "Den", "Stench", 34);
        //updateService.updatePerson(lecturer1, null, "Sketch", 34); бросает NullDataException


        //3
        log.info(lecturerService.getStudentByName(lecturer, "Denis"));
        //log.info(lecturerService.getStudentByName(lecturer1, "Deniss").get()); бросает NotFoundStudentException

        log.info(lecturer);



    }
}

