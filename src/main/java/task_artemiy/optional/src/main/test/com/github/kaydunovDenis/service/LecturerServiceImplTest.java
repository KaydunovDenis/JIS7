package com.github.kaydunovDenis.service;

import com.github.kaydunovDenis.model.Lecturer;
import com.github.kaydunovDenis.model.Student;
import org.junit.Assert;
import org.junit.Test;

public class LecturerServiceImplTest {
    private LecturerService service = new LecturerServiceImpl();

    private Lecturer lecturer = new Lecturer("Ogrimar", "Orc", 46);

    private Student student1 = new Student("Student", "Univers", 21);
    private Student student2 = new Student("Nikolas", "Torro", 26);
    private Student studentError1 = new Student("Stud1", null, 46);
    private Student studentError2 = new Student("Stud2", "Ivanov", 0);

    @Test
    public void addStudent() {
        int expectedCountStudent = 1;
        service.addStudent(lecturer, student1);
        int resultCountStudent = lecturer.getStudents().size();
        Assert.assertEquals(expectedCountStudent, resultCountStudent);

        service.addStudent(lecturer, studentError1);
        resultCountStudent = lecturer.getStudents().size();
        Assert.assertEquals(expectedCountStudent, resultCountStudent);

        service.addStudent(lecturer, studentError2);
        resultCountStudent = lecturer.getStudents().size();
        Assert.assertEquals(expectedCountStudent, resultCountStudent);

        service.addStudent(lecturer, student2);
        resultCountStudent = lecturer.getStudents().size();
        Assert.assertNotEquals(expectedCountStudent, resultCountStudent);
    }

    @Test
    public void addStudents() {
    }

    @Test
    public void getUserByName() {
    }
}