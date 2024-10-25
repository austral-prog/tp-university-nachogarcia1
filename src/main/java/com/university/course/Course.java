package com.university.course;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Course {

    String name;
    List<String> classrooms;



    public Course(String name) {
        this.name = name;
        this.classrooms = new ArrayList<>();

    }

    //getter

    public String getSubject() {
        return name;
    }

    //identity


    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Course subject = (Course) obj;
        return Objects.equals(name, subject.name);
}


}