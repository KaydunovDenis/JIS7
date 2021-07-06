package com.github.kaydunovDenis.service;

import com.github.kaydunovDenis.model.Lecturer;
import com.github.kaydunovDenis.model.Student;

import java.util.Optional;

public interface LecturerService {

    void addStudent(Lecturer lecturer, Student student);

    void addStudents(Lecturer lecturer, Student... students);

    Optional<Student> getUserByName(Lecturer lecturer, String firstName);

    void showAllStudents(Lecturer lecturer);

    void updateStudent(Lecturer lecturer, Long idStudent, String newFirstName, String newLastName, Integer newAge);
}
