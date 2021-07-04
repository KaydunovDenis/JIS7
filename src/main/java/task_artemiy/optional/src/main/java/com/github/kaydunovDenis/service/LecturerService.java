package com.github.kaydunovDenis.service;

import com.github.kaydunovDenis.model.Lecturer;
import com.github.kaydunovDenis.model.Student;

import java.util.Optional;

public interface LecturerService {

    void addStudent(Lecturer lecturer, Student student);

    Optional<Student> getUserByName();
}
