package com.university;

import com.university.student.Student;
import com.university.course.*;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class University {

    public static Map<String, Student> studentByName = new HashMap<>();
    public static Map<Student, Map<String, Course>> coursesbystudent = new HashMap<>();

}
