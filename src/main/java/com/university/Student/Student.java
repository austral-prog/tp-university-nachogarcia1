package com.university.Student;

import com.university.Course.Course;

import java.util.*;

public class Student {

    private String name;
    private String studentEmail;
    private List<String> subjects;
    private HashMap<String, List<String>> assesments;


    public Student(String name, String studentEmail) {
        this.subjects = new ArrayList<>();
        this.name = name;
        this.studentEmail = studentEmail;
    }

    //getters

    public String getName() {
        return name;
    }

    public String getAssesments() {return assesments.toString();}

    public int getSubjects() {return subjects.size();}


    //adders

    public void addSubject(String subject) {
        if (!subjects.contains(subject)) {
            subjects.add(subject);
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