package com.github.kaydunovDenis.service;

import com.github.kaydunovDenis.exception.NotFoundIdException;
import com.github.kaydunovDenis.exception.NullDataException;
import com.github.kaydunovDenis.exception.NotFoundStudentException;
import com.github.kaydunovDenis.model.Lecturer;
import com.github.kaydunovDenis.model.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.java.Log;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

@Data
@AllArgsConstructor
@Log
public class LecturerServiceImpl implements LecturerService {
    public static final String MESSAGE_NULL_DATA =
            "First name, last name should not be null and Age not equal to zero";

    @Override
    public void addStudent(Lecturer lecturer, Student student) {
        if (validateEmptyValue(student)) {
            throw new NullDataException(MESSAGE_NULL_DATA);
        }
        lecturer.getStudents().add(student);
    }

    @Override
    public void addStudents(Lecturer lecturer, Student... students) {
        Arrays.stream(students)
                .forEach(it -> addStudents(lecturer, it));
    }

    private boolean validateEmptyValue(Student student) {
        return Objects.isNull(student.getFirstName()) ||
                Objects.isNull(student.getLastName()) ||
                student.getAge() == 0;
    }

    @Override
    public Optional<Student> getUserByName(Lecturer lecturer, String firstName) {
        return Optional.ofNullable(lecturer.getStudents().stream()
                .filter(it -> it.getFirstName().equals(firstName))
                .findFirst()
                .orElseThrow(() -> new NotFoundStudentException(String.format("Lecturer %s not found", firstName))));
    }

    @Override
    public void showAllStudents(Lecturer lecturer) {
        StringBuilder result = new StringBuilder("Students of lecturer ")
                .append(lecturer.getFirstName())
                .append(" ")
                .append(lecturer.getLastName())
                .append(":\n");
        lecturer.getStudents().stream()
                .peek(it -> result.append(it.toString()));
        log.info(result.toString());
    }

    @Override
    public void updateStudent(Lecturer lecturer, Long idStudent, String newFirstName, String newLastName, Integer newAge) {
        lecturer.getStudents().stream()
                .filter(it -> it.getId().equals(idStudent))
                .findFirst()
                .orElseThrow(() -> new NotFoundIdException(
                        String.format("Student with ID - %s not found.", idStudent)));
    }
}
