package com.github.kaydunovDenis.service;

import com.github.kaydunovDenis.exception.NotFoundStudentException;
import com.github.kaydunovDenis.model.Lecturer;
import com.github.kaydunovDenis.model.Student;
import lombok.Data;
import lombok.extern.java.Log;

import java.util.Arrays;
import java.util.Optional;

import static com.github.kaydunovDenis.service.PersonValidator.validate;

@Log
public class LecturerServiceImpl implements LecturerService {
    @Override
    public void addStudent(Lecturer lecturer, Student student) {
        if (validate(student)) {
            lecturer.getStudents().add(student);
        }
    }

    @Override
    public void addStudents(Lecturer lecturer, Student... students) {
        Arrays.stream(students)
                .forEach(it -> addStudents(lecturer, it));
    }

    @Override
    public Optional<Student> getUserByName(Lecturer lecturer, String firstName) {
        return Optional.ofNullable(lecturer.getStudents().stream()
                .filter(it -> it.getFirstName().equals(firstName))
                .findFirst()
                .orElseThrow(() -> new NotFoundStudentException(String.format("Lecturer %s not found", firstName))));
    }
}
