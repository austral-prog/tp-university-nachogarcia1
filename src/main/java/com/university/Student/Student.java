package com.university.Student;

import com.university.Course.Course;

import java.util.*;

public class Student {

    private String name;
    private String studentEmail;
    private HashMap<String, List<String>> courses;


    public Student(String name, String studentEmail) {
        this.name = name;
        this.studentEmail = studentEmail;
    }

    public String getName() {
        return name;
    }

    public int getCoursesAmount(){
        return courses.size();
    }

    public HashMap<String, List<String>> getCourses() {return courses;}

    public void addCourse(String subject, String classroom) {
        if (!courses.containsKey(subject)) {
            courses.put(subject, new ArrayList<>());
            courses.get(subject).add(classroom);
        }
    }
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