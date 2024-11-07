package com.university;

import com.university.mainobjects.Course;
import com.university.mainobjects.Student;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class University {

    public static Map<String, Student> studentByName = new HashMap<>();
    public static Map<Student, List<Course>> coursesbystudent = new HashMap<>();

}
