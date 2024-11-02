package com.university.student;

import java.util.*;

public class Student {

    private String name;
    private String studentEmail;
    private List<String> subjectsenlisted;


    public Student(String name, String studentEmail) {
        this.subjectsenlisted = new ArrayList<>() {
        };
        this.name = name;
        this.studentEmail = studentEmail;
    }

    //getters

    public String getName() {
        return name;
    }


    public int getSubjectsamount() {return subjectsenlisted.size();}

    public List<String> getSubjects() {
        return subjectsenlisted;
    }


    //adders

    public void addSubject(String subject) {
        if (!subjectsenlisted.contains(subject)) {
            subjectsenlisted.add(subject);  // Crear una nueva lista de cadenas
        }
    }



    //identity

    public int hashCode() {
        return Objects.hash(name);
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return Objects.equals(name, student.name);
}

}