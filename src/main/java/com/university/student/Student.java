package com.university.student;

import java.util.*;

public class Student {

    private String name;
    private String studentEmail;
    private HashMap<String, List<String>> subjects;


    public Student(String name, String studentEmail) {
        this.subjects = new HashMap<>();
        this.name = name;
        this.studentEmail = studentEmail;
    }

    //getters

    public String getName() {
        return name;
    }


    public int getSubjectsamount() {return subjects.size();}


    //adders

    public void addSubject(String subject) {
        if (!subjects.containsKey(subject)) {
            subjects.put(subject, new ArrayList<String>());  // Crear una nueva lista de cadenas
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