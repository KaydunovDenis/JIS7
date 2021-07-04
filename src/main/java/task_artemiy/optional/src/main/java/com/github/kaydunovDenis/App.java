package com.github.kaydunovDenis;

import com.github.kaydunovDenis.model.Lecturer;
import com.github.kaydunovDenis.model.Student;
import com.github.kaydunovDenis.service.LecturerServiceImpl;

public class App {
    public static void main(String[] args) {
        LecturerServiceImpl service = new LecturerServiceImpl();

        Lecturer lecturer1 = new Lecturer("Artemiy", "Stankevich", 33);
        Lecturer lecturer2 = new Lecturer("Maksim", "Shelkovich", 35);
        Lecturer lecturer3 = new Lecturer("Anton", "Glomozda", 25);

        Student student1 = new Student("Denis", "Kaydunov", 31);
        Student student2 = new Student("Katya", "Bulova", 19);
        Student student3 = new Student("Artemiy", "Stankevich", 33);
        Student student4 = new Student("Maksim", "Shelkovich", 35);
        Student student5 = new Student("Vlad", "Dragon", 29);
        Student student6 = new Student("Alexander", "Matckevich", 33);
        Student student7 = new Student("Alexander", "Matckevich", 27);




    }
}

