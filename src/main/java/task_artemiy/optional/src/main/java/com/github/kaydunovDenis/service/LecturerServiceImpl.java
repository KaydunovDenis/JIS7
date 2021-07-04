package com.github.kaydunovDenis.service;

import com.github.kaydunovDenis.exception.NullDataException;
import com.github.kaydunovDenis.model.Lecturer;
import com.github.kaydunovDenis.model.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LecturerServiceImpl implements LecturerService {
    public static final String MESSAGE_NULL_DATA =
            "First name, last name should not be null and Age not equal to zero";

    @Override
    public void addStudent(Lecturer lecturer, Student student) {
        if (validateEmptyValue(student)) {
            lecturer.getStudents().add(student);
        } else {
            throw new NullDataException(MESSAGE_NULL_DATA);
        }
    }

    private boolean validateEmptyValue(Student student) {
        return Objects.isNull(student.getFirstName()) ||
                Objects.isNull(student.getLastName()) ||
                student.getAge() == 0;
    }

    @Override
    public Optional<Student> getUserByName() {
        //TODO
        return Optional.empty();
    }
}
